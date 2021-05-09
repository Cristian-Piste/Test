package api.pokemon.test.controller;

import api.pokemon.test.model.Pokemon;
import api.pokemon.test.service.ServicePokemon;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api")
public class PokemonController {
    private final ServicePokemon servicePokemon;

    private static final String URL_API = "https://pokeapi.co/api/v2/";

    public PokemonController(ServicePokemon servicePokemon) {
        this.servicePokemon = servicePokemon;
    }

    @GetMapping(value = {"/A"})
    public ResponseEntity<ArrayList<Pokemon>> getPokemons() {
        ArrayList<Pokemon> pokemonList = new ArrayList<>();
        String uri = "pokemon?limit=721";
        String datos = servicePokemon.getResponseEntity(URL_API + uri).getBody();
        JSONArray resultados = new JSONObject(datos).getJSONArray("results");
        JSONObject pokemonJSON;

        for (int i = 0; i < resultados.length(); i++) {
            pokemonJSON = new JSONObject(servicePokemon.getResponseEntity(resultados.getJSONObject(i).getString("url")).getBody());
            servicePokemon.extractPokemonData(pokemonList, pokemonJSON);
        }

        return new ResponseEntity<>(pokemonList, HttpStatus.OK);
    }

    @GetMapping(value = {"/B"})
    public ResponseEntity<ArrayList<Pokemon>> rangePokemons(@RequestParam(value = "from") Integer a, @RequestParam(value = "to") Integer b) {
        ArrayList<Pokemon> pokemonList = new ArrayList<>();

        for (int i = a; i <= b; i++) {
            JSONObject pokemonJSON = new JSONObject(servicePokemon.getResponseEntity(URL_API + "pokemon/" + i).getBody());
            servicePokemon.extractPokemonData(pokemonList, pokemonJSON);
        }

        return new ResponseEntity<>(pokemonList, HttpStatus.OK);
    }

    @GetMapping(value = {"/C/{filter}"})
    public ResponseEntity<Pokemon> searchPokemon(@PathVariable(value = "filter") String value) {
        Pokemon pokemon = new Pokemon();
        ArrayList<String> tipos = new ArrayList<>();
        String uri = "pokemon/" + value;

        JSONObject pokemonJSON = new JSONObject(servicePokemon.getResponseEntity(URL_API + uri).getBody());

        pokemon.setNombre(pokemonJSON.getString("name"));
        pokemon.setNumero(pokemonJSON.getInt("id"));
        JSONArray types = pokemonJSON.getJSONArray("types");

        for (int i = 0; i < types.length(); i++) {
            tipos.add(types.getJSONObject(i).getJSONObject("type").getString("name"));
        }
        pokemon.setTipos(tipos);

        return new ResponseEntity<>(pokemon, HttpStatus.OK);
    }

}
