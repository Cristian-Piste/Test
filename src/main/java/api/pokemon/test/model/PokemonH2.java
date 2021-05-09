package api.pokemon.test.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "POKEMON")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PokemonH2 implements Serializable {

    @Id
    @Column
    private String apodo;
    @Column
    private String especie;
    @Column
    private Integer ataque;
    @Column
    private Integer defensa;
    @Column
    private Integer salud;
}

