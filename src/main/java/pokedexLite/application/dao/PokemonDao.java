package pokedexLite.application.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pokedexLite.application.pokemon.Pokemon;

@Repository
public interface PokemonDao extends CrudRepository<Pokemon, String>{
	
}
