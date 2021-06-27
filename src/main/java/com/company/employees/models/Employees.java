package com.company.employees.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@ApiModel(value = "Employees", description = "Class representing employees associated with a company id")
public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(notes = "Unique identifier of the employee", example = "1", required = true)
    private long id;

    @ApiModelProperty(notes = "Unique company id the employee belongs to", example = "1", required = true)
    private long company_id;
    @ApiModelProperty(notes = "Employees first name", example = "Richard", required = true)
    private String first_name;
    @ApiModelProperty(notes = "Employees last name", example = "Chaidez", required = true)
    private String last_name;
}
