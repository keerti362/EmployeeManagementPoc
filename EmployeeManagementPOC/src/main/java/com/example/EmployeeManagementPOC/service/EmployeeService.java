package com.example.EmployeeManagementPOC.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.EmployeeManagementPOC.entity.Employee;
import com.example.EmployeeManagementPOC.model.EmployeeRequest;

@Service
public interface EmployeeService {

	public Employee saveEmployee(EmployeeRequest request);

	public Optional<Employee> getEmployeeById(int empId);

	public List<Employee> viewEmployees();

	public List<Employee> getHighPaidEmployess();
	
	public List<Employee> getEmployeesByDepartment(int depId);

	public Employee editEmployee(int empId, EmployeeRequest employee) throws Exception;

	public void deleteEmployee(int empId);

	public void deleteAllEmployees();

}
