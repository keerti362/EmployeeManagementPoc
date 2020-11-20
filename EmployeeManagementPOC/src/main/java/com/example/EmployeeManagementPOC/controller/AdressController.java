package com.example.EmployeeManagementPOC.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EmployeeManagementPOC.entity.Adress;
import com.example.EmployeeManagementPOC.impl.AdressServiceImpl;

@RestController
@RequestMapping("/Adress")
public class AdressController {
	
	@Autowired
	private AdressServiceImpl adressServiceImpl;
	
	@PostMapping("/addAdress")
	public Adress addAdress(@RequestBody Adress adress) {
		return adressServiceImpl.addAdress(adress);
	}
	
	@GetMapping("/getAllAdress")
	public List<Adress> viewAdress() {
		return adressServiceImpl.viewAdresses();
	}
	
	@DeleteMapping("/deleteById/{id}")
	public void deleteEmployee(@PathVariable("id") int id) {
		adressServiceImpl.deletAdress(id);
	}
	
	@DeleteMapping("/deleteAllAdress")
	public void deleteAllAdress() {
		adressServiceImpl.deleteAllAdress();
	}

	
	
}
