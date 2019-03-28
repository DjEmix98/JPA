package it.objectmethod.jpa.entity;



public class CountryFind {

	private String code;
	private String name;
	private String continent;
	private int populationMin;
	private int populationMax;
	private float surfaceAreaMax;
	private float surfaceAreaMin;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContinent() {
		return continent;
	}
	public void setContinent(String continent) {
		this.continent = continent;
	}
	public int getPopulationMin() {
		return populationMin;
	}
	public void setPopulationMin(int populationMin) {
		this.populationMin = populationMin;
	}
	public int getPopulationMax() {
		return populationMax;
	}
	public void setPopulationMax(int populationMax) {
		this.populationMax = populationMax;
	}
	public float getSurfaceAreaMax() {
		return surfaceAreaMax;
	}
	public void setSurfaceAreaMax(float surfaceAreaMax) {
		this.surfaceAreaMax = surfaceAreaMax;
	}
	public float getSurfaceAreaMin() {
		return surfaceAreaMin;
	}
	public void setSurfaceAreaMin(float surfaceAreaMin) {
		this.surfaceAreaMin = surfaceAreaMin;
	}


}
