package org.criteria.api.specificationdemo.employees;

import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeDto {

    private Long employeeNumber;

    private String firstName;

    private String lastName;

    private String email;

    private String jobTitle;

    private String extension;

    private String officeCode;

}
