package com.example.EmployeeManagementPOC.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.EmployeeManagementPOC.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	//@Query(nativeQuery = true, value = "SELECT * from employee where sal in (select distinct top 5 sal from employee order by sal desc")  
//	@Query(nativeQuery = true, value = "SELECT * FROM employee WHERE( sal IN (SELECT TOP 5 sal FROM employee GROUP BY sal ORDER BY sal DESC))") 
	@Query(nativeQuery = true, value = "SELECT * FROM employee ORDER BY sal DESC LIMIT 6")
	public List<Employee> getHighPaidEmployees();
	
	@Query(nativeQuery = true, value = "SELECT * FROM employee WHERE dpid_fk = ?")
	public List<Employee> getEmployeesByDepartment(int depId);

}
