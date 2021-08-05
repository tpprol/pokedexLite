package pokedexLite;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import javax.persistence.*;

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
	
	public void agregarEvolucion(Evolucion evolucion) {
		if(!evoluciones.contains(evolucion))
			evoluciones.add(evolucion);
	}
	
	public List<Evolucion> getEvoluciones() {
		return evoluciones;
	}
	
	public void entrenar() {
		System.out.printf("Entrenando a %s\n",nombre);
		nivel++;
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
	
	public void evolucionar() {
		System.out.printf("Evolucionando a %s\n",nombre);
		Evolucion evolucion;
		if((evolucion = cumpleCondicionEvolucion())!=null) {
			nombre = evolucion.getNombre();
			tipos = evolucion.getTipos();
			evoluciones.remove(evolucion);
			 Pokedex.instance().sacarEvolucion(evolucion);
			System.out.printf("Se completo la evoluciono, ahora es %s\n",nombre);
		}
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
