package com.mindtree.doctor.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "doctor")
public class DoctorDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String docName;
	
	private int docAge;
	
	private String gender;
	
	private String specialistIn;
	
	private int noOfPatients;
	
	public DoctorDetails() {
		super();
	}



	public DoctorDetails(String docName, int docAge, String specialistIn,String gender, int noOfPatients) {
		super();
		this.docName = docName;
		this.docAge = docAge;
		this.specialistIn = specialistIn;
		this.gender=gender;
		this.noOfPatients = noOfPatients;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getDocName() {
		return docName;
	}



	public void setDocName(String docName) {
		this.docName = docName;
	}



	public int getDocAge() {
		return docAge;
	}



	public void setDocAge(int docAge) {
		this.docAge = docAge;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public String getSpecialistIn() {
		return specialistIn;
	}



	public void setSpecialistIn(String specialistIn) {
		this.specialistIn = specialistIn;
	}



	public int getNoOfPatients() {
		return noOfPatients;
	}

	public void setNoOfPatients(int noOfPatients) {
		this.noOfPatients = noOfPatients;
	}



	@Override
	public String toString() {
		return "DoctorDetails [id=" + id + ", docName=" + docName + ", docAge=" + docAge + ", gender=" + gender
				+ ", specialistIn=" + specialistIn + ", noOfPatients=" + noOfPatients + ", getId()=" + getId()
				+ ", getDocName()=" + getDocName() + ", getDocAge()=" + getDocAge() + ", getGender()=" + getGender()
				+ ", getSpecialistIn()=" + getSpecialistIn() + ", getNoOfPatients()=" + getNoOfPatients()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

	

}
