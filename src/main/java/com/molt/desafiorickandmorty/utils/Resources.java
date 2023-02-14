package com.molt.desafiorickandmorty.utils;


import org.springframework.web.client.RestTemplate;
import com.molt.desafiorickandmorty.dto.CharacterList;
import com.molt.desafiorickandmorty.dto.CharacterR;

public class Resources {
	
	public CharacterList getLocation(int id) {
		String uri = "https://rickandmortyapi.com/api/location/"+id;
		RestTemplate restTemplate = new RestTemplate();
		
		CharacterR character = restTemplate.getForObject(uri,CharacterR.class);		
		return new CharacterList(character);
	}
}
