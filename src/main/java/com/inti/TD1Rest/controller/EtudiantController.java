package com.inti.TD1Rest.controller;

import java.util.List;

import com.inti.TD1Rest.model.Etudiant;
import com.inti.TD1Rest.repository.EtudiantRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EtudiantController {

	@Autowired
	EtudiantRepository etudiantRepository;
	@GetMapping("/test")
	public String hello() {
		return "Hello World!";
	}
	
	@GetMapping("/etudiant")
	public ResponseEntity<List<Etudiant>> getAllEtudiants(){
		return new ResponseEntity<List<Etudiant>>(etudiantRepository.findAll(),HttpStatus.OK);
	}
	
	@PostMapping("/enregistrer")
	public String saveEtudiant() {
		Etudiant e = new Etudiant("Toto", "Titi", "toto.titi@test.fr", "0102030405", 5);
		etudiantRepository.save(e);
		return "L'Etudiant a bien été enregistré.";
	}
	
	@PostMapping("/update")
	public String updateEtudiant() {
		Etudiant e = etudiantRepository.getReferenceById(1);
		e.setNom("Tata");
		e.setEmail("tata.titi@test.fr");
		etudiantRepository.save(e);
		return "L'Etudiant a bien été modifié.";
		
	}
	
	@PostMapping("/delete")
	public String deleteEtudiant() {
		etudiantRepository.deleteById(1);
		return "L'Etudiant a bien été supprimé.";
	}
}
