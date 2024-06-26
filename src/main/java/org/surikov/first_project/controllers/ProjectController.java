package org.surikov.first_project.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.surikov.first_project.entities.projects.Project;
import org.surikov.first_project.services.accounts.DesignerService;
import org.surikov.first_project.services.data.PhotoService;
import org.surikov.first_project.services.data.TagService;
import org.surikov.first_project.services.projects.ProjectService;

import java.io.*;


@Controller
public class ProjectController {

    private PhotoService photoService;
    private TagService tagService;
    private ProjectService projectService;
    private DesignerService designerService;

    @Autowired
    public ProjectController(PhotoService photoService, TagService tagService, ProjectService projectService, DesignerService designerService) {
        this.photoService = photoService;
        this.tagService = tagService;
        this.projectService = projectService;
        this.designerService = designerService;
    }

    @GetMapping("/create")
    public String showCreateForm(Model model){
        Project project = new Project();
        model.addAttribute("tags",tagService.findAll());
        model.addAttribute("project",project);
        return "create";
    }

    @PostMapping("/create")
    public String createProject(@ModelAttribute Project project, @RequestParam("photos")MultipartFile[] file){

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        project.setDesigner(designerService.findDesignerByLogin(userDetails.getUsername()));
        projectService.save(project);

        try {
            photoService.save(file, project);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return "create";
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
        String url = request.getHeader("Referer");
        Project projectUpdate = projectService.findById(id);
        projectUpdate.setHeader(project.getHeader());
        projectUpdate.setDescription(project.getDescription());
        projectUpdate.setShortDescription(project.getShortDescription());
        projectService.save(projectUpdate);
        return "redirect:/personal/designer/"+project.getDesigner().getId();
    }

}
