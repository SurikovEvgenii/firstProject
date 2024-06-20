package org.surikov.first_project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.surikov.first_project.entities.accounts.DesignerAccount;
import org.surikov.first_project.entities.accounts.UserAccount;
import org.surikov.first_project.services.accounts.DesignerService;
import org.surikov.first_project.services.accounts.UserService;

@Controller
@RequestMapping("/authorization")
public class AuthorizationController {

    private DesignerService designerService;
    private UserService userService;

    @Autowired
    public AuthorizationController(DesignerService designerService, UserService userService) {
        this.designerService = designerService;
        this.userService = userService;
    }

    @GetMapping()
    public String showAuthorizationForm(){
        return "authorization";
    }

    @PostMapping("/user")
    public String authorizationUser(@RequestParam String login){
        UserAccount userAccount = userService.findUserByLogin(login);
        return "index";
    }

    @PostMapping("/designer")
    public String authorizationDesigner(@RequestParam String login){
        DesignerAccount designerAccount = designerService.findDesignerByLogin(login);
        return "index";
    }

}
