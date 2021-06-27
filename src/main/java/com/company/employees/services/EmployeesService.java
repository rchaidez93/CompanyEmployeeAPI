package com.company.employees.services;

import com.company.employees.controllers.EmployeesController;
import com.company.employees.models.Employees;
import com.company.employees.repositories.EmployeesRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeesService {

    @Autowired
    private EmployeesRepository employeesRepository;

    public Iterable<Employees> getEmployees() {
        return employeesRepository.findAll();
    }

    public Optional<Employees> getEmployeeById(long employee_id) {
        return employeesRepository.findById(employee_id);
    }

    public List<Employees> getEmployeesByCompanyId(long company_id) {
        return employeesRepository.findByCompanies_Id(company_id);
    }

    public void saveEmployee(Employees employee) {
        employeesRepository.save(employee);
    }

    public void deleteEmployeeById(long employee_id) {
        employeesRepository.deleteById(employee_id);
    }

    public void updateEmployee(Employees employees) {
        employeesRepository.save(employees);
    }
}
