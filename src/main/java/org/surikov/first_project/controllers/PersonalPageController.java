package org.surikov.first_project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.surikov.first_project.entities.data.ProfilePicture;
import org.surikov.first_project.services.accounts.DesignerService;
import org.surikov.first_project.services.accounts.UserService;
import org.surikov.first_project.services.data.ProfilePictureService;
import org.surikov.first_project.services.projects.ProjectService;

@Controller
@RequestMapping("/personal")
public class PersonalPageController {

    private UserService userService;
    private DesignerService designerService;
    private ProjectService projectService;
    private ProfilePictureService profilePictureService;

    @Autowired
    public PersonalPageController(UserService userService, DesignerService designerService, ProjectService projectService, ProfilePictureService profilePictureService) {
        this.userService = userService;
        this.designerService = designerService;
        this.projectService = projectService;
        this.profilePictureService = profilePictureService;
    }

    @GetMapping("/designer/{id}")
    public String personalDesignerPage(@PathVariable Long id, Model model){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long checkId = designerService.findDesignerByLogin(userDetails.getUsername()).getId();
        model.addAttribute("project", projectService.findByDesignerId(checkId));
        model.addAttribute("designer", designerService.findById(id));
        model.addAttribute("photo", new ProfilePicture());
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

    @PostMapping("/designer/profile-image/{id}")
    public String profileImage(@PathVariable Long id, @RequestParam("photo") MultipartFile[] file, Model model){
        profilePictureService.save(file, id);
        return "redirect:/personal/designer/"+id;
    }
}
