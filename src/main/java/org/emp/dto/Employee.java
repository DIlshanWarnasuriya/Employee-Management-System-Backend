package org.emp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private Integer departmentId;
    private Integer roleId;
}
