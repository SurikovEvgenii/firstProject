package org.surikov.first_project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.surikov.first_project.entities.accounts.DesignerAccount;
import org.surikov.first_project.entities.accounts.UserAccount;
import org.surikov.first_project.entities.data.Role;
import org.surikov.first_project.services.accounts.DesignerService;
import org.surikov.first_project.services.accounts.UserService;
import org.surikov.first_project.services.data.RoleService;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    private DesignerService designerService;
    private UserService userService;
    private RoleService roleService;

    @Autowired
    public RegistrationController(DesignerService designerService, UserService userService, RoleService roleService) {
        this.designerService = designerService;
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping()
    public String showRegistrationForm(Model model){
        DesignerAccount designerAccount = new DesignerAccount();
        model.addAttribute("designer", designerAccount);
        UserAccount userAccount = new UserAccount();
        model.addAttribute("user", userAccount);
        return "registration";
    }

    @PostMapping("/designer")
    public String registrationDesigner(@ModelAttribute("designer")DesignerAccount designerAccount, Model model){
        designerAccount.setRole(roleService.findById(3L));
        designerService.save(designerAccount);
        Long id = designerAccount.getId();
        String url = "redirect:/designer/"+id;
        return url;
    }

    @PostMapping("/user")
    public String registrationUser(@ModelAttribute("user")UserAccount userAccount, Model model){
        userAccount.setRole(roleService.findById(2L));
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        userAccount.setPassword(passwordEncoder.encode(userAccount.getPassword()));
        userService.save(userAccount);
        return "redirect:/";
    }

}
