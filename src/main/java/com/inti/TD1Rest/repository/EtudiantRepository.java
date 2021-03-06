package com.inti.TD1Rest.repository;

import java.util.List;

import com.inti.TD1Rest.model.Etudiant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Integer> {

	@Query(value = "select * from etudiant where id_ecole=:idEcole", nativeQuery = true)
	List<Etudiant> findByIdEcole(@Param("idEcole") int idEcole);
	
	@Query(value = "select * from etudiant where id_ecole in (select id from ecole where ville = \"Lyon\");", nativeQuery = true)
	List<Etudiant> findByVille();
	
	@Query(value = "select * from etudiant where id in (select id_etudiant from etudiant_professeur where id_prof=:id_prof);", nativeQuery = true)
	List<Etudiant> getByProfessor(@Param("id_prof") int id_prof);
}
