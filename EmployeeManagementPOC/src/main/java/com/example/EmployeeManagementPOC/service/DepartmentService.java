package com.example.EmployeeManagementPOC.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.EmployeeManagementPOC.entity.Department;

@Service
public interface DepartmentService {

	public Department saveDepartment(Department department);

	public void deleteDepartmentById(int id);

	public void deleteAlldepartments();

	public Optional<Department> getDepartmentById(int depid);

}
