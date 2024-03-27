package com.springLearn.departmentService.service;

import com.springLearn.departmentService.entity.Department;
import com.springLearn.departmentService.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public Department saveDepartment(Department department) {

        return departmentRepository.save(department);

    }

    @Override
    public Department findDepartmentById(Long id) {
        return departmentRepository.findById(id).get();
    }
}
