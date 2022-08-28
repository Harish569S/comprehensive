package com.mindtree.patient.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.patient.entity.PatientDetails;
import com.mindtree.patient.repository.PatientRepository;


@Service
public class PatientService {
	
	@Autowired
	PatientRepository patientRepository;
	
	
	//to add patient
	public PatientDetails addPatient(PatientDetails patientDetails) {
       return patientRepository.save(patientDetails)	;
	}
	
	//to get all patients
	public List<PatientDetails> fetchAllPatientDetails() {
		return patientRepository.findAll();
	}
	
	
	//get patient by id
	public PatientDetails getPatientById(int pId) {
	 return patientRepository.findById(pId).get();
	}
	
	

}
