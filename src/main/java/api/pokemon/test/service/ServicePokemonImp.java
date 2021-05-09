package api.pokemon.test.service;

import api.pokemon.test.model.Pokemon;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Service
public class ServicePokemonImp implements ServicePokemon {

    @Override
    public ResponseEntity<String> getResponseEntity(String url) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("user-agent", "Application");
        HttpEntity<String> entity = new HttpEntity<>(headers);
        return restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
    }

    @Override
    public void extractPokemonData(ArrayList<Pokemon> pokemonList, JSONObject pokemonJSON) {
        Pokemon pokemon;
        ArrayList<String> tipos;
        pokemon = new Pokemon();
        pokemon.setNombre(pokemonJSON.getString("name"));
        pokemon.setNumero(pokemonJSON.getInt("id"));
        JSONArray types = new JSONArray(pokemonJSON.getJSONArray("types"));
        tipos = new ArrayList<>();

        for (int j = 0; j < types.length(); j++) {
            tipos.add(types.getJSONObject(j).getJSONObject("type").getString("name"));
        }
        pokemon.setTipos(tipos);
        pokemonList.add(pokemon);
    }
}
