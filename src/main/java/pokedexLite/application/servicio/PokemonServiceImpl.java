package pokedexLite.application.servicio;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pokedexLite.application.dao.PokemonDao;
import pokedexLite.application.pokemon.Pokemon;

@Service
public class PokemonServiceImpl implements PokemonService {
	@Autowired
	private PokemonDao pokemonDao;
	  
	@Override
	@Transactional(readOnly = true)
	public List<Pokemon> listarPokemones() {
		return (List<Pokemon>) pokemonDao.findAll();
	}

	@Override
	@Transactional
	public void guardar(Pokemon pokemon) {
		pokemonDao.save(pokemon);
	}

	@Override
	@Transactional
	public void eliminar(Pokemon pokemon) {
		pokemonDao.delete(pokemon);
	}

	@Override
	@Transactional(readOnly = true)
	public Pokemon encontrarPokemon(String pokemon) {
		return pokemonDao.findById(pokemon).orElse(null);
	}
	
	@Override
	public List<String> listarTipos() {
    	List<String> tipos = this.listarPokemones().stream().map(poke->poke.getTipos()).flatMap(tip->tip.stream()).collect(Collectors.toList());
    	LinkedHashSet<String> hashSet = new LinkedHashSet<>(tipos);
    	return new ArrayList<>(hashSet);
	}
	
	@Override
	public List<Pokemon> listarPokemonesPorNombre(String nombre) {
		if(nombre.isEmpty() || nombre == null)
			return this.listarPokemones();
		
    	return this.listarPokemones().stream().filter(pok->pok.getNombre().contains(nombre)).collect(Collectors.toList());
	}
	
	@Override
	public List<Pokemon> listarPokemonesPorTipo(String tipo){
		return this.listarPokemones().stream().filter(pok->pok.getTipos().contains(tipo)).collect(Collectors.toList());
	}
	
}
