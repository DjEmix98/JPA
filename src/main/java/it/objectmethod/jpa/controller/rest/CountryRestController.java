package it.objectmethod.jpa.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.objectmethod.jpa.entity.Country;
import it.objectmethod.jpa.entity.CountryFind;
import it.objectmethod.jpa.repo.CountryRepository;

@RestController
@RequestMapping("api/nations")
public class CountryRestController {

	@Autowired
	private CountryRepository countryRepo;

	@GetMapping("/continent")
	public List<String> findContinents(){
		List<String> listContinents = countryRepo.findContinents();
		return listContinents;
	}

	@GetMapping("/list-all")
	public List<Country> getAllCountries(){
		List<Country> listCountries = countryRepo.findAll();
		return listCountries;
	}

	@GetMapping("/by-continent")
	public List<Country> countryByContinent(@RequestParam("continent") String continent){
		List<Country> listCountries = countryRepo.findByContinent(continent);
		return listCountries;
	}

	@PostMapping("/search")
	public List<Country> countryFind(@RequestBody CountryFind country){
		
		
		if(country.getContinent()==null) {

			country.setContinent("NO");
		}
		if(country.getName()==null) {
			
			country.setName("%%");
		} else {
			country.setName("%"+country.getName()+"%");
		}
		List<Country> countryList = countryRepo.countryFindByContinentAndSurfaceArea(country.getName(), country.getPopulationMin(), country.getPopulationMax(),
				country.getSurfaceAreaMax(), country.getSurfaceAreaMin(), country.getContinent());
		return countryList;
	}
}
