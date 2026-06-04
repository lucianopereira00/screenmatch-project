package br.com.alura.screenmatch;

import br.com.alura.screenmatch.Model.DadosEpisodio;
import br.com.alura.screenmatch.Model.DadosSerie;
import br.com.alura.screenmatch.Model.DadosTemporada;
import br.com.alura.screenmatch.service.ConsumoApi;
import br.com.alura.screenmatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        var consumoApi = new ConsumoApi();
        var json = consumoApi.obterDados("http://www.omdbapi.com/?t=drive+to+survive&apikey=1ac5d52f&");
        System.out.println(json);

            //Criei a instancia, um var json (pois retorna a resposta em Json) e chamei o metodo;
            //Depois imrpimi o resultado a pesquisa;

        ConverteDados conversor = new ConverteDados();
        DadosSerie dadosSerie = conversor.obterDados(json, DadosSerie.class);
        System.out.println(dadosSerie);

            // Instanciei a classe ConverteDados e atribuí o objeto a variavel "conversor".
            // Em seguida, criei uma variável "dados" do tipo DadosSerie,
            // que recebe o resultado da conversão do JSON retornado pela API.
            // Por fim, exibo na tela os dados convertidos para o formato da classe DadosSerie.

        json = consumoApi.obterDados("https://www.omdbapi.com/?t=drive+to+survive&" +
                "season=1&episode=1&apikey=1ac5d52f&");
        DadosEpisodio dadosEp = conversor.obterDados(json, DadosEpisodio.class);
        System.out.println(dadosEp);


            //Modifiquei o json para que ele pesquise apenas um ep específico;
            //Chamei o metodo conversor;
            //Imprimi o resultado final;


        List<DadosTemporada> temporadaList = new ArrayList<>();

        for(int i = 1; i <= dadosSerie.temporadas(); i++){
            json = consumoApi.obterDados("https://www.omdbapi.com/?t=drive+to+survive&season=" + i +"&apikey=1ac5d52f&");
            DadosTemporada dadosTemp = conversor.obterDados(json, DadosTemporada.class);
            temporadaList.add(dadosTemp);
        }
        temporadaList.forEach(System.out::println);

            //Criei uma list para armazenar o objeto resultande de DadosTemporada
            //Usei o for para criar um loop que irá percorrer desde a temp 1 ate a ultima.
            //Modifiquei o Json.
            //Chamei o metodo conversor
            //Adicionei a(s) temporada(s) na list
            //Para finalizar usei o forEach que percorrerá toda a lista.

    }

    public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

}
