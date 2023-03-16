package com.molt.desafiorickandmorty.test;

import com.molt.desafiorickandmorty.dto.CharacterR;
import com.molt.desafiorickandmorty.dto.CharacterLocationR;
import com.molt.desafiorickandmorty.dto.LocationR;
import com.molt.desafiorickandmorty.dto.OutputCharacterR;
import com.molt.desafiorickandmorty.error.CharacterNotFoundException;
import com.molt.desafiorickandmorty.service.Resources;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class ResourcesTest {
    Resources mockResources;
    @Autowired
    Resources resources;
    @BeforeEach
    void setup() {

        mockResources = Mockito.mock(Resources.class);
    }

    @Test
    @DisplayName("testCreateCharacterOk")
    void should_return_a_character() throws CharacterNotFoundException {
        //GIVEN
        CharacterR character = new CharacterR();
        List<String> episodes = new ArrayList<>();
        episodes.add("mock episode");
        CharacterLocationR characterLocationR = new CharacterLocationR();
        characterLocationR.setName("mock location");
        characterLocationR.setUrl("http://url.com");
        character.setName("mock");
        character.setEpisode(episodes);
        character.setLocation(characterLocationR);
        Mockito.when(mockResources.getCharacter(2)).thenReturn(character);
        Mockito.when(mockResources.getLocationByUrl("http://url.com")).thenReturn(new LocationR());

        //WHEN
        OutputCharacterR resultado = resources.createCharacter( mockResources.getCharacter(2), mockResources.getLocationByUrl("http://url.com") );

        //THEN
        assertEquals("http://url.com", resultado.getOrigin().getUrl());
        assertEquals("mock",resultado.getName());
    }


    @Test
    @DisplayName("testCharacterNotFoundException")
    void should_return_a_character_not_found_exception() {
        //GIVEN
        Mockito.when(mockResources.getCharacter(4)).thenReturn(null);
        Mockito.when(mockResources.getLocationByUrl("http://url.com")).thenReturn(new LocationR());

        //WHEN
        CharacterR testCharacter = mockResources.getCharacter(4);
        LocationR testLocation = mockResources.getLocationByUrl("http://url.com");

        //THEN
        assertThrows(CharacterNotFoundException.class, () -> resources.createCharacter(testCharacter, testLocation));
    }
}