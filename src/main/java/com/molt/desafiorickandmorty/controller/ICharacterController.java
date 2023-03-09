package com.molt.desafiorickandmorty.controller;

import com.molt.desafiorickandmorty.dto.OutputCharacterR;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

public interface ICharacterController {
    public ResponseEntity<OutputCharacterR> getCharacter(@PathVariable("id") int id);
}
