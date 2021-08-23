package pokemonServiceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;

import pokedexLite.application.Application;
import pokedexLite.application.dao.PokemonDao;
import pokedexLite.application.pokemon.Pokemon;
import pokedexLite.application.servicio.PokemonService;

@SpringBootTest
@ContextConfiguration(classes = Application.class)
public class PokemonServiceTest {
	
	@Autowired                                    
    private PokemonService pokeService;
	
	@MockBean
	private PokemonDao pokeDao;
	
	@Test
	public void pokemonesFind() {
		when(pokeDao.findAll()).thenReturn((Iterable<Pokemon>) Arrays.asList(new Pokemon("Charmander",1), new Pokemon("",2)));

		assertEquals(2,pokeService.listarPokemones().size());
	}
	
	@Test
	public void dataFind() {
		Pokemon poke = new Pokemon("Charmander",1);
		when(pokeDao.findById(any())).thenReturn(Optional.of(poke));

		assertEquals(poke,pokeService.encontrarPokemon("Charmander"));
	}

}