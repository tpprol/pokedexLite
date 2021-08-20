package pokedexLite.application.servicio;

import java.util.List;

import pokedexLite.application.pokemon.Pokemon;

public interface PokemonService {
	public List<Pokemon> listarPokemones();
	
	public void guardar(Pokemon pokemon);
	
	public void eliminar(Pokemon pokemon);
	
	public Pokemon encontrarPokemon(String pokemon);
	
	public List<String> listarTipos();
	
	public List<Pokemon> listarPokemonesPorNombre(String nombre);
	
	public List<Pokemon> listarPokemonesPorTipo(String tipo);
}
