package org.surikov.first_project.services.projects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.surikov.first_project.entities.projects.Project;
import org.surikov.first_project.repository.data.PhotoRepository;
import org.surikov.first_project.repository.projects.ProjectRepository;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ProjectService {

    private ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public ArrayList<Project> findAll() {
        ArrayList<Project> projects;
        projects = (ArrayList<Project>)projectRepository.findAll();
        return projects;
    }

    public Project findById(Long id){
        Optional<Project> project = projectRepository.findById(id);
        return project.get();
    }

    public ArrayList<Project> findByDesignerId(Long id){
        ArrayList<Project> projects;
        projects = projectRepository.findByDesignerId(id);
        return projects;
    }

    public void save(Project project) {
        projectRepository.save(project);
    }

    public void remove(Project project) {
        projectRepository.deleteById(project.getId());
    }


}
