package com.inti.TD1Rest.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor @AllArgsConstructor @RequiredArgsConstructor
public class Professeur {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private @NonNull String nom;
	private @NonNull String prenom;
	private double salaire;
	@JoinColumn(name="id_ecole")
	@ManyToOne
	private Ecole ecole;
	@ManyToMany
	@JoinTable(name="etudiant_professeur",
				joinColumns = @JoinColumn(name="idProf"),
				inverseJoinColumns = @JoinColumn(name="idEtudiant"))
	private List<Etudiant> listeEtudiant = new ArrayList<Etudiant>();
}
