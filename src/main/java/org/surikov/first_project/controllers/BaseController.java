package org.surikov.first_project.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.surikov.first_project.entities.data.Comment;
import org.surikov.first_project.entities.projects.Project;
import org.surikov.first_project.services.accounts.DesignerService;
import org.surikov.first_project.services.accounts.UserService;
import org.surikov.first_project.services.data.CommentService;
import org.surikov.first_project.services.projects.ProjectService;

import java.util.List;

@Controller
public class BaseController {

    private final CommentService commentService;
    private ProjectService projectService;
    private DesignerService designerService;
    private UserService userService;

    @Autowired
    public BaseController(ProjectService projectService, DesignerService designerService, UserService userService, CommentService commentService) {
        this.projectService = projectService;
        this.designerService = designerService;
        this.userService = userService;
        this.commentService = commentService;
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

        Comment comment = new Comment();
        Project project = projectService.findById(id);
        List<Comment> comments = commentService.findByProjectId(id);

        model.addAttribute("project", project);
        model.addAttribute("comments", comments);
        model.addAttribute("commentToForm", comment);
        return "project";

    }

    @PostMapping("/comment/{id}")
    public String commentProject(@PathVariable Long id, @ModelAttribute("commentToForm") Comment comment, HttpServletRequest request){
        comment.setProject(projectService.findById(id));

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String role = userDetails.getAuthorities().toString().replace("[", "").replace("]", "");

        if(role.equals("ROLE_USER")){
            comment.setUserAccount(userService.findByLogin(userDetails.getUsername()));
        }

        if(role.equals("ROLE_DESIGNER")){
            comment.setDesignerAccount(designerService.findDesignerByLogin(userDetails.getUsername()));
        }

        commentService.save(comment);
        String url = request.getHeader("Referer");
        return "redirect:" + url;
    }



}
