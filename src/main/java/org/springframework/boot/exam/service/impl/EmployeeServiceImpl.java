package org.springframework.boot.exam.service.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.boot.exam.Mapper.MapperTogether;
import org.springframework.boot.exam.config.ConfigMap;
import org.springframework.boot.exam.dto.EmployeeDto;
import org.springframework.boot.exam.dto.PageDto;
import org.springframework.boot.exam.empolyeeSpecs.empolyeeSpecs;
import org.springframework.boot.exam.model.Employee;
import org.springframework.boot.exam.model.Manage;
import org.springframework.boot.exam.repository.EmployeeRepository;
import org.springframework.boot.exam.repository.ManageRepository;
import org.springframework.boot.exam.service.EmployeeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
   private final ManageRepository manageRepository;
   private final MapperTogether<Employee, EmployeeDto> mapperTogether;


    @Override
    public String add(Employee employee,long manageId) {
        Manage manage = manageRepository.findById(manageId).orElseThrow(()-> new RuntimeException("not found manage" +manageId));
        employeeRepository.save(Employee
                .builder()
                        .Name(employee.getName())
                        .wage(employee.getWage())
                        .manage(manage)
                .build());
        return "Create Ok";
    }

    @Override
    public PageDto listEmployee(EmployeeDto employeeDto) {
        if (employeeDto.getPageNumber() <= 0 || employeeDto.getPageSize() <= 0){
            employeeDto.setPageNumber(ConfigMap.pageNumber);
            employeeDto.setPageSize(ConfigMap.pageSize);
        }
        Page<Employee> page = employeeRepository.findAll(empolyeeSpecs.priceGreaterThan(employeeDto),
                PageRequest.of(employeeDto.getPageNumber(),employeeDto.getPageSize(),
                        Sort.by("email").descending()));
        List<EmployeeDto> employeeDtos = page.getContent().stream()
                .map(mapperTogether::entityDto)
                .collect(Collectors.toList());
        return  PageDto.builder()
                .content(employeeDtos)
                .number(page.getNumber())
                .numberOfElements(page.getNumberOfElements())
                .totalElements(page.getTotalElements())
                .totalPages(page.getTotalPages())
                .pageNumber(page.getNumber() + 1) // Số trang bắt đầu từ 1
                .pageSize(page.getSize())
                .build();

    }

}
