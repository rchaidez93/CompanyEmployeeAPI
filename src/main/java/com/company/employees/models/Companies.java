package com.company.employees.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Companies", description = "Class representing companies")
public class Companies {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(notes = "Unique identifier of the company", example = "1", required = true)
    private long id;
    @ApiModelProperty(notes = "Company name", example = "My business", required = true)
    private String name;

}
