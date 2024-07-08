package org.springframework.boot.exam.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.boot.exam.dto.EmployeeDto;
import org.springframework.boot.exam.dto.PageDto;
import org.springframework.boot.exam.model.Employee;
import org.springframework.boot.exam.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping("/add")
    public ResponseEntity<?> save(@RequestBody Employee employee, @RequestParam int manageId) {
        return ResponseEntity.ok().body(employeeService.add(employee,manageId));
    }
    @PostMapping
    public ResponseEntity<?> findAll (@RequestBody EmployeeDto employeeDto){
        return ResponseEntity.ok().body(employeeService.listEmployee(employeeDto));

    }
    @GetMapping()
    public PageDto get(){
        return employeeService.search();
    }
}
