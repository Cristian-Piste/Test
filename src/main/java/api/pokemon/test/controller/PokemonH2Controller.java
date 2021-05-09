package api.pokemon.test.controller;

import api.pokemon.test.model.PokemonH2;
import api.pokemon.test.service.ServicePokemonH2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/H2")
public class PokemonH2Controller {

    private final ServicePokemonH2 servicePokemonH2;

    public PokemonH2Controller(ServicePokemonH2 servicePokemonH2) {
        this.servicePokemonH2 = servicePokemonH2;
    }

    @PostMapping(value = {"/D"})
    public ResponseEntity<PokemonH2> savePokemonH2(@RequestParam(value = "nickname") String name, @RequestParam(value = "species") String especie) {
        PokemonH2 pokemonH2 = new PokemonH2();

        pokemonH2.setApodo(name);
        pokemonH2.setEspecie(especie);
        pokemonH2.setSalud((int) (Math.random() * 15));
        pokemonH2.setAtaque((int) (Math.random() * 15));
        pokemonH2.setDefensa((int) (Math.random() * 15));

        if (!servicePokemonH2.guardar(pokemonH2)) {
            return new ResponseEntity<>(pokemonH2, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(pokemonH2, HttpStatus.ACCEPTED);
    }

    @GetMapping(value = {"/E/{nickname}"})
    public ResponseEntity<PokemonH2> findPokemonH2ByApodo(@PathVariable(value = "nickname") String name) {
        PokemonH2 pokemonH2 = servicePokemonH2.getPokemonByApodo(name);
        return new ResponseEntity<>(pokemonH2, HttpStatus.OK);
    }

    @GetMapping(value = {"/F/{species}"})
    public ResponseEntity<ArrayList<PokemonH2>> findPokemonH2BySpecies(@PathVariable(value = "species") String especie) {
        ArrayList<PokemonH2> pokemonsH2 = servicePokemonH2.getPokemonsByEspecie(especie);
        return new ResponseEntity<>(pokemonsH2, HttpStatus.OK);
    }
}
