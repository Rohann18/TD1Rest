package com.inti.TD1Rest.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor @AllArgsConstructor @RequiredArgsConstructor
public class Ecole {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private @NonNull String nom;
	private String adresse;
	private String cp;
	private String ville;
	@OneToMany(cascade=CascadeType.ALL, targetEntity = Etudiant.class, mappedBy = "ecole")
	@JsonIgnore
	private List<Etudiant> listEtudiant = new ArrayList<Etudiant>();
	@OneToMany(cascade=CascadeType.ALL, targetEntity = Professeur.class, mappedBy = "ecole")
	@JsonIgnore
	private List<Professeur> listProfesseur = new ArrayList<Professeur>();
	public Ecole(@NonNull String nom, String adresse, String cp, String ville) {
		super();
		this.nom = nom;
		this.adresse = adresse;
		this.cp = cp;
		this.ville = ville;
	}
	
}
