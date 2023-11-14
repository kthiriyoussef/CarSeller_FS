package com.youssef.Miniprojet.repos;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.youssef.Miniprojet.entities.Marque;
import com.youssef.Miniprojet.entities.Voiture;
import java.util.List;

@RepositoryRestResource(path="rest")
@CrossOrigin
public interface MiniprojetRepository extends JpaRepository<Voiture, Long>  {
	List<Voiture> findByModele(String Modele);
	 List<Voiture> findByModeleContains(String Modele); 
	 
	 @Query("select v from Voiture v where v.modele like %?1 and v.prix > ?2")
	 List<Voiture> findByModelePrix (String nom, Double prix);
	 
	 @Query("select v from Voiture v where v.marque = ?1")
	 List<Voiture> findByMarque (Marque marque);
	 
	 List<Voiture> findByMarqueIdMarque(Long id);
	 List<Voiture> findByOrderByModeleAsc();
	 
	 @Query("select v from Voiture v order by v.modele ASC, v.prix DESC")
	 List<Voiture> trierVoitureNomsPrix ();
}
