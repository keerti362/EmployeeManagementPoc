package com.example.EmployeeManagementPOC.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.EmployeeManagementPOC.entity.Adress;

@Service
public interface AdressService {
	
	public Adress addAdress(Adress adress);
	
	public List<Adress> viewAdresses();
	
	//public Adress editAdress(int id, Adress adress) throws Exception;

	public void deletAdress(int id);
	
	
	public void deleteAllAdress();

}
