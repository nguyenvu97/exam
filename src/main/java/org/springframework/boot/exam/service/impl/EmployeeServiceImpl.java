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
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
   private final ManageRepository manageRepository;
   private final MapperTogether<Employee, EmployeeDto> mapperTogether;
   private final ConfigMap configMap;


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
        // Kiểm tra và sửa đổi pageNumber và pageSize nếu không hợp lệ
        if (employeeDto.getPageNumber() <= 0 || employeeDto.getPageSize() <= 0) {
            employeeDto.setPageNumber(configMap.getPageNumber());
            employeeDto.setPageSize(configMap.getPageSize());
        }

        PageRequest pageRequest = PageRequest.of(employeeDto.getPageNumber(), employeeDto.getPageSize(),
                Sort.by("id").descending());

        System.out.println(pageRequest);

        // Tìm kiếm trang dữ liệu từ repository
        Page<Employee> page = employeeRepository.findAll(empolyeeSpecs.priceGreaterThan(employeeDto), pageRequest);

        // Chuyển đổi danh sách Employee thành danh sách EmployeeDto
        List<EmployeeDto> employeeDtos = page.getContent().stream()
                .map(mapperTogether::entityDto)
                .collect(Collectors.toList());

        // Tạo đối tượng PageDto và set các thông tin từ page vào
        PageDto pageDto = new PageDto();
        pageDto.setContent(employeeDtos);
        pageDto.setNumber(page.getNumber());
        pageDto.setNumberOfElements(page.getNumberOfElements());
        pageDto.setTotalElements(page.getTotalElements());
        pageDto.setTotalPages(page.getTotalPages());
        pageDto.setPageNumber(page.getNumber());
        pageDto.setPageSize(page.getSize());

        return pageDto;
    }
    @Override
    @Transactional(rollbackFor = Exception.class)
    public PageDto search() {
        EmployeeDto dto =  new EmployeeDto();
        dto.setPageNumber(configMap.getPageNumber());
        dto.setPageSize(configMap.getPageSize());
        return listEmployee(dto);
    }

}
