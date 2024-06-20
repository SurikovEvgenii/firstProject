package org.surikov.first_project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.surikov.first_project.entities.projects.Project;
import org.surikov.first_project.services.accounts.DesignerService;
import org.surikov.first_project.services.data.PhotoService;
import org.surikov.first_project.services.data.TagService;
import org.surikov.first_project.services.projects.ProjectService;

import java.io.IOException;


@Controller
@RequestMapping("/create")
public class CreateProjectController {

    private PhotoService photoService;
    private TagService tagService;
    private ProjectService projectService;
    private DesignerService designerService;

    @Autowired
    public CreateProjectController(PhotoService photoService, TagService tagService, ProjectService projectService, DesignerService designerService) {
        this.photoService = photoService;
        this.tagService = tagService;
        this.projectService = projectService;
        this.designerService = designerService;
    }

    @GetMapping()
    public String getData(Model model){
        Project project = new Project();
        model.addAttribute("tags",tagService.findAll());
        model.addAttribute("project",project);
        return "create";
    }

    @PostMapping()
    public String create(@ModelAttribute Project project, @RequestParam("photos")MultipartFile[] file){

        project.setDesigner(designerService.findById(1L));
        projectService.save(project);

        try {
            photoService.save(file, project);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return "create";
    }


}
