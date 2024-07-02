package org.surikov.first_project.entities.data;

import jakarta.persistence.*;
import lombok.Data;
import org.surikov.first_project.entities.accounts.DesignerAccount;

@Data
@Entity
public class ProfilePicture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String url;

    @OneToOne
    private DesignerAccount designerAccount;

}
