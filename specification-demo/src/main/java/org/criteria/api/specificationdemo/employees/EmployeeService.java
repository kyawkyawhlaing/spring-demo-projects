package org.criteria.api.specificationdemo.employees;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeService
{
    private final EmployeeRepository employeeRepository;

    public List<EmployeeDto> findAll(Specification<Employee> spec)
    {
        List<Employee>  employees = employeeRepository.findAll(spec);
        return employees.stream()
                .map(AutoEmployeeMapper::mapToEmployeeDto)
                .toList();
    }
}
