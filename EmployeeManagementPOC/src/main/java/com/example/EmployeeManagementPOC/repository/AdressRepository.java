package com.example.EmployeeManagementPOC.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EmployeeManagementPOC.entity.Adress;

@Repository
public interface AdressRepository extends JpaRepository<Adress, Integer>{

}
