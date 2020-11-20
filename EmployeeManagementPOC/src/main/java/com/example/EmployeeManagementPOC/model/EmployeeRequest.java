package com.example.EmployeeManagementPOC.model;

import com.example.EmployeeManagementPOC.entity.Employee;

public class EmployeeRequest {

	private Employee employee;

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public EmployeeRequest(Employee employee) {
		this.employee = employee;
	}

	public EmployeeRequest() {
	}

}
