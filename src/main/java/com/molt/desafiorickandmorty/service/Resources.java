package com.molt.desafiorickandmorty.service;

import com.molt.desafiorickandmorty.error.CharacterNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.molt.desafiorickandmorty.dto.CharacterR;
import com.molt.desafiorickandmorty.dto.LocationDetail;
import com.molt.desafiorickandmorty.dto.OutputCharacterR;
import com.molt.desafiorickandmorty.dto.OutputOrigin;


@Service
public class Resources {
	
	private static final Logger logger = LoggerFactory.getLogger(Resources.class);
	
	@Autowired
	private Environment env;
	@Autowired
	RestTemplate restTemplate;
	
	public CharacterR getCharacter(int id) {
		String uri = env.getProperty("uri.character")+id;
		logger.info("url obtenida {}", uri);
		
		CharacterR character=null;
		try {
			character = restTemplate.exchange(uri, HttpMethod.GET, getEntity(), CharacterR.class).getBody();
		}
		catch(Exception e) {
			logger.error("Error al consultar API de personajes ", e);
		}
			
		return character;
	}
	
	public LocationDetail getLocation(int id) {
		String uri = env.getProperty("uri.location")+id;
		LocationDetail location=null;
		try {
			location = restTemplate.exchange(uri, HttpMethod.GET, getEntity(), LocationDetail.class).getBody();
		}
		catch(Exception e) {
			logger.error("Error al consultar API de ubicaciones ", e);
		}
			
		return location;
	}
	
	public LocationDetail getLocationByUrl(String url) {
		LocationDetail location=null;
		try {
			location = restTemplate.exchange(url, HttpMethod.GET, getEntity(), LocationDetail.class).getBody();
		}
		catch(Exception e) {
			logger.error("Error al consultar API de ubicaciones ", e);
		}
			
		return location;
	}
	
	public OutputCharacterR createCharacter(CharacterR character, LocationDetail origin) {
		OutputCharacterR resultCharacter = new OutputCharacterR();
		OutputOrigin resultOrigin = new OutputOrigin();

		if(character==null){
			throw new CharacterNotFoundException();
		}
		
		resultCharacter.setId(character.getId());
		resultCharacter.setName(character.getName());
		resultCharacter.setStatus(character.getStatus());
		resultCharacter.setSpecies(character.getSpecies());
		resultCharacter.setType(character.getType());
		resultCharacter.setEpisode_count(character.getEpisode().size());
		if(origin!=null){
			resultOrigin.setName(origin.getName());
			resultOrigin.setDimension(origin.getDimension());
			resultOrigin.setUrl(character.getLocation().getUrl());
			resultOrigin.setResidents(origin.getResidents());
			resultCharacter.setOrigin(resultOrigin);
		}
		return resultCharacter;
	}
	
	
	public OutputCharacterR createFinalCharacter(CharacterR character) {
		LocationDetail location=null;
		if(character==null) {
			return createCharacter(null, null);
		}
		if(character.getOrigin()!=null && !character.getOrigin().getUrl().isEmpty()) {
			location = getLocationByUrl(character.getOrigin().getUrl());
		}
		return createCharacter(character, location);
	}

	private HttpEntity<String> getEntity(){
		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON.toString()  + ";charset=UTF-8");
		return new HttpEntity<>("", headers);
	}

}
