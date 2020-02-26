package com.codegym.service;

import com.codegym.mapper.EmployeeMapper;
import com.codegym.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<EmployeeMapper> findAll();
    Employee addEmployee(EmployeeMapper employee);
    void delete(Long id);
    Employee findById(Long id);
    void save(Employee employee);

}
