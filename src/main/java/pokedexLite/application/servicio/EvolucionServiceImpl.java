package pokedexLite.application.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pokedexLite.application.dao.EvolucionDao;
import pokedexLite.application.pokemon.Evolucion;

@Service
public class EvolucionServiceImpl implements EvolucionService {
	@Autowired
	private EvolucionDao evolucionDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Evolucion> listarEvoluciones() {
		return (List<Evolucion>) evolucionDao.findAll();
	}

	@Override
	@Transactional
	public void guardar(Evolucion evolucion) {
		evolucionDao.save(evolucion);
	}

	@Override
	@Transactional
	public void eliminar(Evolucion evolucion) {
		evolucionDao.delete(evolucion);
	}

	@Override
	@Transactional(readOnly = true)
	public Evolucion encontrarEvolucion(String evolucion) {
		return evolucionDao.findById(evolucion).orElse(null);
	}

	@Override
	public void eliminarPorNombre(String nombre) {
		Evolucion evolucion = this.encontrarEvolucion(nombre);
		if(evolucion != null)
			this.eliminar(evolucion);
	}
}
