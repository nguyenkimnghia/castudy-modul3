package com.codegym.service;

import com.codegym.mapper.DepartmentMapper;
import com.codegym.model.Department;

import java.util.List;

public interface DepartmentService {
    List<DepartmentMapper> findAllDepartment();
    DepartmentMapper findDepartmentById(Long id);
}
