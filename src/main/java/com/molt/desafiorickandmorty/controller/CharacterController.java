package com.molt.desafiorickandmorty.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.molt.desafiorickandmorty.dto.CharacterR;
import com.molt.desafiorickandmorty.dto.OutputCharacterR;
import com.molt.desafiorickandmorty.service.Resources;

@RestController
public class CharacterController implements ICharacterController {
    private final Resources resources;

    public CharacterController(Resources resources) {
        this.resources = resources;
    }

    @GetMapping("/api/character/{id}")
    public ResponseEntity<OutputCharacterR> getCharacter(@PathVariable("id") int id) {
        CharacterR character = resources.getCharacter(id);
        OutputCharacterR outputCharacterR = resources.createFinalCharacter(character);
        return new ResponseEntity<>(outputCharacterR, HttpStatus.OK);
    }
}