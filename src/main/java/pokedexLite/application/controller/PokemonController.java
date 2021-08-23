package pokedexLite.application.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pokedexLite.application.pokemon.Evolucion;
import pokedexLite.application.pokemon.Pokemon;
import pokedexLite.application.servicio.EvolucionService;
import pokedexLite.application.servicio.PokemonService;

@Controller
public class PokemonController {
	@Autowired
	private PokemonService pokemonService;
	
	@Autowired
	private EvolucionService evolucionService;
    
	//Agregar prokemon
    @GetMapping("/agregarPokemon")
    public String atraparPokemon(Pokemon pokemon) {
        return "agregarPokemon";
    }

    @PostMapping("/nuevoPokemon")
    public String agregarPokemon(@ModelAttribute Pokemon pokemon,
    		Model model) {
    	model.addAttribute("pokemon", pokemon);
    	pokemonService.guardar(pokemon);
    	
    	return "redirect:/pokemon/" + pokemon.getNombre();
    }
    
    //Eliminar Pokemon
    @GetMapping("/eliminarPokemon/{idPokemon}")
    public String eliminarPokemon(@PathVariable String idPokemon) {
    	Pokemon pokemon = pokemonService.encontrarPokemon(idPokemon);
    	List<String> evoluciones = pokemon.getEvoluciones().stream().map(e -> e.getNombre()).collect(Collectors.toList());
    	pokemonService.eliminar(pokemon);
    	evoluciones.forEach(evolucionService::eliminarPorNombre);
        return "redirect:/";
    }
    
    //Ver Pokemon
    @GetMapping("/pokemon/{idPokemon}")
    public String verPokemon(@PathVariable String idPokemon, Model model) {
    	Pokemon pokemonBuscado = pokemonService.encontrarPokemon(idPokemon);
    	model.addAttribute("pokemon",pokemonBuscado);
    	model.addAttribute("evolucion",new Evolucion());
    	return "verPokemon";
    }
    
    
    //Nueva evolucion
    @PostMapping("/pokemon/{idPokemon}/nuevaEvolucion")
    public String nuevaEvolucion(@PathVariable String idPokemon, @RequestParam(value = "tipo", required = true) String tipo,
    		@ModelAttribute Evolucion evolucion, Model model) {
    	
        Pokemon pokemon = pokemonService.encontrarPokemon(idPokemon);
        model.addAttribute("evolucion", evolucion);
        evolucion.agregarTipo(tipo);
        evolucionService.guardar(evolucion);
        
        pokemon.agregarEvolucion(evolucion);
        pokemonService.guardar(pokemon);
        
        return "redirect:/pokemon/"+idPokemon;
    }
    
    //Nueva Habilidad
    @PostMapping("/pokemon/{idPokemon}/nuevaHabilidad")
    public String nuevaHabilidad(@PathVariable String idPokemon, @RequestParam(value = "habilidad", required = true) String habilidad, Model model) {
      Pokemon pokemon = pokemonService.encontrarPokemon(idPokemon);
      model.addAttribute("habilidad", habilidad);

      pokemon.agregarHabilidad(habilidad);
      pokemonService.guardar(pokemon);
      
      return "redirect:/pokemon/"+idPokemon;
    }
    
    //Nuevo tipo
    @PostMapping("/pokemon/{idPokemon}/nuevoTipo")
    public String nuevoTipo(@PathVariable String idPokemon, @RequestParam(value = "tipo", required = true) String tipo, Model model) {
      Pokemon pokemon = pokemonService.encontrarPokemon(idPokemon);
      model.addAttribute("tipo", tipo);

      pokemon.agregarTipo(tipo);
      pokemonService.guardar(pokemon);
      
      return "redirect:/pokemon/"+idPokemon;
    }
    
    //Entrenar
    @PostMapping("/pokemon/{idPokemon}/entrenar")
    public String entrenando(@PathVariable String idPokemon, @RequestParam(value = "tiempo", required = true) int tiempo, Model model) {
      Pokemon pokemon = pokemonService.encontrarPokemon(idPokemon);
      model.addAttribute("tiempo", tiempo);

      pokemon.subirNivel(tiempo);
      pokemonService.guardar(pokemon);
      
      return "redirect:/pokemon/"+idPokemon;
    }
}
