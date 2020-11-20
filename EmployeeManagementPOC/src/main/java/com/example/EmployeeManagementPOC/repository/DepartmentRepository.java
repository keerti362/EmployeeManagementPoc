package com.example.EmployeeManagementPOC.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EmployeeManagementPOC.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
