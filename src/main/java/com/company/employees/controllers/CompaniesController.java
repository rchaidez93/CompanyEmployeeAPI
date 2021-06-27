package com.company.employees.controllers;

import com.company.employees.models.Companies;
import com.company.employees.services.CompaniesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/companies")
@Api(value = "Companies Management")
public class CompaniesController {
    Logger logger = LoggerFactory.getLogger(CompaniesController.class);

    @Autowired
    CompaniesService companiesService;


    @GetMapping("/get")
    @ApiOperation(value = "Get all existing companies", response = CompaniesController.class, notes = "There are no parameters needed")
    public @ResponseBody
    Iterable<Companies> getCompanies() {
        logger.info("fetching all companies");
        return companiesService.getCompanies();
    }

    @GetMapping("/get/{company_id}")
    @ApiOperation(value = "Get a company by id", response = CompaniesController.class, notes = "company_id needed as a parameter")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully found a company by id"),
            @ApiResponse(code = 401, message = "Not authorized to see companies"),
            @ApiResponse(code = 403, message = "Accessing companies is forbidden"),
            @ApiResponse(code = 404, message = "The company id you are searching for is not found"),
    })
    public @ResponseBody
    Optional<Companies> getCompany(@PathVariable("company_id") long company_id) {
        logger.info("fetching company by id");

        return companiesService.getCompanyById(company_id);
    }


    @PostMapping("/add")
    @ApiOperation(value = "Add a new company", response = CompaniesController.class, notes = "No body parameters needed")
    public @ResponseBody
    String addNewCompany(@RequestParam String name) {
        logger.info("saving new company %s", name);
        Companies company = new Companies();
        company.setName(name);
        Companies companies = companiesService.saveCompany(company);
        logger.info("save result %s", companies.toString());
        return "Saved new company";
    }

    @PutMapping("/update")
    @ApiOperation(value = "Update an existing company", response = CompaniesController.class)
    public @ResponseBody String updateCompany(@Validated @RequestBody Companies companies) {
        logger.info("Updating company with id %dL", companies.getId());
        companiesService.updateCompany(companies);
        return "Updated Company Successfully";
    }

    @DeleteMapping("/delete/{company_id}")
    @ApiOperation(value= "Delete an existing company", response = CompaniesController.class)
    public @ResponseBody
    Iterable<Companies> deleteCompany(@PathVariable("company_id") long company_id) {
        logger.info("Deleting company: %dL", company_id);
        companiesService.deleteCompany(company_id);

        return companiesService.getCompanies();
    }
}
