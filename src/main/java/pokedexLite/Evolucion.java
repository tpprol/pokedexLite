package pokedexLite;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="Evolucion")
@Inheritance(strategy=InheritanceType.JOINED)
public class Evolucion {
	@Id
	@Column(nullable = false, name="Nombre")
	String nombre;
	
	@Enumerated(EnumType.STRING)
	@Column(name="Tipos")
	@ElementCollection
	List<Tipo> tipos = new ArrayList<Tipo>();
	
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
	
	public List<Tipo> getTipos() {
		return tipos;
	}
	
	public void agregarTipo(Tipo tipo) {
		if(!tipos.contains(tipo))
			tipos.add(tipo);
	}
	
	public void sacarTipo(Tipo tipo) {
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
		System.out.printf("Es del tipo: %s",tipos.get(0).name());
		
		for(int i=1; i<tipos.size();i++) {
			System.out.printf("/%s",tipos.get(i).name());
		}
		
		System.out.printf("\n");
	}
}
