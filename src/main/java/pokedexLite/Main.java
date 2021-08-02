package pokedexLite;

import java.util.List;

public class Main {
    public static void main(String[] args) {        
        List<Pokemon> pokemones = Pokedex.instance().gelAllPokemon();
        for(int i=0;i<pokemones.size();i++) {
            System.out.printf("\nPokemon Numero %d\n",i+1);
            Pokemon pokemon = pokemones.get(i);
            pokemon.mostrarInformacion();
        }
    }
}