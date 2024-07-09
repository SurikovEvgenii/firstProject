package org.surikov.first_project.services.projects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.surikov.first_project.entities.projects.Project;
import org.surikov.first_project.repository.data.PhotoRepository;
import org.surikov.first_project.repository.projects.ProjectRepository;
import org.surikov.first_project.services.data.PhotoService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

@Service
public class ProjectService {

    private final PhotoService photoService;
    private final PhotoRepository photoRepository;
    private ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository, PhotoService photoService, PhotoRepository photoRepository) {
        this.projectRepository = projectRepository;
        this.photoService = photoService;
        this.photoRepository = photoRepository;
    }

    public ArrayList<Project> findAll() {
        ArrayList<Project> projects;
        projects = (ArrayList<Project>)projectRepository.findAll();
        return projects;
    }

    public ArrayList<Project> findAllRandom() {
        ArrayList<Project> projects;
        projects = (ArrayList<Project>)projectRepository.findAll();
        Collections.shuffle(projects);
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

    @Transactional
    public void remove(Project project) {
        photoRepository.deleteAll(project.getPhotoList());
        projectRepository.deleteById(project.getId());
    }


}
