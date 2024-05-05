package org.criteria.api.specificationdemo.employees;

public class AutoEmployeeMapper {
    public static Employee mapToEmployee(EmployeeDto employee)
    {
        return Employee.builder()
                .employeeNumber(employee.getEmployeeNumber())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .email(employee.getEmail())
                .extension(employee.getExtension())
                .officeCode(employee.getOfficeCode())
                .jobTitle(employee.getJobTitle())
                .build();
    }

    public static EmployeeDto mapToEmployeeDto(Employee employee)
    {
        return EmployeeDto.builder()
                .employeeNumber(employee.getEmployeeNumber())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .email(employee.getEmail())
                .extension(employee.getExtension())
                .officeCode(employee.getOfficeCode())
                .jobTitle(employee.getJobTitle())
                .build();
    }

}
