package com.youssef.Miniprojet;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.youssef.Miniprojet.entities.Marque;
import com.youssef.Miniprojet.entities.Voiture;
import com.youssef.Miniprojet.repos.MiniprojetRepository;
import com.youssef.Miniprojet.service.VoitureService;

@SpringBootTest
class MiniProjetApplicationTests {

	@Autowired
	private MiniprojetRepository MpRepository;
	@Autowired
	VoitureService voitureService;
	@Test
	public void testCreateVoiture() {
	Voiture voit = new Voiture("A180",new Date(),1500000.0,"Noir");
	MpRepository.save(voit);
	}
	@Test
	public void testFindVoiture()
	{
	Voiture v = MpRepository.findById(1L).get();
	System.out.println(v);
	}
	@Test
	public void testUpdateVoiture()
	{
	Voiture v = MpRepository.findById(1L).get();
	v.setPrix(1000.0);
	MpRepository.save(v);
	}
	@Test
	public void testDeleteVoiture()
	{
	MpRepository.deleteById(1L);;
	}
	@Test
	public void testListerTousProduits()
	{
	List<Voiture> voit = MpRepository.findAll();
	for (Voiture v : voit)
	{
	System.out.println(v);
	}
	}
	@Test
	public void testFindByNomVoitureContains()
	{
	Page<Voiture> prods = voitureService.getAllVoituresParPage(0,2);
	System.out.println(prods.getSize());
	System.out.println(prods.getTotalElements());
	System.out.println(prods.getTotalPages());
	//prods.getContent().forEach(p -> {System.out.println(p.toString());
	for (Voiture v : prods)
	{
	System.out.println(v);
	} }
	@Test
	public void testFindByModeleVoiture()
	{
	List<Voiture> prods = MpRepository.findByModele("A180");
	for (Voiture p : prods)
	{
	System.out.println(p);
	}
	}
	@Test
	public void testFindByModeleVoitureContains ()
	{
	List<Voiture> prods=MpRepository.findByModeleContains("A180");
	for (Voiture v : prods)
	{
	System.out.println(v);
	} }
	
	@Test
	public void testfindByModelePrix()
	{
	List<Voiture> prods = MpRepository.findByModelePrix("A180", 1500000.0);
	for (Voiture v : prods)
	{
	System.out.println(v);
	}
	}
	@Test
	public void testfindByMarque()
	{
	Marque mar = new Marque();
	mar.setIdMarque(1L);
	List<Voiture> prods = MpRepository.findByMarque(mar);
	for (Voiture v : prods)
	{
	System.out.println(v);
	}
	}
	@Test
	public void findByMarqueIdMarque()
	{
	List<Voiture> prods = MpRepository.findByMarqueIdMarque(1L);
	for (Voiture p : prods)
	{
	System.out.println(p);
	}
	 }
	@Test
	public void testfindByOrderByModeleAsc()
	{
	List<Voiture> prods =MpRepository.findByOrderByModeleAsc();
	for (Voiture p : prods)
	{
	System.out.println(p);
	}
	}
	@Test
	public void testTrierVoitureNomsPrix()
	{
	List<Voiture> prods = MpRepository.trierVoitureNomsPrix();
	for (Voiture v : prods)
	{
	System.out.println(v);
	}
	}
	 
	
	
	}
	
	








