package api.pokemon.test.dao;

import api.pokemon.test.model.PokemonH2;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface PokemonH2DAO extends JpaRepository<PokemonH2, String> {
    ArrayList<PokemonH2> getAllByEspecie(String especie);
}
