package com.youssef.Miniprojet.restcontrollers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.youssef.Miniprojet.dto.VoitureDTO;
import com.youssef.Miniprojet.entities.Voiture;
import com.youssef.Miniprojet.service.VoitureService;
@RestController
@RequestMapping("/api")
@CrossOrigin(origins="*")
public class MiniprojetRESTController {
	@Autowired
	VoitureService voitureService;
	@RequestMapping(path="all",method = RequestMethod.GET)
	public List<VoitureDTO> getAllVoitures() {
		return voitureService.getAllvoiture();
		}
	@RequestMapping(value="/getbyid/{id}",method = RequestMethod.GET)
	public VoitureDTO getVoitureById(@PathVariable("id") Long id) {
	return voitureService.getVoiture(id);
	 }
	@RequestMapping(path="/addVoit",method = RequestMethod.POST)
	public Voiture createVoiture(@RequestBody Voiture voiture) {
	return voitureService.saveVoiture(voiture);
	}
	@RequestMapping(path="/addVoiture",method = RequestMethod.POST)
	public Long saveVoitureAndGetId(@RequestBody Voiture voiture) {
        Voiture savedEntity = voitureService.saveVoiture(voiture);
        return savedEntity.getIdVoiture();
    }
	@RequestMapping(path="/updateVoit",method = RequestMethod.PUT)
	public Voiture updateVoiture(@RequestBody Voiture voiture) {
	return voitureService.UpdateVoiture(voiture);
	}
	@RequestMapping(value="/delVoit/{id}",method = RequestMethod.DELETE)
	public void deleteVoiture(@PathVariable("id") Long id)
	{
	voitureService.deleteVoitureById(id);
	}
	@RequestMapping(value="/voitMarq/{idMarq}",method = RequestMethod.GET)
	public List<Voiture> getVoitureByMarqId(@PathVariable("idMarq") Long idMarq) {
	return voitureService.findByMarqueIdMarque(idMarq);
	}
	@RequestMapping(value="/voitByModel/{nom}",method = RequestMethod.GET)
	public List<Voiture> findByModeleContains(@PathVariable("nom") String nom) {
	return voitureService.findByModeleContains(nom);
	}

}

