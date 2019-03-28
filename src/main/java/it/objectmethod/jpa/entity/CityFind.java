package it.objectmethod.jpa.entity;

public class CityFind {

	private String name;
	private String countryCode;
	private int populationMax;
	private int populationMin;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public int getPopulationMax() {
		return populationMax;
	}
	public void setPopulationMax(int populationMax) {
		this.populationMax = populationMax;
	}
	public int getPopulationMin() {
		return populationMin;
	}
	public void setPopulationMin(int populationMin) {
		this.populationMin = populationMin;
	}

}
