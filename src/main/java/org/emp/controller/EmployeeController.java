package org.emp.controller;

import lombok.RequiredArgsConstructor;
import org.emp.dto.Employee;
import org.emp.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employee")
@RequiredArgsConstructor
@CrossOrigin
public class EmployeeController {

    private final EmployeeService service;

    @PostMapping
    Employee add(@RequestBody Employee employee){
        return service.add(employee);
    }

    @GetMapping
    List<Employee> getAll(){
        return service.getAll();
    }
}
