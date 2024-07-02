package org.surikov.first_project.entities.accounts;

import jakarta.persistence.*;
import lombok.Data;
import org.surikov.first_project.entities.data.company.Product;

import java.util.List;

@Data
@Entity
@Table(name = "companies")
public class CompanyAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private String site;

    private String number;

    @OneToMany(mappedBy = "id")
    private List<Product> productList;

}
