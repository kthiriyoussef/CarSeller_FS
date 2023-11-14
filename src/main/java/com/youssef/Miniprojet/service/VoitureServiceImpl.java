package com.youssef.Miniprojet.service;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.youssef.Miniprojet.dto.VoitureDTO;
import com.youssef.Miniprojet.entities.Marque;
import com.youssef.Miniprojet.entities.Voiture;
import com.youssef.Miniprojet.repos.MiniprojetRepository;
import com.youssef.Miniprojet.repos.MarqueRepository;
@Service
public class VoitureServiceImpl implements VoitureService {
	@Autowired
	MiniprojetRepository MpRepository;
	@Autowired
	MarqueRepository MarqueRepository;
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	 public Voiture saveVoiture(Voiture v) {
	return  MpRepository.save(v);
	}
	@Override
	public Voiture UpdateVoiture(Voiture v) {
	return MpRepository.save(v);
	}
	@Override
	public void deleteVoiture(Voiture v) {
	MpRepository.delete(v);
	}
	 @Override
	public void deleteVoitureById(Long id) {
	MpRepository.deleteById(id);
	}
	@Override
	public VoitureDTO getVoiture(Long id) {
	return convertEntityToDto( MpRepository.findById(id).get());
	}
	@Override
	public List<VoitureDTO>  getAllvoiture() {
	return MpRepository.findAll().stream()
			.map(this::convertEntityToDto)
			.collect(Collectors.toList());
	}
	@Override
	public Page<Voiture> getAllVoituresParPage(int page, int size) {
	return MpRepository.findAll(PageRequest.of(page, size));
	}
	@Override
	public List<Voiture> findByModele(String nom) {
		// TODO Auto-generated method stub
		return MpRepository.findByModele(nom);
	}
	@Override
	public List<Voiture> findByModeleContains(String nom) {
		// TODO Auto-generated method stub
		return MpRepository.findByModeleContains(nom);
	}
	@Override
	public List<Voiture> findByModelePrix(String nom, Double prix) {
		// TODO Auto-generated method stub
		return MpRepository.findByModelePrix(nom, prix);
	}
	@Override
	public List<Voiture> findByMarque(Marque marque) {
		// TODO Auto-generated method stub
		return MpRepository.findByMarque(marque);
	}
	@Override
	public List<Voiture> findByMarqueIdMarque(Long id) {
		// TODO Auto-generated method stub
		return MpRepository.findByMarqueIdMarque(id);
	}
	@Override
	public List<Voiture> findByOrderByModeleAsc() {
		// TODO Auto-generated method stub
		return MpRepository.findByOrderByModeleAsc();
	}
	@Override
	public List<Voiture> trierVoitureNomsPrix() {
		// TODO Auto-generated method stub
		return MpRepository.trierVoitureNomsPrix();
	}
	@Override
	public List<Marque> getAllmarque() {
		// TODO Auto-generated method stub
		return MarqueRepository.findAll();
	}
	@Override
	public VoitureDTO convertEntityToDto(Voiture voiture) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		VoitureDTO voitureDTO = modelMapper.map(voiture, VoitureDTO.class);
		 return voitureDTO; 

	 /*return ProduitDTO.builder()
	.idProduit(produit.getIdProduit())
	.nomProduit(produit.getNomProduit())
	.prixProduit(produit.getPrixProduit())
	.dateCreation(p.getDateCreation())
	.categorie(produit.getCategorie())
	.build();*/
	}
	@Override
	public Voiture convertDtoToEntity(VoitureDTO voitureDto) {
	Voiture voiture = new Voiture();
	voiture = modelMapper.map(voitureDto, Voiture.class);
	return voiture;
	}


}

	


