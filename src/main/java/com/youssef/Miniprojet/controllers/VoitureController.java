package com.youssef.Miniprojet.controllers;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.youssef.Miniprojet.entities.Voiture;
import com.youssef.Miniprojet.entities.Marque;
import com.youssef.Miniprojet.service.VoitureService;
@Controller
public class VoitureController {
	@Autowired
	VoitureService voitureService;
	
	@RequestMapping("/showCreate")
	public String showCreate(ModelMap modelMap)
	{
		List<Marque> marq = voitureService.getAllmarque();
		Voiture v=new Voiture();
		Marque mar=new Marque();
		mar=marq.get(0);
		v.setMarque(mar);
	modelMap.addAttribute("voiture", v);
	modelMap.addAttribute("marque", marq);
	modelMap.addAttribute("mode", "new");

	return "formVoiture";
	}
	
	@RequestMapping("/saveVoiture")
	public String saveVoiture(@Valid Voiture voiture,BindingResult bindingResult)
	{
		if (bindingResult.hasErrors()) return "formVoiture";
	voitureService.saveVoiture(voiture);
	return "formVoiture";
	}

	@RequestMapping("/ListeVoiture")
	public String listeVoiture(ModelMap modelMap,@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "2") int size)
	{
		Page<Voiture> voit = voitureService.getAllVoituresParPage(page, size);
		modelMap.addAttribute("voiture", voit);
		 modelMap.addAttribute("pages", new int[voit.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		return "listeVoitures";
	}
	@RequestMapping("/supprimerVoiture")
	public String supprimerProduit(@RequestParam("id") Long id,ModelMap modelMap,@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "2") int size)
	{
	voitureService.deleteVoitureById(id);
	Page<Voiture> voit = voitureService.getAllVoituresParPage(page,size);
			modelMap.addAttribute("voiture", voit);
			modelMap.addAttribute("pages", new int[voit.getTotalPages()]);
			modelMap.addAttribute("currentPage", page);
			modelMap.addAttribute("size", size);
			return "listeVoitures";
	}
	@RequestMapping("/modifierVoiture")
	public String editerVoiture(@RequestParam("id") Long id,ModelMap modelMap)
	{
		
	Voiture v= voitureService.getVoiture(id);
	List<Marque> marq = voitureService.getAllmarque();
	modelMap.addAttribute("voiture", v);
	modelMap.addAttribute("marque", marq);
	modelMap.addAttribute("mode", "edit");
	return "formVoiture";
	}
	@RequestMapping("/updateVoiture")
	public String updateProduit(@ModelAttribute("voiture") Voiture voiture,@RequestParam("date") String date,ModelMap modelMap) throws ParseException {

		 voitureService.UpdateVoiture(voiture);
		 List<Voiture> voit = voitureService.getAllvoiture();
		 modelMap.addAttribute("voiture", voit);
		return "formVoiture";
		}
	
	
	
	
	
}


