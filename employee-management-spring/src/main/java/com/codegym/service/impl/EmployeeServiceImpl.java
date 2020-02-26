package com.codegym.service.impl;

import com.codegym.mapper.EmployeeMapper;
import com.codegym.model.Department;
import com.codegym.model.Employee;
import com.codegym.repository.EmployeeRepository;
import com.codegym.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeMapper> findAll() {
        Iterable<Employee> emp = employeeRepository.findAll();
        List<EmployeeMapper> employeeMapper = new ArrayList<>();
        for(Employee rc : emp ) {
            EmployeeMapper empMapper = new EmployeeMapper();
            empMapper.setId(rc.getId());
            empMapper.setAge(rc.getAge());
            empMapper.setName(rc.getName());
            empMapper.setPhone(rc.getPhone());
            empMapper.setIdDepartment(rc.getDepartment().getId());
            employeeMapper.add(empMapper);
        }
        return employeeMapper;
    }

    @Override
    public Employee addEmployee(EmployeeMapper employee) {
        Department department = new Department();
        department.setId(employee.getIdDepartment());
        Employee emp = new Employee();
        emp.setId(employee.getId());
        emp.setName(employee.getName());
        emp.setAge(employee.getAge());
        emp.setPhone(employee.getPhone());
        emp.setDepartment(department);
        employeeRepository.save(emp);
        return emp;
    }

    @Override
    public void delete(Long id) {
        employeeRepository.delete(id);
    }

    @Override
    public Employee findById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

}
