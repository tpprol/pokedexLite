package pokedexLite.application.pokemon;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name="Evolucion")
@Inheritance(strategy=InheritanceType.JOINED)
public class Evolucion{
	@Id
	@Column(nullable = false, name="NombreEvo")
	String nombre;
	
	@Column(name="Tipos")
	@ElementCollection
	List<String> tipos = new ArrayList<String>();
	
	@Column(name="Nivel")
	int nivel;

	public Evolucion() {
		
	}
	
	public Evolucion(String nombre, int nivel) {
		this.nombre = nombre;
		this.nivel = nivel;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public List<String> getTipos() {
		return tipos;
	}
	
	public void agregarTipo(String tipo) {
		if(!tipos.contains(tipo))
			tipos.add(tipo);
	}
	
	public void agregarTipos(List<String> tipos){
		for(int i = 0; i<tipos.size();i++) {
			if(!this.tipos.contains(tipos.get(i))){
				this.tipos.add(tipos.get(i));
			}
		}
	}
	
	public void sacarTipo(String tipo) {
		if(tipos.contains(tipo))
			tipos.remove(tipo);
	}
	
	public int getNivel() {
		return nivel;
	}
	
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	
	public void mostrarTipos() {
		System.out.printf("Es de tipo: %s",tipos.get(0));
		
		for(int i=1; i<tipos.size();i++) {
			System.out.printf("/%s",tipos.get(i));
		}
		
		System.out.printf("\n");
	}
}
