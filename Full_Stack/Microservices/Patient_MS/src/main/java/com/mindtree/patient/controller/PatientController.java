package com.mindtree.patient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mindtree.patient.entity.PatientDetails;
import com.mindtree.patient.service.PatientService;
import com.mindtree.patient.vo.DoctorDetails;

//@CrossOrigin(origins="*")
@RestController
@RequestMapping("/patient")
public class PatientController {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	PatientService patientService;

	@PostMapping
	public PatientDetails createDoctor(@RequestBody PatientDetails patientDetails) {
		String doc = patientDetails.getVisitedDoctor();
		restTemplate.getForObject("http://DOCTOR-SERVICE/doctor/inc/" + doc, DoctorDetails.class);
		return patientService.addPatient(patientDetails);
	}

	@GetMapping
	public List<PatientDetails> getAll() {
		return patientService.fetchAllPatientDetails();
	}

	@GetMapping("/{id}")
	public PatientDetails getOneDoctor(@PathVariable int id) {
		return patientService.getPatientById(id);
	}

}
