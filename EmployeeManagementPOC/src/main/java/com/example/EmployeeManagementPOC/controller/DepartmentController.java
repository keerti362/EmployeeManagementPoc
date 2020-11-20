package com.example.EmployeeManagementPOC.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EmployeeManagementPOC.entity.Department;
import com.example.EmployeeManagementPOC.impl.DepartmentServiceImpl;

@RestController
@RequestMapping("/Department")
public class DepartmentController {

	@Autowired
	private DepartmentServiceImpl departmentServiceImpl;

	@PostMapping("/addDepartment")
	public Department saveDepartment(@RequestBody Department department) {
		return departmentServiceImpl.saveDepartment(department);
	}

	@GetMapping("/getDepartment/{depId}")
	public Optional<Department> getDepartmentById(@PathVariable("depId") int depId) {
		return departmentServiceImpl.getDepartmentById(depId);
	}

	@DeleteMapping("/deleteDepartment/{depiD}")
	public void deleteDepartment(@PathVariable("depiD") int depId) {
		departmentServiceImpl.deleteDepartmentById(depId);
	}

	@DeleteMapping("/deleteAllDepartment")
	public void deleteDepartments() {
		departmentServiceImpl.deleteAlldepartments();
	}

}
