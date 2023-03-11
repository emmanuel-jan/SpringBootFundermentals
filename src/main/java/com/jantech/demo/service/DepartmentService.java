package com.jantech.demo.service;

import java.util.List;

import com.jantech.demo.entity.Department;
import com.jantech.demo.error.DepartmentNotFoundException;

public interface DepartmentService {

    public Department saveDepartment(Department department);

    public List<Department> getDepartments();

    public Department fetchDepartmentById(Long id) throws DepartmentNotFoundException;

    public String deleteDepartmentById(Long id);

    public Department updateDepartment(Department department, Long id);

    public Department fetchDepartmentByName(String name);
    
}
