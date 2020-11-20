package com.example.EmployeeManagementPOC.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Department")
public class Department {

	@Id
	private int depid;

	private String depName;

	public int getDepid() {
		return depid;
	}

	public void setDepid(int depid) {
		this.depid = depid;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	public Department(int depid, String depName) {
		this.depid = depid;
		this.depName = depName;
	}

	public Department() {
	}

}
