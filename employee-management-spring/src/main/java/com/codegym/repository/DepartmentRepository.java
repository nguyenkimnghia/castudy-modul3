package com.codegym.repository;

import com.codegym.model.Department;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends CrudRepository<Department, Long> {
    Department findById(Long id);
}
