package pokedex;

import java.util.List;
import java.util.stream.Collectors;

import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;

import pokemon.Evolucion;
import pokemon.Pokemon;

public class Pokedex implements WithGlobalEntityManager {
	private static final Pokedex INSTANCE = new Pokedex();
	
	public static Pokedex instance() {
		return INSTANCE;
	}
	
	public void agregarEvolucion(Evolucion evolucion) {
		entityManager().persist(evolucion);
	}
	
	public void sacarEvolucion(Evolucion evolucion) {
		entityManager().remove(evolucion);
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
	
	public List<Pokemon> gelPokemonesDeTipo(String tipo){
		return this.gelAllPokemon().stream().filter(poke->poke.getTipos().contains(tipo)).collect(Collectors.toList());
	}
	
    public void mostrarPokemones(List<Pokemon> pokemones) {
        for(int i=0;i<pokemones.size();i++) {
            System.out.printf("\nPokemon Numero %d\n",i+1);
            Pokemon pokemon = pokemones.get(i);
            pokemon.mostrarInformacion();
        }
    }
    
    public void mostrarTodosLosPokemones() {
        List<Pokemon> pokemones = this.gelAllPokemon();
        if(pokemones.isEmpty())
        	System.out.printf("No hay Pokemones en la base de datos\n");
        else
        	this.mostrarPokemones(pokemones);
    }
    
    public int numeroDePokemones() {
    	return this.gelAllPokemon().size();
    }
    
    public static void main(String[] args) {  
    	Interfaz.menuPrincipal();
    
    }
}