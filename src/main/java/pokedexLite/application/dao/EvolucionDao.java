package pokedexLite.application.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pokedexLite.application.pokemon.Evolucion;


@Repository
public interface EvolucionDao  extends CrudRepository<Evolucion, String>{
	
}

