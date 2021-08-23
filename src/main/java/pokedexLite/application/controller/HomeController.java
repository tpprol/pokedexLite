package pokedexLite.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import pokedexLite.application.servicio.PokemonService;

@Controller
public class HomeController {
	@Autowired
	private PokemonService pokemonService;	
	
    @GetMapping("/")
    public String homePage(@RequestParam(value = "nombre", required = false) String nombre, Model model) {
	    	try{
	    		model.addAttribute("pokemones", pokemonService.listarPokemonesPorNombre(nombre));
	    	} catch(Exception e){
	    		model.addAttribute("pokemones", pokemonService.listarPokemones());
	    	}
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
}