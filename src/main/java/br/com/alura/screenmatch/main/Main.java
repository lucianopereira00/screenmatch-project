package br.com.alura.screenmatch.main;

import br.com.alura.screenmatch.Model.DadosEpisodio;
import br.com.alura.screenmatch.Model.DadosSerie;
import br.com.alura.screenmatch.Model.DadosTemporada;
import br.com.alura.screenmatch.service.ConsumoApi;
import br.com.alura.screenmatch.service.ConverteDados;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
        private final String URL = "https://www.omdbapi.com/?t=";
        private final String API_KEY = "&apikey=1ac5d52f&";
        private Scanner scanner = new Scanner(System.in);
        private ConsumoApi consumoApi = new ConsumoApi();
        private ConverteDados converteDados = new ConverteDados();

        public void exibirMenu(){
            System.out.println("Digite o nome de uma serie para assistir:");
            var pesquisa = scanner.nextLine();
            var json = consumoApi.obterDados(URL + pesquisa.replace(" ", "+")+ API_KEY);
            DadosSerie dados = converteDados.obterDados(json, DadosSerie.class);
            System.out.println(dados);

            List<DadosTemporada> temporadaList = new ArrayList<>();

            for(int i = 1; i <= dados.temporadas(); i++){
                json = consumoApi.obterDados(URL+pesquisa.replace
                        (" ","+")+"&season=" + i +API_KEY);
                DadosTemporada dadosTemp = converteDados.obterDados(json, DadosTemporada.class);
                temporadaList.add(dadosTemp);
            }
            temporadaList.forEach(System.out::println);


//            for(int i = 0; i < dados.temporadas(); i++){
//                List<DadosEpisodio>  episodioList = temporadaList.get(i).episodios();
//                for(int j  = 0; j < episodioList.size(); j++){
//                    System.out.println(episodioList.get(j).titulo());
//                }
//            }

            temporadaList.forEach(t -> t.episodios().forEach(e -> System.out.println(e.titulo())) );
        }
}
