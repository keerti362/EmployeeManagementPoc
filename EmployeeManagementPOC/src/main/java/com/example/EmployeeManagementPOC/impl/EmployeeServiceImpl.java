package com.example.EmployeeManagementPOC.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EmployeeManagementPOC.entity.Employee;
import com.example.EmployeeManagementPOC.model.EmployeeRequest;
import com.example.EmployeeManagementPOC.repository.EmployeeRepository;
import com.example.EmployeeManagementPOC.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee saveEmployee(EmployeeRequest request) {
		return employeeRepository.save(request.getEmployee());
	}

	@Override
	public Optional<Employee> getEmployeeById(int id) {
		return employeeRepository.findById(id);
	}

	@Override
	public List<Employee> viewEmployees() {
		List<Employee> empList = new ArrayList<Employee>();
		empList = employeeRepository.findAll();
		return empList;
	}

	@Override
	public Employee editEmployee(int id, EmployeeRequest employee) throws Exception {
		Optional<Employee> emp = employeeRepository.findById(id);
		if (!emp.isPresent()) {
			throw new Exception("Employeeis not found with an id" + id);
		}
		Employee employee1 = emp.get();
		employee1.setName(employee.getEmployee().getName());
		employee1.setAge(employee.getEmployee().getAge());
		employee1.setGender(employee.getEmployee().getGender());
		employee1.setDesignation(employee.getEmployee().getDesignation());
		employee1.setSal(employee.getEmployee().getSal());
		employee1.setCreatedBy(employee.getEmployee().getCreatedBy());
		employee1.setAdress(employee.getEmployee().getAdress());
		employee1.setDepartment(employee.getEmployee().getDepartment());
		employeeRepository.save(employee1);
		return employee1;
	}

	@Override
	public void deleteEmployee(int id) {
		employeeRepository.deleteById(id);
	}

	@Override
	public void deleteAllEmployees() {
		employeeRepository.deleteAll();
	}

	@Override
	public List<Employee> getHighPaidEmployess() {
		List<Employee> list = new ArrayList<Employee>();
		list = employeeRepository.getHighPaidEmployees();
		return list;
	}

	@Override
	public List<Employee> getEmployeesByDepartment(int depId) {
		
		return employeeRepository.getEmployeesByDepartment(depId);
	}
}
