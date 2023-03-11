package com.jantech.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jantech.demo.entity.Department;
import com.jantech.demo.error.DepartmentNotFoundException;
import com.jantech.demo.service.DepartmentService;

import jakarta.validation.Valid;

@RestController
public class DepartmentController {

    // I want the object from spring hence autowired
    @Autowired
    private DepartmentService departmentService;

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){
            LOGGER.info("Inside saving department");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> getDepartments(){
        return departmentService.getDepartments();
    }
    
    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException{
        return departmentService.fetchDepartmentById(departmentId);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable Long id){
        return departmentService.deleteDepartmentById(id);
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@RequestBody Department department, @PathVariable Long id){
        return departmentService.updateDepartment(department, id);
    }

    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable String name){
        return departmentService.fetchDepartmentByName(name);
    }
}
