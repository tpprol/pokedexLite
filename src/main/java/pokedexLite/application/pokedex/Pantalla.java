package pokedexLite.application.pokedex;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

import pokedexLite.application.pokemon.Evolucion;
import pokedexLite.application.pokemon.Pokemon;

public class Pantalla {
	static Scanner leer = new Scanner(System.in);
	static EntityManager entityManager = PerThreadEntityManagers.getEntityManager();
	static EntityTransaction transaction = entityManager.getTransaction();
	
	public static void menuPrincipal() {
		System.out.printf("\nBIENVENIDO AL POKEDEX\n");
		int selector = -1;
    	while(selector!=0) {
        	transaction.begin();
    		System.out.printf("Escriba el numero de la opcion que le gustaria hacer\n");
    		System.out.printf("\t1. Buscar Pokemon\n");
    		System.out.printf("\t2. Atrapar Pokemon\n");
    		System.out.printf("\t3. Listar Pokemones de un tipo\n");
    		System.out.printf("\t4. Listar Los Pokemones de la Base De Datos\n");
    		System.out.printf("\t5. Numero de Pokemones en la base de datos\n");
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
    			case 5:
    				System.out.printf("Hay registrados %d Pokemones\n",Pokedex.instance().numeroDePokemones());
    				break;
    		}
			transaction.commit();
    	}
    	
    	System.out.printf("\nGRACIAS POR USAR POKEDEX\n");
	}
	
	public static void buscarInformacionPokemon() {
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
				System.out.printf("\t8. Agregar un tipo a %s\n", pokemon.getNombre());
				System.out.printf("\t9. Agregar una evolucion a %s\n", pokemon.getNombre());
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
    					pokemon = entrenarPokemon(pokemon);
    					break;
    				case 6:
    					pokemon = evolucionarPokemon(pokemon);
    					break;
    				case 7:
    					aprenderHabilidad(pokemon);
    					break;
    				case 8:
    					nuevoTipo(pokemon);
    					break;
    				case 9:
    					agregarEvolucion(pokemon);
    					break;
    			}
    		}
		}
    }
    
	public static Pokemon entrenarPokemon(Pokemon pokemon) {
    	System.out.printf("Por cuanto tiempo le gustaria entrenar a %s? Ingreselo en segundos\n",pokemon.getNombre());
    	int segundos = leer.nextInt();
        leer.nextLine();
        
    	if(segundos>0)
    		pokemon = pokemon.entrenar(segundos);
    	
    	return pokemon;
    }
    
	public static Pokemon evolucionarPokemon(Pokemon pokemon) {
    	Pokemon nuevoPokemon = pokemon.evolucionar();
    	if(nuevoPokemon!=null)	
    		return nuevoPokemon;
    	else
    		return pokemon;
    }
    
    public static void aprenderHabilidad(Pokemon pokemon) {
    	System.out.printf("Ingrese el nombre de la habilidad de %s\n", pokemon.getNombre());
    	String nuevaHabilidad = leer.nextLine();
    	
    	pokemon.agregarHabilidad(nuevaHabilidad);
    	System.out.printf("Se agrego la habilidad %s a %s\n", nuevaHabilidad, pokemon.getNombre());
    }
    
    public static void nuevoTipo(Evolucion evolucion) {
    	System.out.printf("Ingrese un tipo para %s\n", evolucion.getNombre());
    	String tipo = leer.nextLine();
    	evolucion.agregarTipo(tipo);
    	System.out.printf("Se agrego el tipo %s a %s\n", tipo, evolucion.getNombre());
    }
    
    public static void agregarEvolucion(Pokemon pokemon) {
    	System.out.printf("Ingrese la evolucion de %s\n", pokemon.getNombre());
    	String nombreEvolucion = leer.nextLine();
    	
        System.out.printf("Ingrese el nivel necesario para la evolucion %s de %s\n", nombreEvolucion, pokemon.getNombre());
        int nivelEvolucion = leer.nextInt();
        leer.nextLine();
        Evolucion evolucion = new Evolucion(nombreEvolucion, nivelEvolucion);
    	
        int decision = 1;
    	while(decision != 0) {
    		nuevoTipo(evolucion);
    		System.out.printf("Ingrese 0 si quiere continuar o 1 si quiere agregar un nuevo tipo\n");
    		decision = leer.nextInt();
            leer.nextLine();
    	}
        
        pokemon.agregarEvolucion(evolucion);
    }
    
    public static void atraparPokemon(){
    	System.out.printf("Ingrese el nombre del nuevo Pokemon\n");
    	String nombrePokemon = leer.nextLine();
    	System.out.printf("Ingrese el nivel con el que se atrapo a %s\n",nombrePokemon);
    	int nivelPokemon = leer.nextInt();
        leer.nextLine();
    	Pokemon pokemon = new Pokemon(nombrePokemon, nivelPokemon);
    	
    	int decision = 1;
    	while(decision != 0) {
    		nuevoTipo(pokemon);
    		System.out.printf("Ingrese 0 si quiere continuar o 1 si quiere agregar un nuevo tipo\n");
    		decision= leer.nextInt();
            leer.nextLine();
    	}
    	
    	decision = 1;
    	while(decision != 0) {
    		aprenderHabilidad(pokemon);
    		System.out.printf("Ingrese 0 si quiere continuar o 1 si quiere agregar una nueva habilidad\n");
    		decision= leer.nextInt();
            leer.nextLine();
    	}
		
    	decision = 1;
    	while(decision != 0) {
    		agregarEvolucion(pokemon);
    		System.out.printf("Ingrese 0 si quiere continuar o 1 si quiere agregar una nueva evolucion\n");
    		decision= leer.nextInt();
            leer.nextLine();
    	}
    	
    	Pokedex.instance().agregarEvolucion(pokemon);
    }
    
    public static void pokemonSegunTipo() {
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
    
    public static Pokemon buscarPokemon() {
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