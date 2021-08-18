package TestPokedex;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.test.AbstractPersistenceTest;

import pokemon.Evolucion;
import pokedex.Pokedex;
import pokemon.Pokemon;

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
        Pokedex.instance().agregarEvolucion(corphish);
        entityManager().getTransaction().commit();
        

    	Pokemon pokemon = Pokedex.instance().getPokemon("Corphish");    	
    	assertEquals(corphish.getNombre(), pokemon.getNombre());
    	assertSame(corphish, pokemon);
    	
    	entityManager().getTransaction().begin();
    	Pokedex.instance().sacarEvolucion(corphish);
    	Pokedex.instance().sacarEvolucion(evoCrawdaunt);
    	entityManager().getTransaction().commit();
    }
    
    @Test
    public void actualizarPokemon() {
    	String nombrePokemon = "Charmander";
    	Pokemon pokemon = Pokedex.instance().getPokemon(nombrePokemon);
    	assertNotNull(pokemon);
    	pokemon.setNivel(10);
    	entityManager().getTransaction().commit();
    	
    	Pokemon pokemon2 = Pokedex.instance().getPokemon(nombrePokemon);
    	assertEquals(10, pokemon2.getNivel());
    	
    	entityManager().getTransaction().begin();
    	pokemon.setNivel(1);
    	entityManager().getTransaction().commit();
    }
}