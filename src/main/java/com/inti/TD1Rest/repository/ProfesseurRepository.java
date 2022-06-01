package com.inti.TD1Rest.repository;

import java.util.List;

import com.inti.TD1Rest.model.Professeur;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesseurRepository extends JpaRepository<Professeur, Integer> {

	@Query(value = "select * from professeur where id_ecole=:idEcole order by salaire desc", nativeQuery = true)
	List<Professeur> orderBySalaire(@Param("idEcole") int idEcole);
}
