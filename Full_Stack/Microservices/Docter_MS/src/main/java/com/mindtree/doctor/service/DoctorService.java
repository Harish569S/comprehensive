package com.mindtree.doctor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.doctor.entity.DoctorDetails;
import com.mindtree.doctor.repository.DoctorRepository;

@Service
public class DoctorService {

	@Autowired
	DoctorRepository doctorRepository;
	
	
	
	public DoctorDetails addDoctor(DoctorDetails doctorDetails) {
       return doctorRepository.save(doctorDetails)	;
	}
	
	
	
	public List<DoctorDetails> fetchAllDoctorDetails() {
		return doctorRepository.findAll();
	}
	
	
	
	public DoctorDetails getDoctorById(int dId) {
	 return doctorRepository.findById(dId);
	}


	public DoctorDetails getDoctorByName(String str) {
		DoctorDetails doctor= doctorRepository.getDetailsByName(str);
		return doctor;
	}
	
	
	public DoctorDetails incrementPatient(String str)
	{
		DoctorDetails doctor= doctorRepository.getDetailsByName(str);
		int currentParient=doctor.getNoOfPatients();
		doctor.setNoOfPatients(currentParient+1);
		return doctorRepository.save(doctor);	
	}
	
}
