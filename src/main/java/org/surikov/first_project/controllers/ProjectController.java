package org.surikov.first_project.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.surikov.first_project.entities.company.Category;
import org.surikov.first_project.entities.company.Company;
import org.surikov.first_project.entities.projects.Project;
import org.surikov.first_project.services.accounts.DesignerService;
import org.surikov.first_project.services.company.CategoryService;
import org.surikov.first_project.services.company.CompanyService;
import org.surikov.first_project.services.data.PhotoService;
import org.surikov.first_project.services.data.TagService;
import org.surikov.first_project.services.projects.ProjectService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


@Controller
public class ProjectController {

    private PhotoService photoService;
    private TagService tagService;
    private ProjectService projectService;
    private DesignerService designerService;
    private CompanyService companyService;
    private CategoryService categoryService;

    @Autowired
    public ProjectController(PhotoService photoService, TagService tagService, ProjectService projectService, DesignerService designerService, CompanyService companyService, CategoryService categoryService) {
        this.photoService = photoService;
        this.tagService = tagService;
        this.projectService = projectService;
        this.designerService = designerService;
        this.companyService = companyService;
        this.categoryService = categoryService;
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) throws JsonProcessingException {
        Project project = new Project();
        List<Category> categoryList = categoryService.getAllCategories();
        List<Company> companyList = companyService.getAllCompanies();

        model.addAttribute("tags",tagService.findAll());
        model.addAttribute("project",project);
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("companyList", companyList);

        return "create";
    }

    @PostMapping("/create")
    public String createProject(@ModelAttribute Project project, @RequestParam("photos")MultipartFile[] file){

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        project.setDesigner(designerService.findDesignerByLogin(userDetails.getUsername()));

        // Сохранение проекта без компаний, чтобы получить ID
        projectService.save(project);
        List<Company> companyList = project.getCompanyList();

        // Временный список для хранения компаний, которые нужно добавить
        List<Company> companiesToAdd = new ArrayList<>();

        // Добавление компаний в проект
        for (Company company : companyList) {
            try{
                Company existingCompany = companyService.findCompanyById(company.getId());
                companiesToAdd.add(existingCompany);
            } catch (NullPointerException e){
                continue;
            }
        }

        // Добавление всех компаний в проект после завершения итерации
        project.getCompanyList().clear();
        project.getCompanyList().addAll(companiesToAdd);

        // Сохранение проекта с обновленным списком компаний
        projectService.save(project);

        try {
            photoService.save(file, project);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return "redirect:/personal/designer/" + designerService.findDesignerByLogin(userDetails.getUsername()).getId();
    }

    @PostMapping("/project/delete/{id}")
    public String deleteProject(@PathVariable Long id, HttpServletRequest request){
        String url = request.getHeader("Referer");
        projectService.remove(projectService.findById(id));
        return "redirect:"+url;
    }

    @GetMapping("/project/update/{id}")
    public String updateProjectGetForm(@PathVariable Long id, Model model){
        Project project = projectService.findById(id);
        model.addAttribute("project",project);
        return "update";
    }

    @PostMapping("/project/update/{id}")
    public String updateProject(@PathVariable Long id, @ModelAttribute Project project, HttpServletRequest request){
        Project projectUpdate = projectService.findById(id);
        projectUpdate.setHeader(project.getHeader());
        projectUpdate.setDescription(project.getDescription());
        projectUpdate.setShortDescription(project.getShortDescription());
        projectService.save(projectUpdate);
        return "redirect:/personal/designer/" + projectUpdate.getDesigner().getId();
    }

}
