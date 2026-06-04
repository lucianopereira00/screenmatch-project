package br.com.alura.screenmatch.Model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosEpisodio(@JsonAlias("Title") String titulo,
                            @JsonAlias("Season")  int season,
                            @JsonAlias("Episode") int numeroEpisodio,
                            @JsonAlias("Runtime") String tempoDuracao,
                            @JsonAlias("Released")String dataLancamento,
                            @JsonAlias("Genre") String genero){
}
