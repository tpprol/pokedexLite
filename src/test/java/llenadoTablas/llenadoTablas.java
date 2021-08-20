package llenadoTablas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.jupiter.api.Test;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;

import pokedexLite.application.pokedex.Pokedex;
import pokedexLite.application.pokemon.Evolucion;
import pokedexLite.application.pokemon.Pokemon;

public class llenadoTablas implements WithGlobalEntityManager {

	@Test
	public void llenado() {
        entityManager().getTransaction().begin();
        
		Pokemon charmander = new Pokemon("Charmander",1);
        charmander.agregarTipo("Fuego");
        Evolucion evoCharmeleon = new Evolucion("Charmeleon",16);
        evoCharmeleon.agregarTipo("Fuego");
        Evolucion evoCharizard = new Evolucion("Charizard",36);
        evoCharizard.agregarTipo("Fuego");
        evoCharizard.agregarTipo("Volador");
        charmander.agregarHabilidad("Mar llamas");
        charmander.agregarHabilidad("Poder solar");
    	Pokedex.instance().agregarEvolucionAPokemon(evoCharmeleon,charmander);
    	Pokedex.instance().agregarEvolucionAPokemon(evoCharizard,charmander);
        Pokedex.instance().agregarEvolucion(charmander);


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
    	Pokedex.instance().agregarEvolucionAPokemon(evoIvysaur,bulbasaur);
    	Pokedex.instance().agregarEvolucionAPokemon(evoVenusaur,bulbasaur);
        Pokedex.instance().agregarEvolucion(bulbasaur);

        
        Pokemon squirtle = new Pokemon("Squirtle",1);
        squirtle.agregarTipo("Agua");
        Evolucion evoWartortle = new Evolucion("Wartortle",16);
        evoWartortle.agregarTipo("Agua");
        Evolucion evoBlastoise = new Evolucion("Blastoise",36);
        evoBlastoise.agregarTipo("Agua");
        squirtle.agregarHabilidad("Torrente");
        squirtle.agregarHabilidad("Cura lluvia");
    	Pokedex.instance().agregarEvolucionAPokemon(evoWartortle,squirtle);
    	Pokedex.instance().agregarEvolucionAPokemon(evoBlastoise,squirtle);
        Pokedex.instance().agregarEvolucion(squirtle);
        
        
        Pokemon chikorita = new Pokemon("Chikorita",1);
        chikorita.agregarTipo("Planta");
        Evolucion evoBayleef = new Evolucion("Bayleef",16);
        evoBayleef.agregarTipo("Planta");
        Evolucion evoMeganium = new Evolucion("Meganium",32);
        evoMeganium.agregarTipo("Planta");
        chikorita.agregarHabilidad("Espensura");
        chikorita.agregarHabilidad("Defensa hoja");
    	Pokedex.instance().agregarEvolucionAPokemon(evoBayleef,chikorita);
    	Pokedex.instance().agregarEvolucionAPokemon(evoMeganium,chikorita);
        Pokedex.instance().agregarEvolucion(chikorita);

        
        Pokemon cyndaquil = new Pokemon("Cyndaquil",1);
        cyndaquil.agregarTipo("Fuego");
        Evolucion evoQuilava = new Evolucion("Quilava",14);
        evoQuilava.agregarTipo("Fuego");
        Evolucion evoTyphlosion = new Evolucion("Typhlosion",36);
        evoTyphlosion.agregarTipo("Fuego");
        cyndaquil.agregarHabilidad("Mar llamas");
        cyndaquil.agregarHabilidad("Absorbe fuego");
    	Pokedex.instance().agregarEvolucionAPokemon(evoQuilava,cyndaquil);
    	Pokedex.instance().agregarEvolucionAPokemon(evoTyphlosion,cyndaquil);
        Pokedex.instance().agregarEvolucion(cyndaquil);

        
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
    	Pokedex.instance().agregarEvolucionAPokemon(evoLairon,aron);
    	Pokedex.instance().agregarEvolucionAPokemon(evoAggron,aron);
        Pokedex.instance().agregarEvolucion(aron);


        Pokemon snorunt = new Pokemon("Snorunt",1);
        snorunt.agregarTipo("Hielo");
        Evolucion evoGlalie = new Evolucion("Glalie",42);
        evoGlalie.agregarTipo("Hielo");
        snorunt.agregarHabilidad("Foco interno");
        snorunt.agregarHabilidad("Veleta");
    	Pokedex.instance().agregarEvolucionAPokemon(evoGlalie,snorunt);
        Pokedex.instance().agregarEvolucion(snorunt);


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
    	Pokedex.instance().agregarEvolucionAPokemon(evoFletchinder,fletchling);
    	Pokedex.instance().agregarEvolucionAPokemon(evoTalonflame,fletchling);
        Pokedex.instance().agregarEvolucion(fletchling);

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
    	Pokedex.instance().agregarEvolucionAPokemon(evoMonferno,chimchar);
    	Pokedex.instance().agregarEvolucionAPokemon(evoInfernape,chimchar);
        Pokedex.instance().agregarEvolucion(chimchar);

        Pokemon caterpie = new Pokemon("Caterpie",1);
        caterpie.agregarTipo("Bicho");
        Evolucion evoMetapod = new Evolucion("Metapod",7);
        evoMetapod.agregarTipo("Bicho");
        Evolucion evoButterfree = new Evolucion("Butterfree",10);
        evoButterfree.agregarTipo("Bicho");
        evoButterfree.agregarTipo("Volador");
        caterpie.agregarHabilidad("Polvo escudo");
        caterpie.agregarHabilidad("Fuga");
    	Pokedex.instance().agregarEvolucionAPokemon(evoMetapod,caterpie);
    	Pokedex.instance().agregarEvolucionAPokemon(evoButterfree,caterpie);
        Pokedex.instance().agregarEvolucion(caterpie);

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
    	Pokedex.instance().agregarEvolucionAPokemon(evoZweilous,deino);
    	Pokedex.instance().agregarEvolucionAPokemon(evoHydreigon,deino);
        Pokedex.instance().agregarEvolucion(deino);

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
    	Pokedex.instance().agregarEvolucionAPokemon(evoKirlia,ralts);
    	Pokedex.instance().agregarEvolucionAPokemon(evoGardevoir,ralts);
        Pokedex.instance().agregarEvolucion(ralts);

        Pokemon shuppet = new Pokemon("Shuppet",1);
        shuppet.agregarTipo("Fantasma");
        Evolucion evoBanette = new Evolucion("Banette",37);
        evoBanette.agregarTipo("Fantasma");
        shuppet.agregarHabilidad("Insomnio");
        shuppet.agregarHabilidad("Cacheo");
    	Pokedex.instance().agregarEvolucionAPokemon(evoBanette,shuppet);
        Pokedex.instance().agregarEvolucion(shuppet);
	       
	    entityManager().getTransaction().commit();
	    
        Pokemon pokemonBuscado = Pokedex.instance().getPokemon("Charmander");
        assertSame(charmander, pokemonBuscado);
        assertEquals(charmander.getNombre(), pokemonBuscado.getNombre());
	}
}
