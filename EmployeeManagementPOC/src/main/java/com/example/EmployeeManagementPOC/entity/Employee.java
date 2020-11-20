package com.example.EmployeeManagementPOC.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Employee {

	@Id
	private int empId;

	@Column(name = "name", length = 30)
	private String name;

	@Column(name = "age", length = 30)
	private int age;

	@Column(name = "gender", length = 30)
	private String gender;

	@Column(name = "sal", length = 30)
	private long sal;

	@Column(name = "designation", length = 30)
	private String designation;

	@Column(name = "created_by", length = 30)
	private String createdBy;

	@OneToOne(targetEntity = Adress.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "EA_fk", referencedColumnName = "id")
	private Adress adress;

	@OneToOne(targetEntity = Department.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "dpid_fk", referencedColumnName = "depid")
	private Department department;

	public Employee() {

	}

	public Employee(int empId, String name, int age, String gender, long sal, String designation, String createdBy,
			Adress adress, Department department) {

		this.empId = empId;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.sal = sal;
		this.designation = designation;
		this.createdBy = createdBy;
		this.adress = adress;
		this.department = department;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public void setAdress(Adress adress) {
		this.adress = adress;
	}

	public Adress getAdress() {
		return adress;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public long getSal() {
		return sal;
	}

	public void setSal(long sal) {
		this.sal = sal;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Override
	public String toString() {
		return String.format("Employee [empId=" + empId + ", name=" + name + ", age=" + age + ", gender=" + gender + ", sal=" + sal
				+ ", designation=" + designation + ", createdBy=" + createdBy + ", adress=" + adress + ", department="
				+ department + "]");
	}

	

}
