package com.example.springboot_thymeleaf.service;

import com.example.springboot_thymeleaf.model.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();
    void saveEmployee(Employee employee);

    Employee getEmployeeById(long id);


    void deleteEmployeeById(long id);
}
