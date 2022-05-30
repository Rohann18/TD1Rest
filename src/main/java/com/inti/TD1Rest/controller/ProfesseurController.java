package com.inti.TD1Rest.controller;

import java.util.ArrayList;
import java.util.List;

import com.inti.TD1Rest.model.Ecole;
import com.inti.TD1Rest.model.Etudiant;
import com.inti.TD1Rest.model.Professeur;
import com.inti.TD1Rest.repository.EcoleRepository;
import com.inti.TD1Rest.repository.EtudiantRepository;
import com.inti.TD1Rest.repository.ProfesseurRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfesseurController {

	@Autowired
	ProfesseurRepository professeurRepository;
	
	@Autowired
	EcoleRepository ecoleRepository;
	
	@Autowired
	EtudiantRepository etudiantRepository;
	
	@GetMapping("/professeur")
	public ResponseEntity<List<Professeur>> getAllProfesseurs(){
		return new ResponseEntity<List<Professeur>>(professeurRepository.findAll(),HttpStatus.OK);
	}
	
	@PostMapping("/saveProfessor")
	public ResponseEntity<Professeur> saveProfesseur(@RequestBody Professeur professeur) {
		return new ResponseEntity<Professeur>(professeurRepository.save(professeur),HttpStatus.CREATED);
	}
	
	@PutMapping("/updateProfessor/{id}")
	public String updateProfesseur(@RequestBody Professeur professeur, @PathVariable int id) {
		Professeur e1 = professeurRepository.getReferenceById(id);
		professeurRepository.save(professeur);
		return "Le Professeur a bien été modifié.";
	}
	
	@PutMapping("/updateEcoleProfesseur/{idProf}/{idEcole}")
	public String updateEtudiantWitnSchool(@RequestBody Professeur professeur, @PathVariable int idProf, @PathVariable int idEcole) {
		Ecole ecole = ecoleRepository.getReferenceById(idEcole);
		professeur.setEcole(ecole);
		professeurRepository.save(professeur);
		return "L'Etudiant a bien été modifié.";
	}
	
	@PutMapping("/updateEtudiantProfesseur/{idEtudiant}/{idProf}")
	public String updateEtudiantWitnSchool(@PathVariable int idEtudiant, @PathVariable int idProf) {
		Etudiant etudiant = etudiantRepository.getReferenceById(idEtudiant);
		Professeur prof = professeurRepository.getReferenceById(idProf);
		
		List<Professeur> listProfesseurs = new ArrayList<Professeur>();
		listProfesseurs.add(prof);
		etudiant.setListeProfesseur(listProfesseurs);
		etudiantRepository.save(etudiant);
		
		return "L'Etudiant a bien été modifié.";
	}
	
	@DeleteMapping("/deleteProfessor")
	public String deleteProfesseur(@RequestParam("id") int id) {
		professeurRepository.deleteById(id);
		return "Professeur supprimé.";
	}
}
