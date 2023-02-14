package com.molt.desafiorickandmorty.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.molt.desafiorickandmorty.dto.CharacterR;
import com.molt.desafiorickandmorty.dto.LocationDetail;
import com.molt.desafiorickandmorty.dto.OutputCharacterR;
import com.molt.desafiorickandmorty.dto.OutputOrigin;

@Service
public class Resources {
	
	private static final Logger logger = LoggerFactory.getLogger(Resources.class);
	
	
	public CharacterR getCharacter(int id) {
		String uri = "https://rickandmortyapi.com/api/character/"+id;
		RestTemplate restTemplate = new RestTemplate();
		CharacterR character=null;
		try {
			character = restTemplate.getForObject(uri,CharacterR.class);		
		}
		catch(Exception e) {
			logger.error("Error al consultar API de personajes ", e);
		}
			
		return character;
	}
	
	public LocationDetail getLocation(int id) {
		String uri = "https://rickandmortyapi.com/api/location/"+id;
		RestTemplate restTemplate = new RestTemplate();
		LocationDetail location=null;
		try {
			location = restTemplate.getForObject(uri,LocationDetail.class);	
		}
		catch(Exception e) {
			logger.error("Error al consultar API de ubicaciones ", e);
		}
			
		return location;
	}
	
	public LocationDetail getLocationByUrl(String url) {
		RestTemplate restTemplate = new RestTemplate();
		LocationDetail location=null;
		try {
			location = restTemplate.getForObject(url,LocationDetail.class);	
		}
		catch(Exception e) {
			logger.error("Error al consultar API de ubicaciones ", e);
		}
			
		return location;
	}
	
	public OutputCharacterR createCharacter(CharacterR character, LocationDetail originParam) {
		OutputCharacterR resultCharacter = new OutputCharacterR();
		OutputOrigin origin = new OutputOrigin();
		
		resultCharacter.setId(character.getId());
		resultCharacter.setName(character.getName());
		resultCharacter.setStatus(character.getStatus());
		resultCharacter.setSpecies(character.getSpecies());
		resultCharacter.setType(character.getType());
		resultCharacter.setEpisode_count(character.getEpisode().size());
		if(originParam!=null){
			origin.setName(originParam.getName());
			origin.setDimension(originParam.getDimension());
			origin.setUrl(character.getLocation().getUrl());
			origin.setResidents(originParam.getResidents());
			resultCharacter.setOrigin(origin);
		}

		
		return resultCharacter;
	}
	
	
	public OutputCharacterR createFinalCharacter(CharacterR character) {
		LocationDetail location=null;
		if(character==null) {
			return createCharacter(null, null);
		}
		if(character.getOrigin()!=null && character.getOrigin().getUrl()!=null) {
			location = getLocationByUrl(character.getOrigin().getUrl());
		}
		return createCharacter(character, location);
	}

}
