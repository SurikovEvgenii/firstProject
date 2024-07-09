package org.surikov.first_project.repository.company;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.surikov.first_project.entities.company.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
