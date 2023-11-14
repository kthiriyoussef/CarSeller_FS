package com.youssef.Miniprojet.repos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.youssef.Miniprojet.entities.Marque;


@RepositoryRestResource(path="marqrest")
@CrossOrigin
public interface MarqueRepository extends JpaRepository<Marque, Long> {
	

}
