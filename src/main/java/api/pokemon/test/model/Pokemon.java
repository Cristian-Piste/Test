package api.pokemon.test.model;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Pokemon {
    private Integer numero;
    private String nombre;
    private ArrayList<String> tipos;
}
