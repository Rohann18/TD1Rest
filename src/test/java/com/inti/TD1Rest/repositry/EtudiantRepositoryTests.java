package com.inti.TD1Rest.repositry;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import com.inti.TD1Rest.model.Etudiant;
import com.inti.TD1Rest.repository.EtudiantRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EtudiantRepositoryTests {

	@Autowired
	EtudiantRepository etudiantRepository;
	
	Etudiant e1;
	
	@BeforeEach
	public void setUp() {
		e1 = new Etudiant("Toto", "Titi", "tototiti@test.fr", "070809", 2);
	}
	
	@Test
	public void testSaveStudent() {
		// Given
		
		// When
		Etudiant saveEtudiant = etudiantRepository.save(e1);
		// Then
		assertThat(saveEtudiant).isNotNull();
	}
	
	@Test
	public void testGetAllStudents() {
		// Given
		
		// When
		List<Etudiant> listeEtudiant = etudiantRepository.findAll();
		// Then
		assertThat(listeEtudiant).isNotEmpty();
		assertThat(listeEtudiant).hasSize((int) etudiantRepository.count());
	}
}
