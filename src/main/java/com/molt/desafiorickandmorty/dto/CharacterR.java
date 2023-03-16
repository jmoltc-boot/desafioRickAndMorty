
package com.molt.desafiorickandmorty.dto;

import java.io.Serializable;
import java.util.List;
import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class CharacterR implements Serializable {

    private Integer id;
    private String name;
    private String status;
    private String species;
    private String type;
    private String gender;
    private CharacterOriginR characterOriginR;
    private CharacterLocationR characterLocationR;
    private String image;
    private List<String> episode;
    private String url;
    private String created;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public CharacterOriginR getOrigin() {
        return characterOriginR;
    }

    public void setOrigin(CharacterOriginR characterOriginR) {
        this.characterOriginR = characterOriginR;
    }

    public CharacterLocationR getLocation() {
        return characterLocationR;
    }

    public void setLocation(CharacterLocationR characterLocationR) {
        this.characterLocationR = characterLocationR;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<String> getEpisode() {
        return episode;
    }

    public void setEpisode(List<String> episode) {
        this.episode = episode;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

}
