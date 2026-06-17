package br.com.alura.screenmatch.Model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosEpisodio(@JsonAlias("Title") String titulo,
                            @JsonAlias("Episode") int numeroEpisodio,
                            @JsonAlias("Released")String dataLancamento,
                            @JsonAlias("imdbRating")String avaliacaoEp){
}
