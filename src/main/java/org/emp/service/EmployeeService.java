package org.emp.service;

import org.emp.dto.Employee;

import java.util.List;

public interface EmployeeService {
    Employee add(Employee employee);

    List<Employee> getAll();
}
