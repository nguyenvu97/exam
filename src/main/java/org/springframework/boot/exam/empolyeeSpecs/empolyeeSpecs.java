package org.springframework.boot.exam.empolyeeSpecs;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.boot.exam.dto.EmployeeDto;
import org.springframework.boot.exam.model.Employee;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class empolyeeSpecs {
    public static Specification<Employee> priceGreaterThan(EmployeeDto employeeDto) {
        return new Specification<Employee>() {
            List<Predicate> predicates = new ArrayList<>();
            @Override
            public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
                if (employeeDto.getName() != null && !employeeDto.getName().isEmpty()){
                    return builder.and(builder.like(root.get("firstName"),"%" +employeeDto.getName() + "%"));
                }

                return builder.or(predicates.toArray(new Predicate[0]));
            }
        };
    }
}
