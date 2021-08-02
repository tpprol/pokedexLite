package db;

import static org.junit.Assert.*;

import org.junit.Test;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.test.AbstractPersistenceTest;

import pokedexLite.Evolucion;
import pokedexLite.Pokedex;
import pokedexLite.Pokemon;
import pokedexLite.Tipo;

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
        charmander.agregarTipo(Tipo.FUEGO);
        Evolucion evoCharmeleon = new Evolucion("Charmeleon",16);
        evoCharmeleon.agregarTipo(Tipo.FUEGO);
        charmander.agregarEvolucion(evoCharmeleon);
        Evolucion evoCharizard = new Evolucion("Charizard",36);
        evoCharizard.agregarTipo(Tipo.FUEGO);
        evoCharizard.agregarTipo(Tipo.VOLADOR);
        charmander.agregarEvolucion(evoCharizard);
        charmander.agregarHabilidad("Mar llamas");
        charmander.agregarHabilidad("Poder solar");


        Pokemon bulbasaur = new Pokemon("Bulbasaur",1);
        bulbasaur.agregarTipo(Tipo.PLANTA);
        bulbasaur.agregarTipo(Tipo.VENENO);
        Evolucion evoIvysaur = new Evolucion("Ivysaur",16);
        evoIvysaur.agregarTipo(Tipo.PLANTA);
        evoIvysaur.agregarTipo(Tipo.VENENO);
        bulbasaur.agregarEvolucion(evoIvysaur);
        Evolucion evoVenusaur = new Evolucion("Venusaur",32);
        evoVenusaur.agregarTipo(Tipo.PLANTA);
        evoVenusaur.agregarTipo(Tipo.VENENO);
        bulbasaur.agregarEvolucion(evoVenusaur);
        bulbasaur.agregarHabilidad("Espesura");
        bulbasaur.agregarHabilidad("Clorofila");

        
        Pokemon squirtle = new Pokemon("Squirtle",1);
        squirtle.agregarTipo(Tipo.AGUA);
        Evolucion evoWartortle = new Evolucion("Wartortle",16);
        evoWartortle.agregarTipo(Tipo.AGUA);
        squirtle.agregarEvolucion(evoWartortle);
        Evolucion evoBlastoise = new Evolucion("Blastoise",36);
        evoBlastoise.agregarTipo(Tipo.AGUA);
        squirtle.agregarEvolucion(evoBlastoise);
        squirtle.agregarHabilidad("Torrente");
        squirtle.agregarHabilidad("Cura lluvia");
        
        
        Pokemon chikorita = new Pokemon("Chikorita",1);
        chikorita.agregarTipo(Tipo.PLANTA);
        Evolucion evoBayleef = new Evolucion("Bayleef",16);
        evoBayleef.agregarTipo(Tipo.PLANTA);
        chikorita.agregarEvolucion(evoBayleef);
        Evolucion evoMeganium = new Evolucion("Meganium",32);
        evoMeganium.agregarTipo(Tipo.PLANTA);
        chikorita.agregarEvolucion(evoMeganium);
        chikorita.agregarHabilidad("Espensura");
        chikorita.agregarHabilidad("Defensa hoja");

        
        Pokemon cyndaquil = new Pokemon("Cyndaquil",1);
        cyndaquil.agregarTipo(Tipo.FUEGO);
        Evolucion evoQuilava = new Evolucion("Quilava",14);
        evoQuilava.agregarTipo(Tipo.FUEGO);
        cyndaquil.agregarEvolucion(evoQuilava);
        Evolucion evoTyphlosion = new Evolucion("Typhlosion",36);
        evoTyphlosion.agregarTipo(Tipo.FUEGO);
        cyndaquil.agregarEvolucion(evoTyphlosion);
        cyndaquil.agregarHabilidad("Mar llamas");
        cyndaquil.agregarHabilidad("Absorbe fuego");

        
        Pokemon aron = new Pokemon("Aron",1);
        aron.agregarTipo(Tipo.ACERO);
        aron.agregarTipo(Tipo.ROCA);
        Evolucion evoLairon = new Evolucion("Lairon",32);
        evoLairon.agregarTipo(Tipo.ACERO);
        evoLairon.agregarTipo(Tipo.ROCA);
        aron.agregarEvolucion(evoLairon);
        Evolucion evoAggron = new Evolucion("Aggron",42);
        evoAggron.agregarTipo(Tipo.ACERO);
        evoAggron.agregarTipo(Tipo.ROCA);
        aron.agregarEvolucion(evoAggron);
        aron.agregarHabilidad("Robustez");
        aron.agregarHabilidad("Metal pesado");


        Pokemon snorunt = new Pokemon("Snorunt",1);
        snorunt.agregarTipo(Tipo.HIELO);
        Evolucion evoGlalie = new Evolucion("Glalie",42);
        evoGlalie.agregarTipo(Tipo.HIELO);
        snorunt.agregarEvolucion(evoGlalie);
        snorunt.agregarHabilidad("Foco interno");
        snorunt.agregarHabilidad("Veleta");


        Pokemon fletchling = new Pokemon("Fletchling",1);
        fletchling.agregarTipo(Tipo.NORMAL);
        fletchling.agregarTipo(Tipo.VOLADOR);
        Evolucion evoFletchinder = new Evolucion("Fletchinder",17);
        evoFletchinder.agregarTipo(Tipo.FUEGO);
        evoFletchinder.agregarTipo(Tipo.VOLADOR);
        fletchling.agregarEvolucion(evoFletchinder);
        Evolucion evoTalonflame = new Evolucion("Talonflame",35);
        evoTalonflame.agregarTipo(Tipo.FUEGO);
        evoTalonflame.agregarTipo(Tipo.VOLADOR);
        fletchling.agregarEvolucion(evoTalonflame);
        fletchling.agregarHabilidad("Sacapecho");
        fletchling.agregarHabilidad("Alas vendaval");

        Pokemon chimchar = new Pokemon("Chimchar",1);
        chimchar.agregarTipo(Tipo.FUEGO);
        Evolucion evoMonferno = new Evolucion("Monferno",14);
        evoMonferno.agregarTipo(Tipo.FUEGO);
        evoMonferno.agregarTipo(Tipo.LUCHA);
        fletchling.agregarEvolucion(evoMonferno);
        Evolucion evoInfernape = new Evolucion("Infernape",36);
        evoInfernape.agregarTipo(Tipo.FUEGO);
        evoInfernape.agregarTipo(Tipo.LUCHA);
        chimchar.agregarEvolucion(evoInfernape);
        chimchar.agregarHabilidad("Mar llamas");
        chimchar.agregarHabilidad("Puno ferreo");

        Pokemon caterpie = new Pokemon("Caterpie",1);
        caterpie.agregarTipo(Tipo.BICHO);
        Evolucion evoMetapod = new Evolucion("Metapod",7);
        evoMetapod.agregarTipo(Tipo.BICHO);
        caterpie.agregarEvolucion(evoMetapod);
        Evolucion evoButterfree = new Evolucion("Butterfree",10);
        evoButterfree.agregarTipo(Tipo.BICHO);
        evoButterfree.agregarTipo(Tipo.VOLADOR);
        caterpie.agregarEvolucion(evoButterfree);
        caterpie.agregarHabilidad("Polvo escudo");
        caterpie.agregarHabilidad("Fuga");

        Pokemon deino = new Pokemon("Deino",1);
        deino.agregarTipo(Tipo.SINIESTRO);
        deino.agregarTipo(Tipo.DRAGON);
        Evolucion evoZweilous = new Evolucion("Zweilous",50);
        evoZweilous.agregarTipo(Tipo.SINIESTRO);
        evoZweilous.agregarTipo(Tipo.DRAGON);
        deino.agregarEvolucion(evoZweilous);
        Evolucion evoHydreigon = new Evolucion("Hydreigon",64);
        evoHydreigon.agregarTipo(Tipo.SINIESTRO);
        evoHydreigon.agregarTipo(Tipo.DRAGON);
        deino.agregarEvolucion(evoHydreigon);
        deino.agregarHabilidad("Entusiasmo");

        Pokemon ralts = new Pokemon("Ralts",1);
        ralts.agregarTipo(Tipo.PSIQUICO);
        ralts.agregarTipo(Tipo.HADA);
        Evolucion evoKirlia = new Evolucion("Kirlia",20);
        evoKirlia.agregarTipo(Tipo.PSIQUICO);
        evoKirlia.agregarTipo(Tipo.HADA);
        ralts.agregarEvolucion(evoKirlia);
        Evolucion evoGardevoir = new Evolucion("Gardevoir",34);
        evoGardevoir.agregarTipo(Tipo.PSIQUICO);
        evoGardevoir.agregarTipo(Tipo.HADA);
        ralts.agregarEvolucion(evoGardevoir);
        ralts.agregarHabilidad("Sincronia");
        ralts.agregarHabilidad("Rastro");

        Pokemon shuppet = new Pokemon("Shuppet",1);
        shuppet.agregarTipo(Tipo.FANTASMA);
        Evolucion evoBanette = new Evolucion("Banette",37);
        evoBanette.agregarTipo(Tipo.FANTASMA);
        shuppet.agregarEvolucion(evoBanette);
        shuppet.agregarHabilidad("Insomnio");
        shuppet.agregarHabilidad("Cacheo");
        

        withTransaction(() -> {
        Pokedex.instance().agregarPokemon(charmander);
        Pokedex.instance().agregarPokemon(bulbasaur);
        Pokedex.instance().agregarPokemon(squirtle);
        Pokedex.instance().agregarPokemon(chikorita);
        Pokedex.instance().agregarPokemon(cyndaquil);
        Pokedex.instance().agregarPokemon(aron);
        Pokedex.instance().agregarPokemon(snorunt);
        Pokedex.instance().agregarPokemon(fletchling);
        Pokedex.instance().agregarPokemon(chimchar);
        Pokedex.instance().agregarPokemon(caterpie);
        Pokedex.instance().agregarPokemon(deino);
        Pokedex.instance().agregarPokemon(ralts);
        Pokedex.instance().agregarPokemon(shuppet);});
        
        Pokemon charmander2 =  Pokedex.instance().getPokemon("Charmander");
        assertEquals(charmander2.getNombre(), charmander.getNombre());
        assertSame(charmander2, charmander);
	}

}
