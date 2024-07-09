package org.surikov.first_project.services.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.surikov.first_project.entities.company.Company;
import org.surikov.first_project.entities.projects.Project;
import org.surikov.first_project.repository.company.CompanyRepository;

import java.util.List;

@Service
public class CompanyService {

    private CompanyRepository companyRepository;

    @Autowired
    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    public Company findCompanyById(Long id) {
        return companyRepository.findById(id).get();
    }

}
