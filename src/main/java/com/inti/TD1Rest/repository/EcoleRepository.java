package com.inti.TD1Rest.repository;

import com.inti.TD1Rest.model.Ecole;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

@Repository
public interface EcoleRepository extends JpaRepository<Ecole, Integer> {

	@Query(value = "select ec.* from etudiant e, ecole ec "
			+ "where e.id_ecole = ec.id and e.email=:email", nativeQuery = true)
	Ecole findSchoolByEmail(@Param("email") String email);
	
	@Query(value = "select ec.* from etudiant e, ecole ec "
			+ "where e.id_ecole = ec.id and e.nom=:nom and e.prenom=:prenom", nativeQuery = true)
	Ecole findSchoolByNomAndPrenom(@Param("nom") String nom,@Param("prenom") String prenom);
}
