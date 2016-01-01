package com.dihaw.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dihaw.dto.BonReceptionDTO;
import com.dihaw.dto.TraitementDTO;
import com.dihaw.service.JasperReportsService;

/**
 * JasperReports Service implementation of {@link JasperReportsService}.
 * 
 * @author Wahid Gazzah
 * @since 0.0.1
 */
@Service
public class JasperReportsServiceImpl implements JasperReportsService{

	@Override
	public BonReceptionDTO bonReception() {
		
		BonReceptionDTO bonReception = new BonReceptionDTO();
		
		bonReception.setBcClient("bcClient");
		bonReception.setDateIntroduction(Calendar.getInstance());
		bonReception.setDateLivraison(Calendar.getInstance());
		bonReception.setBarCode("dt-123");
		bonReception.setId(35L);
		bonReception.setLaizeFini(25D);
		bonReception.setNombreRouleau(5L);
		bonReception.setObservations("observations");
		bonReception.setProduit(3L);
		bonReception.setReference("ref 123");
		
		List<TraitementDTO> listeTraitements = new ArrayList<TraitementDTO>();
		
		
		for(int i=0; i <10; i++){
			listeTraitements.add(new TraitementDTO(new Long(i), 1L, "observations "+i));
		}
		
		bonReception.setListeTraitements(listeTraitements);
		
		
		return bonReception;
	}

}
