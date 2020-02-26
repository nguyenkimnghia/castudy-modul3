package com.codegym.service.impl;

import com.codegym.mapper.DepartmentMapper;
import com.codegym.model.Department;
import com.codegym.repository.DepartmentRepository;
import com.codegym.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<DepartmentMapper> findAllDepartment() {
        Iterable<Department> departments = departmentRepository.findAll();
        List<DepartmentMapper> departmentMappers = new ArrayList<>();
        departments.forEach(rc -> {
            DepartmentMapper departmentMapper = new DepartmentMapper();
            departmentMapper.setId(rc.getId());
            departmentMapper.setName(rc.getName());
            departmentMappers.add(departmentMapper);
        });
        return departmentMappers;
    }

    @Override
    public DepartmentMapper findDepartmentById(Long id) {
        Department department = departmentRepository.findById(id);
        DepartmentMapper departmentMapper = new DepartmentMapper();
        departmentMapper.setId(department.getId());
        departmentMapper.setName(department.getName());
        return departmentMapper;
    }
}
