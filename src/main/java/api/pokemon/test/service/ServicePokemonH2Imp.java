package api.pokemon.test.service;

import api.pokemon.test.dao.PokemonH2DAO;
import api.pokemon.test.model.PokemonH2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
public class ServicePokemonH2Imp implements ServicePokemonH2 {
    private final PokemonH2DAO pokemonH2DAO;

    public ServicePokemonH2Imp(PokemonH2DAO pokemonH2DAO) {
        this.pokemonH2DAO = pokemonH2DAO;
    }

    @Override
    @Transactional
    public Boolean guardar(PokemonH2 pokemonH2) {
        if (apodoExist(pokemonH2.getApodo())) {
            pokemonH2DAO.save(pokemonH2);
            return true;
        }
        return false;
    }

    @Override
    @Transactional(readOnly = true)
    public PokemonH2 getPokemonByApodo(String apodo) {
        return pokemonH2DAO.getById(apodo);
    }

    @Override
    @Transactional(readOnly = true)
    public ArrayList<PokemonH2> getPokemonsByEspecie(String especie) {
        return pokemonH2DAO.getAllByEspecie(especie);
    }

    @Transactional(readOnly = true)
    public Boolean apodoExist(String apodo) {
        return (!pokemonH2DAO.findById(apodo).isPresent());
    }


}
