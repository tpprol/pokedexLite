package pokedexLite;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

public class Main {
	static Scanner leer = new Scanner(System.in);
	
    static public void main(String[] args) {   
    	EntityManager entityManager = PerThreadEntityManagers.getEntityManager();
    	EntityTransaction transaction = entityManager.getTransaction();
    	transaction.begin();
    	System.out.printf("\nBIENVENIDO AL POKEDEX\n");		
    	
    	int selector = -1;
    	while(selector!=0) {
    		System.out.printf("Escriba el numero de la opcion que le gustaria hacer\n");
    		System.out.printf("\t1. Buscar Pokemon\n");
    		System.out.printf("\t2. Atrapar Pokemon\n");
    		System.out.printf("\t3. Listar Pokemones de un tipo\n");
    		System.out.printf("\t4. Listar Los Pokemones de la Base De Datos\n");
    		System.out.printf("Si quiere salir del menu principal solo ingrese 0\n");
    		selector = Integer.parseInt(leer.nextLine()); 
    		switch(selector){
    			case 1:
    				buscarInformacionPokemon();
    				break;
    			case 2:
    				atraparPokemon();
    				break;
    			case 3:
    				pokemonSegunTipo();
    				break;
    			case 4:
    				Pokedex.instance().mostrarTodosLosPokemones();
    				break;
    		}
    	}
    	
    	System.out.printf("\nGRACIAS POR USAR POKEDEX\n");
    	transaction.commit();
    }
    
    static public void buscarInformacionPokemon() {
		Pokemon pokemon = buscarPokemon();
		if(pokemon!=null) {
			int selector = -1;
			while(selector!=0) {
				System.out.printf("\nEscriba el numero de la opcion que le gustaria hacer\n");
				System.out.printf("\t1. Mostrar informacion completa de %s\n", pokemon.getNombre());
				System.out.printf("\t2. Listar las evoluciones de %s\n", pokemon.getNombre());
				System.out.printf("\t3. Listar las habilidades de %s\n", pokemon.getNombre());
				System.out.printf("\t4. Mostrar el o los tipos de %s\n", pokemon.getNombre());
				System.out.printf("\t5. Entrenar a %s\n", pokemon.getNombre());
				System.out.printf("\t6. Evolucionar a %s\n", pokemon.getNombre());
				System.out.printf("\t7. Que %s aprenda una nueva habilidad\n", pokemon.getNombre());
				System.out.printf("Si quiere volver atras solo ingrese 0\n");
				selector = Integer.parseInt(leer.nextLine()); 
				switch(selector){
    				case 1:
    					pokemon.mostrarInformacion();
    					break;
    				case 2:
    					pokemon.mostrarEvoluciones();
    					break;
    				case 3:
    					pokemon.mostrarHabilidades();
    					break;
    				case 4:
    					pokemon.mostrarTipos();
    					break;
    				case 5:
    					entrenarPokemon(pokemon);
    					break;
    				case 6:
    					evolucionarPokemon(pokemon);
    					break;
    				case 7:
    					aprenderHabilidad(pokemon);
    					break;
    			}
    		}
		}
    }
    
    static public void entrenarPokemon(Pokemon pokemon) {
    	if(pokemon!=null)
    		pokemon.entrenar();
    }
    
    static public void evolucionarPokemon(Pokemon pokemon) {
    	if(pokemon!=null)
    		pokemon.evolucionar();
    }
    
    static public void aprenderHabilidad(Pokemon pokemon) {
    	System.out.printf("Ingrese el nombre de la habilidad o \"Listo\" si busca cancelar la operacion\n");
    	String nuevaHabilidad = leer.nextLine();
    	if(!nuevaHabilidad.equals("Listo")) {
    		pokemon.agregarHabilidad(nuevaHabilidad);
    		System.out.printf("Se agrego la habilidad %s a %s\n", nuevaHabilidad, pokemon.getNombre());
		}
    }
    
    static public void atraparPokemon(){/*
    	System.out.printf("Ingrese el nombre del nuevo Pokemon\n");
    	String nombrePokemon = leer.nextLine();
    	System.out.printf("Ingrese el nivel con el que se atrapo a %s\n",nombrePokemon);
    	int nivelPokemon = leer.nextInt();
    	Pokemon pokemon = new Pokemon(nombrePokemon, nivelPokemon);
    	
    	System.out.printf("Ingrese el tipo o los tipos de %s o si quiere seguir \"Listo\"\n", nombrePokemon);
    	String leyendo = leer.nextLine();
    	while(leyendo.equalsIgnoreCase("Listo")) {
    		Tipo tipo = tipo.valueOf(leyendo);
    	}
    	
    	
    	Pokedex.instance().agregarPokemon(pokemon);*/
    }
    
    static public void pokemonSegunTipo() {
    	System.out.printf("Ingrese el tipo de Pokemon que se busca listar\n");
    	String nombreTipo = leer.nextLine();
    	while(!nombreTipo.equals("Listo")) {
    		List<Pokemon> pokemones = Pokedex.instance().gelPokemonesDeTipo(nombreTipo);
			if(pokemones.isEmpty()) {
	    		System.out.printf("No hay pokemon alguno con ese tipo\n");
	    		System.out.printf("Vuelva a intentarlo o ingrese \"Listo\"\n");
	    		nombreTipo = leer.nextLine();
	        } else {
	        	Pokedex.instance().mostrarPokemones(pokemones);
	        	nombreTipo="Stop";
	        }
		}
    }
    
    static public Pokemon buscarPokemon() {
		System.out.printf("Ingrese el nombre del Pokemon\n");
		String nombrePokemon = leer.nextLine();
		while(!nombrePokemon.equals("Listo")) {
			Pokemon pokemon = Pokedex.instance().getPokemon(nombrePokemon);
			if(pokemon==null) {
	    		System.out.printf("El nombre del pokemon no se encuentra en la base de datos\n");
	    		System.out.printf("Vuelva a intentarlo o ingrese \"Listo\"\n");
				nombrePokemon = leer.nextLine();
	        } else {
	        	return pokemon;
	        }
		}
		return null;
    }
}