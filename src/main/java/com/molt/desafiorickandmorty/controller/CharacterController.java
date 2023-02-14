package com.molt.desafiorickandmorty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.molt.desafiorickandmorty.dto.CharacterR;
import com.molt.desafiorickandmorty.dto.OutputCharacterR;
import com.molt.desafiorickandmorty.service.Resources;

@RestController
public class CharacterController {
	
	@Autowired
	Resources resources;

	@GetMapping("/alive")
	public String hello() {
		return "desafiorickandmorty is working";
	}
	
	@GetMapping("/api/character/{id}")
	public ResponseEntity<Object> getCharacter(@PathVariable("id") int id) {
		
		CharacterR character = resources.getCharacter(id);
		
		if(character==null) return ResponseEntity
		        .status(HttpStatus.FOUND)
		        .contentType(MediaType.APPLICATION_PROBLEM_JSON)
		        .body("No se encontraron personajes");
		
		OutputCharacterR outputCharacterR = resources.createFinalCharacter(character);
		return new ResponseEntity<>(outputCharacterR, HttpStatus.OK);
	}
}
