package com.mindtree.patient.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="patient")
public class PatientDetails {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String patientName;
	
	private String visitedDoctor;
	
	private int age;

	@Temporal(TemporalType.DATE)
	private Date dateOfVisit=new Date();
     

	
	public PatientDetails() {
		super();
	}


	public PatientDetails(String patientName, String visitedDoctor, int age, Date dateOfVisit) {
		super();
		this.patientName = patientName;
		this.visitedDoctor = visitedDoctor;
		this.age = age;
		this.dateOfVisit = dateOfVisit;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}



	public String getVisitedDoctor() {
		return visitedDoctor;
	}



	public void setVisitedDoctor(String visitedDoctor) {
		this.visitedDoctor = visitedDoctor;
	}



	public Date getDateOfVisit() {
		return dateOfVisit;
	}

	public void setDateOfVisit(Date dateOfVisit) {
		this.dateOfVisit = dateOfVisit;
	}



	@Override
	public String toString() {
		return "PatientDetails [id=" + id + ", patientName=" + patientName + ", visitedDoctor=" + visitedDoctor
				+ ", age=" + age + ", dateOfVisit=" + dateOfVisit + "]";
	}
   


  

	
}
