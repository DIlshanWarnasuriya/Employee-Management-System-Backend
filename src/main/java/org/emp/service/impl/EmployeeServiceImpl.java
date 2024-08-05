package org.emp.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.emp.dto.Employee;
import org.emp.entity.EmployeeEntity;
import org.emp.repository.EmployeeRepository;
import org.emp.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;
    private final ObjectMapper mapper;

    @Override
    public Employee add(Employee employee) {
        EmployeeEntity entity = repository.save(mapper.convertValue(employee, EmployeeEntity.class));
        return mapper.convertValue(entity, Employee.class);
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> list = new ArrayList<>();

        for (EmployeeEntity entity : repository.findAll()) {
            list.add(mapper.convertValue(entity, Employee.class));
        }
        return  list;
    }
}
