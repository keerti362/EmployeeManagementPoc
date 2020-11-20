package com.example.EmployeeManagementPOC.controller;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EmployeeManagementPOC.entity.Employee;
import com.example.EmployeeManagementPOC.impl.EmployeeServiceImpl;
import com.example.EmployeeManagementPOC.model.EmployeeRequest;
import com.example.EmployeeManagementPOC.pdf.PDFGenerator;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {

	private static final Logger employeeController = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeServiceImpl employeeServiceImpl;

	@PostMapping("/addEmployee")
	public Employee SaveEmployee(@RequestBody EmployeeRequest request) {

		return employeeServiceImpl.saveEmployee(request);

	}

	@GetMapping("/getEmployeeById/{empId}")
	public Optional<Employee> getEmployee(@PathVariable("empId") int empId) {
		employeeController.info("into getEmployee method");
		return employeeServiceImpl.getEmployeeById(empId);

	}

	@GetMapping(value = "/getAllEmployees/pdf", produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> viewEmployees() {
		List<Employee> empList = employeeServiceImpl.viewEmployees();
		ByteArrayInputStream bis = PDFGenerator.employeePDFReport(empList);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "inline: fileName = employees.pdf");
		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(bis));
	}

	@GetMapping("/getAllEmployees")
	public List<Employee> viewAllEmployees() {
		return employeeServiceImpl.viewEmployees();
	}

	@PutMapping("/editEmployee/{empId}")
	public Employee editEmployee(@PathVariable("empId") int empId, @RequestBody EmployeeRequest request)
			throws Exception {
		return employeeServiceImpl.editEmployee(empId, request);
	}

	@DeleteMapping("/deleteById/{empId}")
	public void deleteEmployee(@PathVariable("empId") int empId) {
		employeeServiceImpl.deleteEmployee(empId);
	}

	@DeleteMapping("/deleteAllEmployees")
	public void deleteAllEmployee() {
		employeeServiceImpl.deleteAllEmployees();
	}

	@GetMapping("/getHighPaidEmployess")
	public List<Employee> getHighPaidEmployees() {
		return employeeServiceImpl.getHighPaidEmployess();
	}

	@GetMapping("/getEmployeesByDepartment/{depId}")
	public List<Employee> getEmployeesByDepartment(@PathVariable("depId") int depId) {
		return employeeServiceImpl.getEmployeesByDepartment(depId);
	}

}
