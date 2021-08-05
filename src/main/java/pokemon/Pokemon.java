package pokemon;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import javax.persistence.*;

import pokedex.Pokedex;

@Entity
@Table(name="Pokemon")
public class Pokemon extends Evolucion {	
	@ElementCollection
	@CollectionTable(name="Habilidades")
	List<String> habilidades = new ArrayList<String>();
	
	@OneToMany
	@JoinColumn(name="PreEvolucion")
	List<Evolucion> evoluciones = new ArrayList<Evolucion>();
	
	public Pokemon() {
		
	}
	
	public Pokemon(String nombre, int nivel) {
		super(nombre, nivel);
	}
	
	public void agregarHabilidad(String habilidad) {
		if(!habilidades.contains(habilidad))
			habilidades.add(habilidad);
	}
	
	public List<String> getHabilidades() {
		return habilidades;
	}
	
	private void agregarHabilidades(List<String> habilidades){
		for(int i = 0; i<habilidades.size();i++) {
			if(!this.habilidades.contains(habilidades.get(i))){
				this.habilidades.add(habilidades.get(i));
			}
		}
	}
	
	public void agregarEvolucion(Evolucion evolucion) {
		if(!evoluciones.contains(evolucion)) {
			Pokedex.instance().agregarEvolucion(evolucion);
			evoluciones.add(evolucion);
		}
	}
	
	private void agregarEvoluciones(List<Evolucion> evoluciones){
		for(int i = 0; i<evoluciones.size();i++) {
			if(!this.evoluciones.contains(evoluciones.get(i))){
				this.evoluciones.add(evoluciones.get(i));
			}
		}
	}
	
	public List<Evolucion> getEvoluciones() {
		return evoluciones;
	}
	
	private void agregarTipos(List<String> tipos){
		for(int i = 0; i<tipos.size();i++) {
			if(!this.tipos.contains(tipos.get(i))){
				this.tipos.add(tipos.get(i));
			}
		}
	}
	
	public void entrenar(int segundos) {
		System.out.printf("Entrenando a %s\n",nombre);
		
		try {
			TimeUnit.SECONDS.sleep(segundos);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		nivel += segundos;
		System.out.printf("Termino de entrenar y paso de nivel %d a %d\n", nivel-1, nivel);
		
		Evolucion evolucion = cumpleCondicionEvolucion();
		if(evolucion!=null) {
			@SuppressWarnings("resource")
			Scanner in = new Scanner(System.in);
			System.out.printf("%s puede evolucionar. Ingrese la opcion que mas le gustaria\n",nombre);
			System.out.printf("0. No evolucionar a %s\n",nombre);
			System.out.printf("1. Evolucionar a %s\n",nombre);
			int numero = in.nextInt();
			if(numero==1)
				evolucionar();
		}
	}
	
	public Evolucion cumpleCondicionEvolucion() {
		Evolucion evolucion = evoluciones.stream().min(Comparator.comparing(Evolucion::getNivel)).orElse(null);
		
		if(evolucion!=null) 
			if(nivel >= evolucion.getNivel()) {
				return evolucion;
			} else {
				System.out.printf("Le faltan %d niveles para evolucionar a %s\n",evolucion.getNivel() - nivel, evolucion.getNombre());
			}
			
		return null;
	}
	
	public Pokemon evolucionar() {
		Evolucion evolucion = cumpleCondicionEvolucion();
		if(evolucion!= null) {
			System.out.printf("Evolucionando a %s\n",nombre);
			Pokedex.instance().sacarEvolucion(evolucion);
			evoluciones.remove(evolucion);
			
			Pokemon nuevoPokemon = new Pokemon(evolucion.getNombre(),nivel);
			nuevoPokemon.agregarHabilidades(habilidades);
			nuevoPokemon.agregarEvoluciones(evoluciones);
			nuevoPokemon.agregarTipos(evolucion.getTipos());
			Pokedex.instance().agregarEvolucion(nuevoPokemon);

			System.out.printf("Se evoluciono a %s. Nuevo pokemon registrado %s\n",nombre, nuevoPokemon.getNombre());
			Pokedex.instance().sacarEvolucion(this);
			return nuevoPokemon;
		}
		
		return null;
	}
	
	public void mostrarInformacion() {
        System.out.printf("Nombre del Pokemon: %s\n",nombre);
        System.out.printf("Nivel de %s: %d\n",nombre, nivel);
        this.mostrarTipos();
        this.mostrarHabilidades();
        this.mostrarEvoluciones();
        System.out.printf("\n");
	}
	
	public void mostrarHabilidades() {
		for(int i=0; i < habilidades.size();i++) {
        	System.out.printf("\nHabilidad de %s: %s",nombre, habilidades.get(i));
        }
		System.out.printf("\n");
	}
	
	public void mostrarEvoluciones() {
		for(int i=0; i < evoluciones.size();i++) {
        	Evolucion evolucionPokemon = evoluciones.get(i);
        	System.out.printf("\nEvolucion de %s: %s\n",nombre, evolucionPokemon.getNombre());
        	System.out.printf("Nivel necesario para la evolucion: %d\n",evolucionPokemon.getNivel());
        	evolucionPokemon.mostrarTipos();
        }
	}
}