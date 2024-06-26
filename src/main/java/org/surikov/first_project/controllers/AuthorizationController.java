package org.surikov.first_project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/authorization")
public class AuthorizationController {

    @GetMapping()
    public String showAuthorizationForm(){
        return "authorization";
    }

}

