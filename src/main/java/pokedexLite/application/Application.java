package pokedexLite.application;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import pokedexLite.application.dao.EvolucionDao;
import pokedexLite.application.dao.PokemonDao;
import pokedexLite.application.pokemon.Evolucion;
import pokedexLite.application.pokemon.Pokemon;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @Bean
    public CommandLineRunner run(PokemonDao pokemonDao, EvolucionDao evolucionDao) throws Exception {
        return (String[] args) -> {
            Pokemon charmander = new Pokemon("Charmander",1);
            charmander.agregarTipo("Fuego");
            Evolucion evoCharmeleon = new Evolucion("Charmeleon",16);
            evoCharmeleon.agregarTipo("Fuego");
            Evolucion evoCharizard = new Evolucion("Charizard",36);
            evoCharizard.agregarTipo("Fuego");
            evoCharizard.agregarTipo("Volador");
            charmander.agregarHabilidad("Mar llamas");
            charmander.agregarHabilidad("Poder solar");
            
            charmander.agregarEvolucion(evoCharmeleon);
            charmander.agregarEvolucion(evoCharizard);
            evolucionDao.save(evoCharmeleon);
            evolucionDao.save(evoCharizard);
            pokemonDao.save(charmander);

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
            bulbasaur.agregarEvolucion(evoIvysaur);
            bulbasaur.agregarEvolucion(evoVenusaur);
            evolucionDao.save(evoIvysaur);
            evolucionDao.save(evoVenusaur);
            pokemonDao.save(bulbasaur);

            
            Pokemon squirtle = new Pokemon("Squirtle",1);
            squirtle.agregarTipo("Agua");
            Evolucion evoWartortle = new Evolucion("Wartortle",16);
            evoWartortle.agregarTipo("Agua");
            Evolucion evoBlastoise = new Evolucion("Blastoise",36);
            evoBlastoise.agregarTipo("Agua");
            squirtle.agregarHabilidad("Torrente");
            squirtle.agregarHabilidad("Cura lluvia");
            squirtle.agregarEvolucion(evoWartortle);
            squirtle.agregarEvolucion(evoBlastoise);
        	evolucionDao.save(evoWartortle);
        	evolucionDao.save(evoBlastoise);
            pokemonDao.save(squirtle);
            
            
            Pokemon chikorita = new Pokemon("Chikorita",1);
            chikorita.agregarTipo("Planta");
            Evolucion evoBayleef = new Evolucion("Bayleef",16);
            evoBayleef.agregarTipo("Planta");
            Evolucion evoMeganium = new Evolucion("Meganium",32);
            evoMeganium.agregarTipo("Planta");
            chikorita.agregarHabilidad("Espensura");
            chikorita.agregarHabilidad("Defensa hoja");
            chikorita.agregarEvolucion(evoBayleef);
            chikorita.agregarEvolucion(evoMeganium);
        	evolucionDao.save(evoBayleef);
        	evolucionDao.save(evoMeganium);
            pokemonDao.save(chikorita);

            
            Pokemon cyndaquil = new Pokemon("Cyndaquil",1);
            cyndaquil.agregarTipo("Fuego");
            Evolucion evoQuilava = new Evolucion("Quilava",14);
            evoQuilava.agregarTipo("Fuego");
            Evolucion evoTyphlosion = new Evolucion("Typhlosion",36);
            evoTyphlosion.agregarTipo("Fuego");
            cyndaquil.agregarHabilidad("Mar llamas");
            cyndaquil.agregarHabilidad("Absorbe fuego");
            cyndaquil.agregarEvolucion(evoQuilava);
            cyndaquil.agregarEvolucion(evoTyphlosion);
        	evolucionDao.save(evoQuilava);
        	evolucionDao.save(evoTyphlosion);
            pokemonDao.save(cyndaquil);

            
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
            aron.agregarEvolucion(evoLairon);
            aron.agregarEvolucion(evoAggron);
        	evolucionDao.save(evoLairon);
        	evolucionDao.save(evoAggron);
            pokemonDao.save(aron);


            Pokemon snorunt = new Pokemon("Snorunt",1);
            snorunt.agregarTipo("Hielo");
            Evolucion evoGlalie = new Evolucion("Glalie",42);
            evoGlalie.agregarTipo("Hielo");
            snorunt.agregarHabilidad("Foco interno");
            snorunt.agregarHabilidad("Veleta");
            snorunt.agregarEvolucion(evoGlalie);
        	evolucionDao.save(evoGlalie);
            pokemonDao.save(snorunt);


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
            fletchling.agregarEvolucion(evoFletchinder);
            fletchling.agregarEvolucion(evoTalonflame);
        	evolucionDao.save(evoFletchinder);
        	evolucionDao.save(evoTalonflame);
        	pokemonDao.save(fletchling);

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
        	chimchar.agregarEvolucion(evoMonferno);
        	chimchar.agregarEvolucion(evoInfernape);
        	evolucionDao.save(evoMonferno);
        	evolucionDao.save(evoInfernape);
        	pokemonDao.save(chimchar);

            Pokemon caterpie = new Pokemon("Caterpie",1);
            caterpie.agregarTipo("Bicho");
            Evolucion evoMetapod = new Evolucion("Metapod",7);
            evoMetapod.agregarTipo("Bicho");
            Evolucion evoButterfree = new Evolucion("Butterfree",10);
            evoButterfree.agregarTipo("Bicho");
            evoButterfree.agregarTipo("Volador");
            caterpie.agregarHabilidad("Polvo escudo");
            caterpie.agregarHabilidad("Fuga");
        	caterpie.agregarEvolucion(evoMetapod);
        	caterpie.agregarEvolucion(evoButterfree);
        	evolucionDao.save(evoMetapod);
        	evolucionDao.save(evoButterfree);
        	pokemonDao.save(caterpie);

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
        	deino.agregarEvolucion(evoZweilous);
        	deino.agregarEvolucion(evoHydreigon);
        	evolucionDao.save(evoZweilous);
        	evolucionDao.save(evoHydreigon);
        	pokemonDao.save(deino);

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
        	ralts.agregarEvolucion(evoKirlia);
        	ralts.agregarEvolucion(evoGardevoir);
        	evolucionDao.save(evoKirlia);
        	evolucionDao.save(evoGardevoir);
        	pokemonDao.save(ralts);


            Pokemon shuppet = new Pokemon("Shuppet",1);
            shuppet.agregarTipo("Fantasma");
            Evolucion evoBanette = new Evolucion("Banette",37);
            evoBanette.agregarTipo("Fantasma");
            shuppet.agregarHabilidad("Insomnio");
            shuppet.agregarHabilidad("Cacheo");
        	shuppet.agregarEvolucion(evoBanette);
        	evolucionDao.save(evoBanette);
        	pokemonDao.save(shuppet);
        };
    }
}
