package com.dihaw.dto;

/**
 * Traitement DTO.
 * 
 * @author Wahid Gazzah
 * @since 0.0.1
 */
public class TraitementDTO {
	
	private Long id;
	private Long traitementId;
	private String observations;
	
	
	/**
	 *  {@link TraitementDTO} default constructor
	 */
	public TraitementDTO(){
		
	}

	/**
	 * @param id
	 * @param traitementId
	 * @param observations
	 */
	public TraitementDTO(Long id, Long traitementId, String observations) {
		this.id = id;
		this.traitementId = traitementId;
		this.observations = observations;
	}




	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getTraitementId() {
		return traitementId;
	}
	public void setTraitementId(Long traitementId) {
		this.traitementId = traitementId;
	}
	
	public String getObservations() {
		return observations;
	}
	public void setObservations(String observations) {
		this.observations = observations;
	}

	
	

}
