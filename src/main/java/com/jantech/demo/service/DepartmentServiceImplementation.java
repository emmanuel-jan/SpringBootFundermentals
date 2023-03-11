package com.jantech.demo.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jantech.demo.entity.Department;
import com.jantech.demo.error.DepartmentNotFoundException;
import com.jantech.demo.repository.DepartmentRepository;

@Service
public class DepartmentServiceImplementation implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById(Long id) throws DepartmentNotFoundException {
        Optional<Department> department = departmentRepository.findById(id);

        if(!department.isPresent()){
            throw new DepartmentNotFoundException("Department not available");
        }

        return department.get();
    }

    @Override
    public String deleteDepartmentById(Long id) {
        departmentRepository.deleteById(id);
        return "Department deleted Successfully";
    }

    @Override
    public Department updateDepartment(Department department, Long id) {
        Department depDB = departmentRepository.findById(id).get();

        if(Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())){
            depDB.setDepartmentName(department.getDepartmentName());
        }
        if(Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())){
            depDB.setDepartmentAddress(department.getDepartmentAddress());
        }
        if(Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())){
            depDB.setDepartmentCode(department.getDepartmentCode());
        }

        return departmentRepository.save(depDB);
    }

    @Override
    public Department fetchDepartmentByName(String name) {
        return departmentRepository.findByDepartmentNameIgnoreCase(name);
    }
    
}
