package org.criteria.api.specificationdemo.employees;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

@AllArgsConstructor
public class EmployeeSpecification implements Specification<Employee> {
    private SearchCriteria criteria;

    @Override
    public Predicate toPredicate(
            Root<Employee> root,
            CriteriaQuery<?> query,
            CriteriaBuilder criteriaBuilder)
    {
        if(criteria.getOperation().equalsIgnoreCase(":"))
        {
            return criteriaBuilder.like(
                    root.get(criteria.getKey()),
                    criteria.getValue() + "%"
            );
        }

        return null;
    }
}
