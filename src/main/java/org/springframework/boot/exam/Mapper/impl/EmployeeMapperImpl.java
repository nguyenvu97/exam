package org.springframework.boot.exam.Mapper.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.boot.exam.Mapper.MapperTogether;
import org.springframework.boot.exam.dto.EmployeeDto;
import org.springframework.boot.exam.model.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapperImpl implements MapperTogether<Employee, EmployeeDto> {

    @Override
    public EmployeeDto entityDto(Employee employee) {
        EmployeeDto employeeDto = new EmployeeDto();
        BeanUtils.copyProperties(employee, employeeDto);
        employeeDto.setManagename(employee.getManage().getName());
        return employeeDto;
    }

    @Override
    public Employee dtoEntity(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);
        return employee;
    }
}
