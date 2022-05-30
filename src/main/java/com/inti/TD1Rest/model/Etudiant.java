package com.inti.TD1Rest.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor @AllArgsConstructor @RequiredArgsConstructor
public class Etudiant {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private @NonNull String nom;
	private @NonNull String prenom;
	private String email;
	private String telephone;
	private int anneeEtude;
	@JoinColumn(name="id_ecole")
	@ManyToOne
	private Ecole ecole;
	@ManyToMany
	@JoinTable(name="etudiant_professeur",
				joinColumns = @JoinColumn(name="idEtudiant"),
				inverseJoinColumns = @JoinColumn(name="idProf"))
	private List<Professeur> listeProfesseur = new ArrayList<Professeur>();
	
	public Etudiant(@NonNull String nom, @NonNull String prenom, String email, String telephone, int anneeEtude) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.anneeEtude = anneeEtude;
	}
	
}
