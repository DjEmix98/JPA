package it.objectmethod.jpa.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="city")
public class City {

	@GeneratedValue
	@Id
	private Long id;
	
	@Column(name="Name")
	private String name;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="CountryCode")
	private Country nation;
	
	
	@Column(name="District")
	private String district;
	
	@Column(name="Population")
	private Integer population;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public Integer getPopulation() {
		return population;
	}

	public void setPopulation(Integer population) {
		this.population = population;
	}
	
	public Country getNation() {
		return nation;
	}

	public void setNation(Country nation) {
		this.nation = nation;
	}

	
}
