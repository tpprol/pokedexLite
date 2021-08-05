package db;

import static org.junit.Assert.*;

import org.junit.Test;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.test.AbstractPersistenceTest;

import pokemon.Evolucion;
import pokedex.Pokedex;
import pokemon.Pokemon;

public class ContextTest extends AbstractPersistenceTest implements WithGlobalEntityManager {

	@Test
	public void contextUp() {
		assertNotNull(entityManager());
	}

	@Test
	public void contextUpWithTransaction() throws Exception {
		withTransaction(() -> {});
	}
	
	@Test
	public void llenadoTablas(){
		
        Pokemon charmander = new Pokemon("Charmander",1);
        charmander.agregarTipo("Fuego");
        Evolucion evoCharmeleon = new Evolucion("Charmeleon",16);
        evoCharmeleon.agregarTipo("Fuego");
        Evolucion evoCharizard = new Evolucion("Charizard",36);
        evoCharizard.agregarTipo("Fuego");
        evoCharizard.agregarTipo("Volador");
        charmander.agregarHabilidad("Mar llamas");
        charmander.agregarHabilidad("Poder solar");


        Pokemon bulbasaur = new Pokemon("Bulbasaur",1);
        bulbasaur.agregarTipo("Planta");
        bulbasaur.agregarTipo("Veneno");
        Evolucion evoIvysaur = new Evolucion("Ivysaur",16);
        evoIvysaur.agregarTipo("Planta");
        evoIvysaur.agregarTipo("Veneno");
        Evolucion evoVenusaur = new Evolucion("Venusaur",32);
        evoVenusaur.agregarTipo("Planta");
        evoVenusaur.agregarTipo("Veneno");
        bulbasaur.agregarHabilidad("Espesura");
        bulbasaur.agregarHabilidad("Clorofila");

        
        Pokemon squirtle = new Pokemon("Squirtle",1);
        squirtle.agregarTipo("Agua");
        Evolucion evoWartortle = new Evolucion("Wartortle",16);
        evoWartortle.agregarTipo("Agua");
        Evolucion evoBlastoise = new Evolucion("Blastoise",36);
        evoBlastoise.agregarTipo("Agua");
        squirtle.agregarHabilidad("Torrente");
        squirtle.agregarHabilidad("Cura lluvia");
        
        
        Pokemon chikorita = new Pokemon("Chikorita",1);
        chikorita.agregarTipo("Planta");
        Evolucion evoBayleef = new Evolucion("Bayleef",16);
        evoBayleef.agregarTipo("Planta");
        Evolucion evoMeganium = new Evolucion("Meganium",32);
        evoMeganium.agregarTipo("Planta");
        chikorita.agregarHabilidad("Espensura");
        chikorita.agregarHabilidad("Defensa hoja");

        
        Pokemon cyndaquil = new Pokemon("Cyndaquil",1);
        cyndaquil.agregarTipo("Fuego");
        Evolucion evoQuilava = new Evolucion("Quilava",14);
        evoQuilava.agregarTipo("Fuego");
        Evolucion evoTyphlosion = new Evolucion("Typhlosion",36);
        evoTyphlosion.agregarTipo("Fuego");
        cyndaquil.agregarHabilidad("Mar llamas");
        cyndaquil.agregarHabilidad("Absorbe fuego");

        
        Pokemon aron = new Pokemon("Aron",1);
        aron.agregarTipo("Acero");
        aron.agregarTipo("Roca");
        Evolucion evoLairon = new Evolucion("Lairon",32);
        evoLairon.agregarTipo("Acero");
        evoLairon.agregarTipo("Roca");
        Evolucion evoAggron = new Evolucion("Aggron",42);
        evoAggron.agregarTipo("Acero");
        evoAggron.agregarTipo("Roca");
        aron.agregarHabilidad("Robustez");
        aron.agregarHabilidad("Metal pesado");


        Pokemon snorunt = new Pokemon("Snorunt",1);
        snorunt.agregarTipo("Hielo");
        Evolucion evoGlalie = new Evolucion("Glalie",42);
        evoGlalie.agregarTipo("Hielo");
        snorunt.agregarHabilidad("Foco interno");
        snorunt.agregarHabilidad("Veleta");


        Pokemon fletchling = new Pokemon("Fletchling",1);
        fletchling.agregarTipo("Normal");
        fletchling.agregarTipo("Volador");
        Evolucion evoFletchinder = new Evolucion("Fletchinder",17);
        evoFletchinder.agregarTipo("Fuego");
        evoFletchinder.agregarTipo("Volador");
        Evolucion evoTalonflame = new Evolucion("Talonflame",35);
        evoTalonflame.agregarTipo("Fuego");
        evoTalonflame.agregarTipo("Volador");
        fletchling.agregarHabilidad("Sacapecho");
        fletchling.agregarHabilidad("Alas vendaval");

        Pokemon chimchar = new Pokemon("Chimchar",1);
        chimchar.agregarTipo("Fuego");
        Evolucion evoMonferno = new Evolucion("Monferno",14);
        evoMonferno.agregarTipo("Fuego");
        evoMonferno.agregarTipo("Lucha");
        Evolucion evoInfernape = new Evolucion("Infernape",36);
        evoInfernape.agregarTipo("Fuego");
        evoInfernape.agregarTipo("Lucha");
        chimchar.agregarHabilidad("Mar llamas");
        chimchar.agregarHabilidad("Puno ferreo");

        Pokemon caterpie = new Pokemon("Caterpie",1);
        caterpie.agregarTipo("Bicho");
        Evolucion evoMetapod = new Evolucion("Metapod",7);
        evoMetapod.agregarTipo("Bicho");
        Evolucion evoButterfree = new Evolucion("Butterfree",10);
        evoButterfree.agregarTipo("Bicho");
        evoButterfree.agregarTipo("Volador");
        caterpie.agregarHabilidad("Polvo escudo");
        caterpie.agregarHabilidad("Fuga");

        Pokemon deino = new Pokemon("Deino",1);
        deino.agregarTipo("Siniestro");
        deino.agregarTipo("Dragon");
        Evolucion evoZweilous = new Evolucion("Zweilous",50);
        evoZweilous.agregarTipo("Siniestro");
        evoZweilous.agregarTipo("Dragon");
        Evolucion evoHydreigon = new Evolucion("Hydreigon",64);
        evoHydreigon.agregarTipo("Siniestro");
        evoHydreigon.agregarTipo("Dragon");
        deino.agregarHabilidad("Entusiasmo");

        Pokemon ralts = new Pokemon("Ralts",1);
        ralts.agregarTipo("Psiquico");
        ralts.agregarTipo("Hada");
        Evolucion evoKirlia = new Evolucion("Kirlia",20);
        evoKirlia.agregarTipo("Psiquico");
        evoKirlia.agregarTipo("Hada");
        Evolucion evoGardevoir = new Evolucion("Gardevoir",34);
        evoGardevoir.agregarTipo("Psiquico");
        evoGardevoir.agregarTipo("Hada");
        ralts.agregarHabilidad("Sincronia");
        ralts.agregarHabilidad("Rastro");

        Pokemon shuppet = new Pokemon("Shuppet",1);
        shuppet.agregarTipo("Fantasma");
        Evolucion evoBanette = new Evolucion("Banette",37);
        evoBanette.agregarTipo("Fantasma");
        shuppet.agregarHabilidad("Insomnio");
        shuppet.agregarHabilidad("Cacheo");
        
        withTransaction(() -> {
        charmander.agregarEvolucion(evoCharmeleon);
        charmander.agregarEvolucion(evoCharizard);
        Pokedex.instance().agregarEvolucion(charmander);
        bulbasaur.agregarEvolucion(evoIvysaur);
        bulbasaur.agregarEvolucion(evoVenusaur);
        Pokedex.instance().agregarEvolucion(bulbasaur);
        squirtle.agregarEvolucion(evoWartortle);
        squirtle.agregarEvolucion(evoBlastoise);
        Pokedex.instance().agregarEvolucion(squirtle);
        chikorita.agregarEvolucion(evoBayleef);
        chikorita.agregarEvolucion(evoMeganium);
        Pokedex.instance().agregarEvolucion(chikorita);
        cyndaquil.agregarEvolucion(evoQuilava);
        cyndaquil.agregarEvolucion(evoTyphlosion);
        Pokedex.instance().agregarEvolucion(cyndaquil);
        aron.agregarEvolucion(evoLairon);
        aron.agregarEvolucion(evoAggron);
        Pokedex.instance().agregarEvolucion(aron);
        snorunt.agregarEvolucion(evoGlalie);
        Pokedex.instance().agregarEvolucion(snorunt);
        fletchling.agregarEvolucion(evoFletchinder);
        fletchling.agregarEvolucion(evoTalonflame);
        Pokedex.instance().agregarEvolucion(fletchling);
        chimchar.agregarEvolucion(evoMonferno);
        chimchar.agregarEvolucion(evoInfernape);
        Pokedex.instance().agregarEvolucion(chimchar);
        caterpie.agregarEvolucion(evoMetapod);
        caterpie.agregarEvolucion(evoButterfree);
        Pokedex.instance().agregarEvolucion(caterpie);
        deino.agregarEvolucion(evoZweilous);
        deino.agregarEvolucion(evoHydreigon);
        Pokedex.instance().agregarEvolucion(deino);
        ralts.agregarEvolucion(evoKirlia);
        ralts.agregarEvolucion(evoGardevoir);
        Pokedex.instance().agregarEvolucion(ralts);
        shuppet.agregarEvolucion(evoBanette);
        Pokedex.instance().agregarEvolucion(shuppet);
        });
        Pokemon charmander2 =  Pokedex.instance().getPokemon("Charmander");
        assertEquals(charmander2.getNombre(), charmander.getNombre());
        assertSame(charmander2, charmander);
	}

}
