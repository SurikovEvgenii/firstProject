package org.surikov.first_project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.surikov.first_project.entities.projects.Project;
import org.surikov.first_project.services.accounts.DesignerService;
import org.surikov.first_project.services.accounts.UserService;
import org.surikov.first_project.services.projects.ProjectService;

import java.security.Principal;


@Controller
public class BaseController {

    private ProjectService projectService;
    private DesignerService designerService;
    private UserService userService;

    @Autowired
    public BaseController(ProjectService projectService, DesignerService designerService, UserService userService) {
        this.projectService = projectService;
        this.designerService = designerService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String index(Model model){
        try {
            UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String role = userDetails.getAuthorities().toString().replace("[", "").replace("]", "");

            if(role.equals("ROLE_USER")){
                Long id = userService.findByLogin(userDetails.getUsername()).getId();
                model.addAttribute("id", id);
            }

            if(role.equals("ROLE_DESIGNER")){
                Long id = designerService.findDesignerByLogin(userDetails.getUsername()).getId();
                model.addAttribute("id", id);
            }


        } catch (Exception e){}

        model.addAttribute("project", projectService.findAll());

        return "index";
    }

    @PostMapping("/like")
    public ResponseEntity<String> indexLikeProject(@RequestParam("projectId") Long projectId){
        Project project = projectService.findById(projectId);
        project.setLikesCount(project.getLikesCount() + 1);
        projectService.save(project);
        return ResponseEntity.ok(String.valueOf(project.getLikesCount()));

    }

    @GetMapping("/designer/{id}")
    public String designerPage(@PathVariable Long id, Model model){
        model.addAttribute("designer", designerService.findById(id));
        model.addAttribute("project", projectService.findByDesignerId(id));
        return "designer";
    }

    @GetMapping("/designer/project/{id}")
    public String projectPage(@PathVariable Long id, Model model){
        model.addAttribute("project", projectService.findById(id));
        return "project";
    }



}
