package pokedexLite;

import java.util.List;

import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;

public class Pokedex implements WithGlobalEntityManager{
	private static final Pokedex INSTANCE = new Pokedex();
	
	public static Pokedex instance() {
		return INSTANCE;
	}
	
	public void agregarPokemon(Pokemon pokemon) {
		pokemon.getEvoluciones().forEach(E->entityManager().persist(E));
		entityManager().persist(pokemon);
	}

	public Pokemon getPokemon(String nombre) {
		return entityManager().find(Pokemon.class, nombre);
	}
	
	public void mostrarPokemon(String nombre) {
		Pokemon pokemon = this.getPokemon(nombre);
		pokemon.mostrarInformacion();
	}
	
	public List<Pokemon> gelAllPokemon(){
		return entityManager().createQuery("from Pokemon", Pokemon.class).getResultList();
	}
}