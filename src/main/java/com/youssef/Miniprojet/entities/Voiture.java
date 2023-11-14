package com.youssef.Miniprojet.entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;


@Entity
public class Voiture {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idVoiture;
	@NotNull
	@Size (min = 4,max = 15)
	private String modele;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@PastOrPresent
	private Date relaseDate;
	@Min(value = 100)@Max(value = 10000)
	private Double prix;
	@NotNull
	@Size (min = 4,max = 15)
	private String coleur;
	
	@ManyToOne
	public Marque marque;
	@OneToMany (mappedBy = "voiture",cascade = CascadeType.ALL)
	 private List<Image> images;
	
	private String imagePath;
	
	public Marque getMarque() {
		return marque;
	}
	public void setMarque(Marque marque) {
		this.marque = marque;
	}
	public Voiture() {
		super();
	}
	public Voiture(String modele, Date relaseDate, Double prix, String coleur) {
		super();
		
		this.modele = modele;
		this.relaseDate = relaseDate;
		this.prix = prix;
		this.coleur = coleur;
	}
	public Long getIdVoiture() {
		return idVoiture;
	}
	public void setIdVoiture(Long idVoiture) {
		this.idVoiture = idVoiture;
	}
	public String getModele() {
		return modele;
	}
	public void setModele(String modele) {
		this.modele = modele;
	}
	public Date getRelaseDate() {
		return relaseDate;
	}
	public void setRelaseDate(Date relaseDate) {
		this.relaseDate = relaseDate;
	}
	public Double getPrix() {
		return prix;
	}
	public void setPrix(Double prix) {
		this.prix = prix;
	}
	public String getColeur() {
		return coleur;
	}
	public void setColeur(String coleur) {
		this.coleur = coleur;
	}
	
	public List<Image> getImages() {
		return images;
	}
	public void setImages(List<Image> images) {
		this.images = images;
	}
	
	@Override
	public String toString() {
		return "Voiture [idVoiture=" + idVoiture + ", Modele=" + modele + ", RelaseDate=" + relaseDate + ", prix="
				+ prix + ", Coleur=" + coleur + "]";
	}
	

}
