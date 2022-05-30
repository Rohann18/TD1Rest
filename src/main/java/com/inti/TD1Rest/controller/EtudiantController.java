package com.inti.TD1Rest.controller;

import java.util.List;

import com.inti.TD1Rest.model.Etudiant;
import com.inti.TD1Rest.repository.EtudiantRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public ResponseEntity<Etudiant> saveEtudiant(@RequestBody Etudiant etudiant) {
		return new ResponseEntity<Etudiant>(etudiantRepository.save(etudiant),HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}")
	public String updateEtudiant(@RequestBody Etudiant etudiant, @PathVariable int id) {
		Etudiant e1 = etudiantRepository.getReferenceById(id);
		etudiantRepository.save(etudiant);
		return "L'Etudiant a bien été modifié.";
	}
	
	@PostMapping("/delete")
	public String deleteEtudiant() {
		etudiantRepository.deleteById(1);
		return "L'Etudiant a bien été supprimé.";
	}
}
