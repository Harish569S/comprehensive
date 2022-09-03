package com.mindtree.doctor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.doctor.entity.DoctorDetails;
import com.mindtree.doctor.service.DoctorService;


@RestController
@RequestMapping("/doctor")
public class DoctorController {

	@Autowired
	DoctorService doctorService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public DoctorDetails createDoctor(@RequestBody DoctorDetails doctorDetails) {
		return doctorService.addDoctor(doctorDetails);
	}

	@GetMapping
	public List<DoctorDetails> getAll() {
		return doctorService.fetchAllDoctorDetails();
	}

	@GetMapping("/byname/{str}")
	public DoctorDetails getOneDoctor(@PathVariable String str) {
		return doctorService.getDoctorByName(str);
	}
   
	//used by patient
	@GetMapping("/inc/{str}")
	public DoctorDetails incPatiofdoc(@PathVariable String str) {
		return doctorService.incrementPatient(str);
	}

}




//@GetMapping("/{id}")
//public DoctorDetails getOneDoctor(@PathVariable int id){
//	return doctorService.getDoctorById(id);
//}
