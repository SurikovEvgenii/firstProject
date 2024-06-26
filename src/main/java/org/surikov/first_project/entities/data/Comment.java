package org.surikov.first_project.entities.data;

import jakarta.persistence.*;
import lombok.Data;
import org.surikov.first_project.entities.accounts.UserAccount;
import org.surikov.first_project.entities.projects.Project;

@Data
@Entity
@Table(name="comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String text;

    @ManyToOne
    private Project project;

    @ManyToOne
    private UserAccount userAccount;
}