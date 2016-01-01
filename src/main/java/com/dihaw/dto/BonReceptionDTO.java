package com.dihaw.dto;

import java.util.Calendar;
import java.util.List;

/**
 * BonReception DTO.
 * 
 * @author Wahid Gazzah
 * @since 0.0.1
 */
public class BonReceptionDTO {
	
	private Long id;
	private Long produit;
	private String reference;
	private Calendar dateIntroduction;
	private Calendar dateLivraison;
	private String barCode;
	private String observations;
	private String bcClient;
	private Long nombreRouleau;
	private Double laizeFini;
	private List<TraitementDTO> listeTraitements;

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getProduit() {
		return produit;
	}


	public void setProduit(Long produit) {
		this.produit = produit;
	}


	public String getReference() {
		return reference;
	}


	public void setReference(String reference) {
		this.reference = reference;
	}


	public Calendar getDateIntroduction() {
		return dateIntroduction;
	}


	public void setDateIntroduction(Calendar dateIntroduction) {
		this.dateIntroduction = dateIntroduction;
	}


	public Calendar getDateLivraison() {
		return dateLivraison;
	}


	public void setDateLivraison(Calendar dateLivraison) {
		this.dateLivraison = dateLivraison;
	}


	public String getObservations() {
		return observations;
	}


	public void setObservations(String observations) {
		this.observations = observations;
	}


	public String getBcClient() {
		return bcClient;
	}


	public void setBcClient(String bcClient) {
		this.bcClient = bcClient;
	}

	public Long getNombreRouleau() {
		return nombreRouleau;
	}


	public void setNombreRouleau(Long nombreRouleau) {
		this.nombreRouleau = nombreRouleau;
	}


	public Double getLaizeFini() {
		return laizeFini;
	}


	public void setLaizeFini(Double laizeFini) {
		this.laizeFini = laizeFini;
	}

	public List<TraitementDTO> getListeTraitements() {
		return listeTraitements;
	}


	public void setListeTraitements(List<TraitementDTO> listeTraitements) {
		this.listeTraitements = listeTraitements;
	}

}
