package org.surikov.first_project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.surikov.first_project.services.accounts.DesignerService;
import org.surikov.first_project.services.accounts.UserService;
import org.surikov.first_project.services.projects.ProjectService;

@Controller
@RequestMapping("/personal")
public class PersonalPageController {

    private UserService userService;
    private DesignerService designerService;
    private ProjectService projectService;

    @Autowired
    public PersonalPageController(UserService userService, DesignerService designerService, ProjectService projectService) {
        this.userService = userService;
        this.designerService = designerService;
        this.projectService = projectService;
    }

    @GetMapping("/designer/{id}")
    public String personalDesignerPage(@PathVariable Long id, Model model){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long checkId = designerService.findDesignerByLogin(userDetails.getUsername()).getId();
        model.addAttribute("project", projectService.findByDesignerId(checkId));
        if(checkId.equals(id)){
            return "personal";
        } else {
            return "redirect:/personal/designer/"+checkId;
        }

    }

    @GetMapping("/user/{id}")
    public String personalUserPage(@PathVariable Long id, Model model){
        return "personal";
    }
}
