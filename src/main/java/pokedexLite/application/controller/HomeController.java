package pokedexLite.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pokedexLite.application.pokemon.Evolucion;
import pokedexLite.application.pokemon.Pokemon;
import pokedexLite.application.servicio.EvolucionService;
import pokedexLite.application.servicio.PokemonService;

@Controller
public class HomeController {
	@Autowired
	private PokemonService pokemonService;
	
	@Autowired
	private EvolucionService evolucionService;
	
	
    @GetMapping("/")
    public String homePage(@RequestParam(value = "nombre", required = false) String nombre, Model model) {
    	try{
    		model.addAttribute("pokemones", pokemonService.listarPokemonesPorNombre(nombre));
    	} catch(Exception e){
    		model.addAttribute("pokemones", pokemonService.listarPokemones());
    	}
        
    	model.addAttribute("pokemones",pokemonService.listarPokemones());
    	model.addAttribute("tipos", pokemonService.listarTipos());
        return "home";
    }
    
    @GetMapping("/prueba")
    public String probando(Model model) {
    	return "prueba";
    }
    
    @GetMapping("/{tipo}")
    public String homeTipos(@PathVariable String tipo, Model model){
    	model.addAttribute("pokemones", pokemonService.listarPokemonesPorTipo(tipo));
    	model.addAttribute("tipos", pokemonService.listarTipos());
        return "home";
    }
    
    @GetMapping("/agregarPokemon")
    public String atraparPokemon(Pokemon pokemon) {
        return "editarPokemon";
    }
    
    @PostMapping("/guardar")
    public String agregarPokemon(Pokemon pokemon) {
    	
    	pokemonService.guardar(pokemon);
    	return "redirect:/pokemon/" + pokemon.getNombre();
    }
    
    @GetMapping("/pokemon/{idPokemon}")
    public String verPokemon(@PathVariable String idPokemon, Model model) {
    	Pokemon pokemonBuscado = pokemonService.encontrarPokemon(idPokemon);
    	model.addAttribute("pokemon",pokemonBuscado);
    	model.addAttribute("evolucion",new Evolucion());
    	return "verPokemon";
    }
    
    @PostMapping("/pokemon/{idPokemon}/nuevaEvolucion")
    public String nuevaEvolucion(@PathVariable String idPokemon, @ModelAttribute Evolucion evolucion, Model model) {
        Pokemon pokemon = pokemonService.encontrarPokemon(idPokemon);
        model.addAttribute("evolucion", evolucion);
      	
        evolucionService.guardar(evolucion);
        
        pokemon.agregarEvolucion(evolucion);
        pokemonService.guardar(pokemon);
        
        return "redirect:/pokemon/"+idPokemon;
      }
    
    @PostMapping("/pokemon/{idPokemon}/nuevaHabilidad")
    public String nuevaHabilidad(@PathVariable String idPokemon, @RequestParam(value = "habilidad", required = true) String habilidad, Model model) {
      Pokemon pokemon = pokemonService.encontrarPokemon(idPokemon);
      model.addAttribute("habilidad", habilidad);

      pokemon.agregarHabilidad(habilidad);
      pokemonService.guardar(pokemon);
      
      return "redirect:/pokemon/"+idPokemon;
    }
    
    @PostMapping("/pokemon/{idPokemon}/nuevoTipo")
    public String nuevoTipo(@PathVariable String idPokemon, @RequestParam(value = "tipo", required = true) String tipo, Model model) {
      Pokemon pokemon = pokemonService.encontrarPokemon(idPokemon);
      model.addAttribute("tipo", tipo);

      pokemon.agregarTipo(tipo);
      pokemonService.guardar(pokemon);
      
      return "redirect:/pokemon/"+idPokemon;
    }
    
    @PostMapping("/pokemon/{idPokemon}/entrenar")
    public String entrenando(@PathVariable String idPokemon, @RequestParam(value = "tiempo", required = true) int tiempo, Model model) {
      Pokemon pokemon = pokemonService.encontrarPokemon(idPokemon);
      model.addAttribute("tiempo", tiempo);

      pokemon.entrenar(tiempo);
      pokemonService.guardar(pokemon);
      
      return "redirect:/pokemon/"+idPokemon;
    }
}
