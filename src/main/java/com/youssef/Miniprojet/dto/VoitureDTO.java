package com.youssef.Miniprojet.dto;

import java.util.Date;
import java.util.List;

import com.youssef.Miniprojet.entities.Marque;
import com.youssef.Miniprojet.entities.Image;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VoitureDTO {
	private Long idVoiture;
	private String modele;
	private String coleur;
	private Double prix;
	private Date relaseDate;
	private Marque marque;
	private String nomMarque;
	private Long idMarque;
	private List<Image> images;
	private Long idImage;

}
