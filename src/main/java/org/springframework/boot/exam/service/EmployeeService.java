package org.springframework.boot.exam.service;


import org.springframework.boot.exam.dto.EmployeeDto;
import org.springframework.boot.exam.dto.PageDto;
import org.springframework.boot.exam.model.Employee;

import java.util.List;

public interface EmployeeService {
    String add(Employee employee,long manageId);

    PageDto listEmployee(EmployeeDto employeeDto);
    

}
