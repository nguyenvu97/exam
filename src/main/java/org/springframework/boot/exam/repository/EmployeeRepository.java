package org.springframework.boot.exam.repository;


import org.springframework.boot.exam.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository

public interface EmployeeRepository  extends JpaRepository<Employee,Long>, JpaSpecificationExecutor<Employee> {


}
