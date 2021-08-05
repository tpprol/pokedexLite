package TestPokedex;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.test.AbstractPersistenceTest;

import pokedexLite.Evolucion;
import pokedexLite.Pokedex;
import pokedexLite.Pokemon;

public class TestPokedex extends AbstractPersistenceTest implements WithGlobalEntityManager {    
    
	@Test
    public void todosLosPokemones() {
		List<Pokemon> pokemones = Pokedex.instance().gelAllPokemon();
		int cantidadDePokemones = pokemones.size();
		System.out.printf("\nListando %d Pokemones\n",cantidadDePokemones);
		
		for(int i=0;i<cantidadDePokemones;i++) {
            System.out.printf("\t%s\n",pokemones.get(i).getNombre());
        }
    	assertTrue(cantidadDePokemones>=10);
    }
	
    @Test
    public void infoPokemon() {
    	String nombrePokemon = "Charmander";
    	Pokemon pokemon = Pokedex.instance().getPokemon(nombrePokemon);
    	
    	assertEquals("Charmander", pokemon.getNombre());
    	assertEquals(1, pokemon.getNivel());
    	assertTrue(pokemon.getTipos().contains("Fuego"));
    }
    
    @Test
    public void habilidadesYEvolucion() {
    	String nombrePokemon = "Charmander";
    	Pokemon pokemon = Pokedex.instance().getPokemon(nombrePokemon);
    	
    	List<String> habilidades = pokemon.getHabilidades();
    	
    	assertTrue(habilidades.contains("Mar llamas"));
    	assertTrue(habilidades.contains("Poder solar"));
    	
    	Evolucion evoPokemon = pokemon.getEvoluciones().get(0);
    	assertTrue(evoPokemon.getNombre().equals("Charmeleon") || evoPokemon.getNombre().equals("Charizard"));
    }
    
    @Test
    public void infoEvoluciones() {
    	String nombrePokemon = "Charmander";
    	Pokemon pokemon = Pokedex.instance().getPokemon(nombrePokemon);
    	
    	List<Evolucion> evoluciones = pokemon.getEvoluciones();
    	
    	Evolucion evolucion1 = evoluciones.get(0);
    	List<String> tiposEvolucion = evolucion1.getTipos();

    	if(evolucion1.getNombre().equals("Charmeleon")) {
        	assertEquals("Charmeleon", evolucion1.getNombre());
        	assertTrue(tiposEvolucion.contains("Fuego"));
        	assertEquals(16, evolucion1.getNivel());
    	} else {
        	assertEquals("Charizard", evolucion1.getNombre());
        	assertTrue(tiposEvolucion.contains("Fuego"));
        	assertTrue(tiposEvolucion.contains("Volador"));
        	assertEquals(36, evolucion1.getNivel());
    	}
    }
    
    @Test
    public void agregarPokemon() {
        Pokemon corphish = new Pokemon("Corphish",10);
        Evolucion evoCrawdaunt = new Evolucion("Crawdaunt",30);
        evoCrawdaunt.agregarTipo("Agua");
        evoCrawdaunt.agregarTipo("Siniestro");
        corphish.agregarEvolucion(evoCrawdaunt);
        corphish.agregarHabilidad("Caparazon");
        corphish.agregarHabilidad("Corte fuerte");
        corphish.agregarTipo("Agua");
        withTransaction(() -> {Pokedex.instance().agregarEvolucion(corphish);});
        

    	Pokemon pokemon = Pokedex.instance().getPokemon("Corphish");    	
    	assertEquals(corphish.getNombre(), pokemon.getNombre());
    	assertSame(corphish, pokemon);
    	withTransaction(() -> {
    	Pokedex.instance().sacarEvolucion(evoCrawdaunt);
    	Pokedex.instance().sacarEvolucion(corphish);});
    }
    
    @Test
    public void actualizarPokemon() {
    	String nombrePokemon = "Charmander";
    	Pokemon pokemon = Pokedex.instance().getPokemon(nombrePokemon);
    	withTransaction(() -> {pokemon.setNivel(10);});
    	
    	Pokemon pokemon2 = Pokedex.instance().getPokemon(nombrePokemon);
    	assertEquals(10, pokemon2.getNivel());
    	
    	withTransaction(() -> {pokemon.setNivel(1);});
    }
}