package org.surikov.first_project.entities.projects;

import jakarta.persistence.*;
import lombok.Data;
import org.surikov.first_project.entities.accounts.DesignerAccount;
import org.surikov.first_project.entities.data.Comment;
import org.surikov.first_project.entities.data.Photo;
import org.surikov.first_project.entities.data.StyleTag;

import java.util.List;

@Data
@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 120, nullable = false)
    private String header;

    @Column(length = 1000, columnDefinition = "TEXT")
    private String description;

    @Column(length = 200, columnDefinition = "TEXT")
    private String shortDescription;

    private Long likesCount = 0L;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Photo> photo;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private List<Comment> commentSet;

    @ManyToOne
    private DesignerAccount designer;

    @ManyToOne
    private StyleTag tag;

}
