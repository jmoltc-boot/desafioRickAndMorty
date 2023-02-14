package com.molt.desafiorickandmorty.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CharacterList {
    private List<CharacterR> characters;

    public CharacterList() {
    	characters = new ArrayList<>();
    }
    
    public CharacterList(List<CharacterR> characters)
    {
        this.characters = characters;
    }
    
    public CharacterList(CharacterR[] characters)
    {
        this.characters = Arrays.asList(characters);
    }
    
    public CharacterList(CharacterR character)
    {
        this.characters = Arrays.asList(character);
    }

	public List<CharacterR> getCharacters() {
		return characters;
	}

	public void setCharacters(List<CharacterR> characters) {
		this.characters = characters;
	}


}