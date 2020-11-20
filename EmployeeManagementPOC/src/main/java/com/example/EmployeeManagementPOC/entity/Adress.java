package com.example.EmployeeManagementPOC.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "adress")
public class Adress {
	
	@Id
	private int id;
	
	@Column(name = "pin_code")
	private String pincode;
	
	@Column(name = "area")
	private String area;
	
	public Adress() {
		
	}
	
	public Adress(int id, String pincode, String area) {
		this.id = id;
		this.pincode = pincode;
		this.area = area;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	@Override
	public String toString() {
		return "Adress [id=" + id + ", pincode=" + pincode + ", area=" + area + "]";
	}
	

}
