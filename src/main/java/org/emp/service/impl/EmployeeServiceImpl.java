package org.emp.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.emp.dto.Employee;
import org.emp.entity.EmployeeEntity;
import org.emp.repository.EmployeeRepository;
import org.emp.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

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

    @Override
    public Map<String, String> delete(Integer id) {
        if (repository.findById(id).isPresent()){
            repository.deleteById(id);
            return Collections.singletonMap("response", "deleted");
        }
        return Collections.singletonMap("response", "Not Found");
    }

    @Override
    public Employee update(Employee employee) {
        if(repository.findById(employee.getId()).isPresent()){
            EmployeeEntity entity = repository.save(mapper.convertValue(employee, EmployeeEntity.class));
            return mapper.convertValue(entity, Employee.class);
        }
        return null;
    }

    @Override
    public Employee findById(Integer id) {
        if (repository.findById(id).isPresent()){
            return mapper.convertValue(repository.findById(id), Employee.class);
        }
        return new Employee();
    }
}
