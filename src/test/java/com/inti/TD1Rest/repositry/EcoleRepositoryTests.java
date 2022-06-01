package com.inti.TD1Rest.repositry;

import static org.assertj.core.api.Assertions.assertThat;

import com.inti.TD1Rest.model.Ecole;
import com.inti.TD1Rest.repository.EcoleRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EcoleRepositoryTests {

	@Autowired
	EcoleRepository ecoleRepository;
	
	@Test
	public void testFindSchoolByEmail() {
		// Given
		
		// When
		Ecole testEcole = ecoleRepository.findSchoolByEmail("jp@test.com");
		// Then
		assertThat(testEcole).isNotNull();
		assertThat(testEcole.getNom()).isEqualTo("Université Lyon");
	}
	
	@Test
	public void testFindSchoolByNomAndPrenom() {
		// Given
		
		// When
		Ecole testEcole = ecoleRepository.findSchoolByNomAndPrenom("louis","dupont");
		// Then
		assertThat(testEcole).isNotNull();
		assertThat(testEcole.getNom()).isEqualTo("Adaming");
	}
}
