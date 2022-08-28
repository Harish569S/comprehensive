package com.mindtree.doctor;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.mindtree.doctor.entity.DoctorDetails;
import com.mindtree.doctor.repository.DoctorRepository;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class DocterMsApplicationTests {
	
	@Autowired
	MockMvc mockMvc;


	@Autowired
	DoctorRepository doctorRepository;


	@BeforeEach
	void setup() {
		doctorRepository.deleteAll();
	}

	@Test
	public void togetdoctorByName() throws Exception {
		DoctorDetails doctor = new DoctorDetails("Madhu", 24, "Cardio", "Male", 0);
		doctorRepository.save(doctor);

		mockMvc.perform(get("http://localhost:8083/doctor/byname/Madhu")).andExpect(status().isOk()).andDo(print())
				.andExpect(jsonPath("$.docName").value("Madhu"))
				.andExpect(jsonPath("$.specialistIn").value("Cardio"))
				.andExpect(jsonPath("$.gender").value("Male"));
	}

	@Test
	public void togetdoctorsList() throws Exception {
		List<DoctorDetails> doctors=new ArrayList<>();
		DoctorDetails doctor = new DoctorDetails("Madhu", 24, "Cardio", "Male", 0);
		doctors.add(doctor);
		doctor = new DoctorDetails("Rajest", 24, "Sychology", "Male", 0);
		doctors.add(doctor);
		doctorRepository.saveAll(doctors);

		 mockMvc.perform(get("http://localhost:8083/doctor")).andExpect(status().isOk()).andDo(print()).andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.size()", is(doctors.size())));
	}

	@Test
	public void testforPost() throws Exception {
		mockMvc.perform(post("http://localhost:8083/doctor").contentType(MediaType.APPLICATION_JSON).content(
				"{\"docName\":\"Madhu\",\"docAge\":24,\"gender\":\"Male\",\"specialistIn\":\"Cardio\",\"noOfPatients\":0}"))
				.andExpect(status().isCreated()).andExpect(jsonPath("$.docName").value("Madhu"));
	}

}


















//DoctorDetails doctor = new DoctorDetails("Madhu", 24, "Cardio", "Male", 0);
//doctorRepository.save(doctor);
//doctor = new DoctorDetails("Rajest", 24, "Sychology", "Male", 0);
//doctorRepository.save(doctor);
//
//mockMvc.perform(get("http://localhost:8083/doctor")).andExpect(status().isOk()).andDo(print())
//		.andExpect(jsonPath("$.size()", is(2)));

