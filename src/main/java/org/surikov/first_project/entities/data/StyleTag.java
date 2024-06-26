package org.surikov.first_project.entities.data;

import jakarta.persistence.*;
import lombok.Data;
import org.surikov.first_project.entities.projects.Project;

import java.util.Set;

@Data
@Entity
@Table(name = "style_tags")
public class StyleTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String tagName;

    @OneToMany(mappedBy = "id")
    private Set<Project> project;
}
