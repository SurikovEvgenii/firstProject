package org.surikov.first_project.entities.data.company;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String price;

    private String url;

    @ManyToOne
    @JoinColumn(name = "products_id")
    private Category category;




}
