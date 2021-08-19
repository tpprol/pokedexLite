package application;

import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;

import pokedex.Pokedex;
import pokemon.Pokemon;

@Controller
public class HomeController implements WithGlobalEntityManager {   
    @GetMapping("/")
    public String homePage(@RequestParam(value = "nombre", required = false) String nombre, Model model) {
    	try{
    		model.addAttribute("pokemones", Pokedex.instance().gelAllPokemon().stream().filter(pok->pok.getNombre().contains(nombre)).collect(Collectors.toList()));
    	} catch(NullPointerException e){
    		model.addAttribute("pokemones", Pokedex.instance().gelAllPokemon());
    	}
    	model.addAttribute("tipos", Pokedex.instance().getTipos());
        return "home";
    }
    
    @GetMapping("/{tipo}")
    public String homeTipos(@PathVariable String tipo, Model model){
    	model.addAttribute("pokemones", Pokedex.instance().gelPokemonesDeTipo(tipo));
    	model.addAttribute("tipos", Pokedex.instance().getTipos());
        return "home";
    }
    
    @GetMapping("/agregarPokemon")
    public String atraparPokemon(Pokemon pokemon) {
        return "agregar";
    }
    
    @PostMapping("/guardar")
    public String guardar(Pokemon pokemon) {
    	entityManager().getTransaction().begin();
    	Pokedex.instance().agregarEvolucion(pokemon);
    	entityManager().getTransaction().commit();
    	return "redirect:/";
    }
    
    @GetMapping("/pokemon/{idPokemon}")
    public String verPokemon(@PathVariable String idPokemon, Model model) {
    	Pokemon pokemonBuscado = Pokedex.instance().getPokemon(idPokemon);
    	model.addAttribute("pokemon",pokemonBuscado);
    	return "verPokemon";
    }
}
