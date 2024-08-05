package org.emp.service;

import org.emp.dto.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
    Employee add(Employee employee);

    List<Employee> getAll();

    Map<String, String> delete(Integer id);

    Employee update(Employee employee);

    Employee findById(Integer id);

    Employee findByFirstName(String firstName);
}
