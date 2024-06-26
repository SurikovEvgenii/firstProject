package org.surikov.first_project.repository.projects;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.surikov.first_project.entities.projects.Project;

import java.util.ArrayList;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    ArrayList<Project> findByDesignerId(Long designerId);
}
