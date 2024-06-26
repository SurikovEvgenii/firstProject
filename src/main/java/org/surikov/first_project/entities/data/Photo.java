package org.surikov.first_project.entities.data;

import jakarta.persistence.*;
import lombok.Data;
import org.apache.tomcat.util.codec.binary.Base64;
import org.surikov.first_project.entities.projects.Project;


@Data
@Entity
@Table(name="photos")
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String name;

    private String url;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;
}