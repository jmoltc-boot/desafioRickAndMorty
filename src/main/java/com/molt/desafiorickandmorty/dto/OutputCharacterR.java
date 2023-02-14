
package com.molt.desafiorickandmorty.dto;

public class OutputCharacterR {

    private Integer id;
    private String name;
    private String status;
    private String species;
    private String type;
    private int episode_count;
    private OutputOrigin origin;

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

	public int getEpisode_count() {
		return episode_count;
	}

	public void setEpisode_count(int episode_count) {
		this.episode_count = episode_count;
	}

	public OutputOrigin getOrigin() {
		return origin;
	}

	public void setOrigin(OutputOrigin origin) {
		this.origin = origin;
	}



}
