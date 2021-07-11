package com.company.employees.services;

import com.company.employees.models.Companies;
import com.company.employees.repositories.CompaniesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompaniesService {

    @Autowired
    CompaniesRepository companiesRepository;

    public Iterable<Companies> getCompanies(){
        return companiesRepository.findAll();
    }

    public Companies saveCompany(Companies company) {
        return companiesRepository.save(company);
    }

    public Optional<Companies> getCompanyById(Long companyId) {
        Optional<Companies> company = companiesRepository.findById(companyId);
        System.out.println(company);

        return company;
    }

    public void deleteCompany(long company_id) {
        companiesRepository.deleteById(company_id);
    }

    public void updateCompany(Companies companies) {
        companiesRepository.save(companies);
    }

    public List<Companies> getCompanyByName(String name){
        return companiesRepository.findByName(name);
    }
}
