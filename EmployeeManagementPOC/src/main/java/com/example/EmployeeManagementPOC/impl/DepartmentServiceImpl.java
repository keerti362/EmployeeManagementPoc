package com.example.EmployeeManagementPOC.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EmployeeManagementPOC.entity.Department;
import com.example.EmployeeManagementPOC.repository.DepartmentRepository;
import com.example.EmployeeManagementPOC.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public Department saveDepartment(Department department) {
		return departmentRepository.save(department);
	}

	@Override
	public Optional<Department> getDepartmentById(int depid) {
		return departmentRepository.findById(depid);

	}

	@Override
	public void deleteDepartmentById(int id) {
		departmentRepository.deleteById(id);

	}

	@Override
	public void deleteAlldepartments() {
		departmentRepository.deleteAll();

	}

}
