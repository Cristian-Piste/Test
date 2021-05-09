package api.pokemon.test.service;

import api.pokemon.test.model.Pokemon;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

public interface ServicePokemon {
    ResponseEntity<String> getResponseEntity(String url);

    void extractPokemonData(ArrayList<Pokemon> pokemonList, JSONObject pokemonJSON);
}
