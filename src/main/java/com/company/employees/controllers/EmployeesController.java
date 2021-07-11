package com.company.employees.controllers;

import com.company.employees.models.Employees;
import com.company.employees.services.EmployeesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
@Api(value = "Employees Management")
public class EmployeesController {
    Logger logger = LoggerFactory.getLogger(EmployeesController.class);

    @Autowired
    EmployeesService employeesService;

    @GetMapping("/get")
    @ApiOperation(value = "Get all existing employees", response = EmployeesController.class)
    public @ResponseBody
    Iterable<Employees> getAllEmployees() {
        logger.info("fetching all employees");
        return employeesService.getEmployees();
    }

    @GetMapping("/get/{employee_id}")
    @ApiOperation(value = "Get existing employee by id", response = EmployeesController.class)
    public @ResponseBody
    Optional<Employees> getEmployeeById(@PathVariable("employee_id" ) long employee_id){
        logger.info("Fetching employee by id");
        return employeesService.getEmployeeById(employee_id);
    }

    @GetMapping("/getByCompanyId/{company_id}")
    @ApiOperation(value = "Get all existing employees by company id", response = EmployeesController.class)
    public @ResponseBody
    Iterable<Employees> getEmployeesByCompanyId(@PathVariable("company_id") long company_id){
        logger.info("Fetching employees by company id");
        return employeesService.getEmployeesByCompanyId(company_id);
    }

    @PostMapping("/add")
    @ApiOperation(value = "Add a new employee", response = EmployeesController.class)
    public @ResponseBody String addEmployee(@RequestParam Integer company_id, @RequestParam String first_name, @RequestParam String last_name){
        Employees employees = new Employees();
        employees.setCompany_id(company_id);
        employees.setFirst_name(first_name);
        employees.setLast_name(last_name);
        logger.info("saving new employee: %s %s to company: %s", first_name, last_name, company_id);
        employeesService.saveEmployee(employees);
        return "Saved new employee";
    }

    @PutMapping("/update")
    @ApiOperation(value = "Update an employee", response = EmployeesController.class)
    public @ResponseBody String updateEmployee(@Validated @RequestBody Employees employees) {
        employeesService.updateEmployee(employees);
        return "Employee updated successfully";
    }

    @DeleteMapping("/delete/{employee_id}")
    @ApiOperation(value = "Delete an employee by id", response = EmployeesController.class)
    public @ResponseBody
    Iterable<Employees> deleteEmployee(@PathVariable("employee_id") long employee_id) {
        employeesService.deleteEmployeeById(employee_id);
        return employeesService.getEmployees();
    }

}
