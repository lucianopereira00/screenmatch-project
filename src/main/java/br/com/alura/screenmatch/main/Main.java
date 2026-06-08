package br.com.alura.screenmatch.main;

import br.com.alura.screenmatch.service.ConsumoApi;
import ch.qos.logback.core.net.ssl.ConfigurableSSLServerSocketFactory;

import java.util.Scanner;

public class main {
        private final String URL = "https://www.omdbapi.com/?t=";
        private final String API_KEY = "&apikey=1ac5d52f&";
        private Scanner scanner = new Scanner(System.in);
        private ConsumoApi consumoApi = new ConsumoApi();

        public void exibirMenu(){
            System.out.println("Digite o nome de uma serie para assistir:");
            var pesquisa = scanner.nextLine();
            var json = consumoApi.obterDados(URL + pesquisa.replace(" ", "+")+ API_KEY);
 
        }
}
