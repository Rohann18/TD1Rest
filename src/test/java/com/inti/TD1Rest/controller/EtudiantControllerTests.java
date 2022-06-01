package com.inti.TD1Rest.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.inti.TD1Rest.Json;
import com.inti.TD1Rest.model.Etudiant;
import com.inti.TD1Rest.repository.EcoleRepository;
import com.inti.TD1Rest.repository.EtudiantRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(EtudiantController.class)
public class EtudiantControllerTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private EtudiantRepository etudiantRepository;
	
	@MockBean
	private EcoleRepository ecoleRepository;
	
	@Test
	public void testGetAllStudents() {
		try {
			mockMvc.perform(get("/etudiant"))
				.andExpect(status().isOk());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testSaveStudent() {
		try {
			mockMvc.perform(post("/enregistrer")
				.contentType(MediaType.APPLICATION_JSON)
				.content(Json.fromObject(new Etudiant("Toto","Titi","tototiti@test.fr","070809",2))))
				.andExpect(status().isCreated());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetAllStudentsInLyon() {
		try {
			mockMvc.perform(get("/etudiantInLyon"))
				.andExpect(status().isOk());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
