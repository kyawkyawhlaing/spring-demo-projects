package org.criteria.api.specificationdemo.employees;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    private Long employeeNumber;

    private String firstName;

    private String lastName;

    private String email;

    private String jobTitle;

    private String extension;

    private String officeCode;

}
