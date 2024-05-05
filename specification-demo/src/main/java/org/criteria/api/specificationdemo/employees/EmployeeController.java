package org.criteria.api.specificationdemo.employees;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;
    @GetMapping("/v1/get-employees")
    public ResponseEntity<?> getEmployees(
            @RequestParam String key,
            @RequestParam String value,
            @RequestParam String operation)
    {
        EmployeeSpecification spec = new EmployeeSpecification(
                new SearchCriteria(key, operation, value)
        );

        return ResponseEntity.ok().body(employeeService.findAll(spec));
    }
}
