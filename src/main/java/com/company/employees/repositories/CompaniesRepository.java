package com.company.employees.repositories;

import com.company.employees.models.Companies;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CompaniesRepository extends CrudRepository<Companies, Long> {
    List<Companies> findByName(String name);
}
