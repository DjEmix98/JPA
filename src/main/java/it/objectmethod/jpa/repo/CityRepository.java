package it.objectmethod.jpa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import it.objectmethod.jpa.entity.City;

public interface CityRepository extends JpaRepository<City,Long>{

	@Query(value="select c "
			+ " from City c"
			+ " where name like :name "
			+ " and (c.population>:populationMin "
			+ " or :populationMin=0) "
			+ " and (c.population<:populationMax or :populationMax=0)"
			+ " and (c.nation.code = :countryCode or :countryCode = 'NO')")
	public List<City> findCity(@Param("name") String name, @Param("populationMin") int populationMin, 
			@Param("populationMax") int populationMax, @Param("countryCode") String countryCode);

	@Query(value="select c from City c where c.nation.code=?1")
	public List<City> findByCountryCode(String countryCode);

}
