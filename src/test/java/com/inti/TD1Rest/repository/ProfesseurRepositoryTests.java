package com.inti.TD1Rest.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import com.inti.TD1Rest.model.Professeur;
import com.inti.TD1Rest.repository.ProfesseurRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProfesseurRepositoryTests {

	@Autowired
	ProfesseurRepository professeurRepository;
	
	@Test
	public void getAllProfessorOrderBySalary() {
		// Given
		
		// When
		List<Professeur> listProfesseur = professeurRepository.orderBySalaire(1);
		// Then
		assertThat(listProfesseur).isNotNull();
	}
}
