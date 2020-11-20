package com.example.EmployeeManagementPOC.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EmployeeManagementPOC.entity.Adress;
import com.example.EmployeeManagementPOC.repository.AdressRepository;
import com.example.EmployeeManagementPOC.service.AdressService;

@Service
public class AdressServiceImpl implements AdressService {

	@Autowired
	private AdressRepository adressRepository;

	@Override
	public Adress addAdress(Adress adress) {
		return adressRepository.save(adress);
	}

	@Override
	public List<Adress> viewAdresses() {
		List<Adress> list = new ArrayList<Adress>();
		list = adressRepository.findAll();
		return list;
	}

//	@Override
//	public Adress editAdress(int id, Adress adress) throws Exception {
//		
//		return null;
//	}

	@Override
	public void deletAdress(int id) {
		adressRepository.deleteById(id);
	}

	@Override
	public void deleteAllAdress() {
		adressRepository.deleteAll();
		
	}
	
	

}
