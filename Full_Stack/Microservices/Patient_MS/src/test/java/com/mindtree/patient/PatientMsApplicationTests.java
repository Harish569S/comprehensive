package com.mindtree.patient;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.mindtree.patient.entity.PatientDetails;
import com.mindtree.patient.repository.PatientRepository;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PatientMsApplicationTests {

	@Autowired
	MockMvc mockMvc;

	@Autowired
	PatientRepository patientRepository;
	
	@BeforeEach
	void setup() {
		patientRepository.deleteAll();
	}

	
	@Test
	@Order(1)
	public void togetpatientById() throws Exception {

		Date date = new Date();
		PatientDetails patient = new PatientDetails("Patient1", "Dr.DARSHAN", 25, date);
		patientRepository.save(patient);

		mockMvc.perform(get("http://localhost:8085/patient/1")).andExpect(status().isOk()).andDo(print())
				.andExpect(jsonPath("$.patientName").value("Patient1"));
	}

	@Test
	@Order(2)
	public void togetpatientslist() throws Exception {
		List<PatientDetails> patients = new ArrayList<>();

		Date date = new Date();
		PatientDetails patient = new PatientDetails("Madhu", "Dr.DARSHAN", 25, date);
		patients.add(patient);

		patient = new PatientDetails("Rajesh", "Dr.DARSHAN", 40, date);
		patients.add(patient);
		patientRepository.saveAll(patients);

		mockMvc.perform(get("/patient")).andExpect(status().isOk()).andDo(print())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.size()", is(patients.size())));
	}

	@Test
	@Order(3)
	public void testforPostPatient() throws Exception {
		String patient = " {\n" + "  \"patientName\": \"Patient1\",\n"
				+ "        \"visitedDoctor\": \"Madhu\",\n" + "        \"age\": 1,\n"
				+ "        \"dateOfVisit\": \"2022-08-27\"\n" + "    }";

		mockMvc.perform(post("http://localhost:8085/patient").contentType(MediaType.APPLICATION_JSON).content(patient))
				.andExpect(status().isOk()).andExpect(jsonPath("$.patientName").value("Patient1")).andDo(print());
	}
}


//.andExpect(content().string(str))