package com.company.employees.controllers;

import com.company.employees.models.Companies;
import com.company.employees.services.CompaniesService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;


import java.util.List;
import java.util.Optional;

@SpringBootTest
public class CompaniesTest {

    @Autowired
    private CompaniesService companiesService;

    @Test
    public void addCompany(){
        Companies testCompany = new Companies();
        testCompany.setName("Test Company2");
        companiesService.saveCompany(testCompany);
        Optional<Companies> addedCompany = companiesService.getCompanyById(testCompany.getId());
        assertThat(addedCompany.get().getName()).isEqualTo("Test Company2");
    }

    @Test
    public void getCompanies() {
        Iterable<Companies> allCompanies = companiesService.getCompanies();
        assertThat(allCompanies).size().isGreaterThan(0);
    }

    @Test
    public void getCompanyById() {
        Optional<Companies> company = companiesService.getCompanyById(1L);
        assertNotNull(company);
    }

    @Test
    public void updateCompany() {
        Companies company = companiesService.getCompanyByName("Test Company2").get(0);
        company.setName("Two Wheels Everything");
        companiesService.saveCompany(company);

        Companies updatedCompany = companiesService.getCompanyByName("Two Wheels Everything").get(0);
        assertThat(updatedCompany.getName()).isEqualTo("Two Wheels Everything");
    }

    @Test
    public void deleteCompany(){
        Companies company = companiesService.getCompanyByName("Two Wheels Everything").get(0);
        companiesService.deleteCompany(company.getId());

        List<Companies> deletedCompany = companiesService.getCompanyByName("Two Wheels Everything");
        assertThat(deletedCompany).isEmpty();
    }
}
