package pokedexLite;

import java.util.ArrayList;
import java.util.List;

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
