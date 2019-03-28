package it.objectmethod.jpa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import it.objectmethod.jpa.entity.Country;

public interface CountryRepository extends JpaRepository<Country,String> {

	@Query(value="select distinct continent from Country")
	public List<String>findcontinents();
	
	@Query(value="select c from Country c where continent = ?1")
	public List<Country>countryByContinent(String continent);
	
	@Query(value="select c "
				+ "from Country c " 
				+ "where name like :name "
				+ "and (c.population>:populationMin "
				+ "or :populationMin=0) "
				+"and (c.population<:populationMax or :populationMax=0) "
				+ "and (c.surfaceArea>:surfaceAreaMin "
				+ "or :surfaceAreaMin=0) "
				+"and (c.surfaceArea<:surfaceAreaMax or :surfaceAreaMax=0) "
				+ "and (c.continent = :continent or :continent = 'NO')")
	public List<Country>countryFindByContinentAndSurfaceArea(@Param("name") String name, @Param("populationMin") Integer populationMin, 
			@Param("populationMax") Integer populationMax, @Param("surfaceAreaMax") Float surfaceAreaMax, 
			@Param("surfaceAreaMin") Float surfaceAreaMin, @Param("continent") String continent);
}
