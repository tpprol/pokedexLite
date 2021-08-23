package pokedexLite.application.servicio;

import java.util.List;

import pokedexLite.application.pokemon.Evolucion;


public interface EvolucionService {
	public List<Evolucion> listarEvoluciones();
	
	public void guardar(Evolucion evolucion);
	
	public void eliminar(Evolucion evolucion);
	
	public Evolucion encontrarEvolucion(String string);
	
	public void eliminarPorNombre(String nombre);
}
