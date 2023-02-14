package com.molt.desafiorickandmorty.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.molt.desafiorickandmorty.dto.CharacterList;
import com.molt.desafiorickandmorty.dto.CharacterR;

@RestController
public class CharacterController {

	@GetMapping("/alive")
	public String hello() {
		return "desafiorickandmorty is working";
	}
	
	@GetMapping("/api/character/{id}")
	public CharacterList getCharacter(@PathVariable("id") int id) {
		String uri = "https://rickandmortyapi.com/api/character/"+id;
		RestTemplate restTemplate = new RestTemplate();
		
		CharacterR character = restTemplate.getForObject(uri,CharacterR.class);		
		return new CharacterList(character);
	}
}
