package com.inti.TD1Rest.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.inti.TD1Rest.repository.EcoleRepository;
import com.inti.TD1Rest.repository.EtudiantRepository;
import com.inti.TD1Rest.repository.ProfesseurRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(ProfesseurController.class)
public class ProfesseurControllerTests {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ProfesseurRepository professeurRepository;
	
	@MockBean
	private EcoleRepository ecoleRepository;
	
	@MockBean
	private EtudiantRepository etudiantRepository;
	
	@Test
	public void testGetProfessorBySchool() {
		try {
			mockMvc.perform(get("/professorBySchool/{id}","1"))
				.andExpect(status().isOk());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
