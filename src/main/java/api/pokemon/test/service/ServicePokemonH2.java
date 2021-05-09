package api.pokemon.test.service;

import api.pokemon.test.model.PokemonH2;

import java.util.ArrayList;

public interface ServicePokemonH2 {
    Boolean guardar(PokemonH2 pokemonH2);

    PokemonH2 getPokemonByApodo(String apodo);

    ArrayList<PokemonH2> getPokemonsByEspecie(String especie);
}
