package com.springLearn.departmentService.service;

import com.springLearn.departmentService.entity.Department;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface DepartmentService {

    public Department saveDepartment(Department department);
    public Department findDepartmentById(Long id);

}
