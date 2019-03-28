package it.objectmethod.jpa.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.objectmethod.jpa.entity.City;
import it.objectmethod.jpa.entity.CityFind;
import it.objectmethod.jpa.repo.CityRepository;

@RestController
@RequestMapping("api/city")
public class CityRestController {

	@Autowired
	private CityRepository cityRepo;
	
	@PostMapping("/search")
	public List<City> searchCity(@RequestBody CityFind city){
		
		if(city.getName()==null) {
			city.setName("%%");
		}
		else {
			city.setName("%"+city.getName()+"%");
		}
		if(city.getCountryCode()==null) {
			
			city.setCountryCode("NO");
		}
		List<City> cityList = cityRepo.findCity(city.getName(), city.getPopulationMin(), 
				city.getPopulationMax(), city.getCountryCode());
		return cityList;
	}
	
	@GetMapping("/{countryCode}/by-code-nation")
	public List<City> cityByCode(@PathVariable("countryCode") String countryCode){
		
		List<City> cityList = cityRepo.findByCountryCode(countryCode);
		return cityList;
	}
	
	@GetMapping("/{id}/find")
	public City setInfo(@PathVariable("id") Long id) {
		
		return cityRepo.findOne(id);
	}
	
	@PostMapping("/save")
	public City save(@RequestBody City city){
		
		return cityRepo.save(city); 
		
	}
	
	@PostMapping("/{id}/delete")
	public void deleteCity(@PathVariable("id") Long id) {
		
		 cityRepo.delete(id);
	}
	
}
