package org.surikov.first_project.repository.company;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.surikov.first_project.entities.company.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
}
