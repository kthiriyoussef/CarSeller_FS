package com.youssef.Miniprojet.service;

import java.util.List;
import org.springframework.data.domain.Page;

import com.youssef.Miniprojet.dto.VoitureDTO;
import com.youssef.Miniprojet.entities.Marque;
import com.youssef.Miniprojet.entities.Voiture;
public interface VoitureService {
	Voiture saveVoiture(Voiture V);
	Voiture UpdateVoiture(Voiture V);
	void deleteVoiture(Voiture V);
	void deleteVoitureById(Long id);
	VoitureDTO getVoiture(Long id);
	List <VoitureDTO> getAllvoiture();
	List<Marque> getAllmarque();
	Page<Voiture> getAllVoituresParPage(int page, int size);
	List<Voiture> findByModele(String nom);
	List<Voiture> findByModeleContains(String nom);
	List<Voiture> findByModelePrix (String nom, Double prix);
	List<Voiture> findByMarque (Marque marque);
	List<Voiture> findByMarqueIdMarque(Long id);
	List<Voiture> findByOrderByModeleAsc();
	List<Voiture> trierVoitureNomsPrix();
	VoitureDTO convertEntityToDto (Voiture voiture);
	Voiture convertDtoToEntity(VoitureDTO voitureDto);

}
