package com.company.employees.repositories;

import com.company.employees.models.Employees;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeesRepository extends CrudRepository<Employees, Long> {
    @Query("select e from Employees e left outer join Companies c on e.company_id=c.id where e.company_id = :company_id")
    public List<Employees> findByCompanies_Id(@Param("company_id") Long company_id);
}
