package br.com.alura.screenmatch;

import br.com.alura.screenmatch.Model.DadosSerie;
import br.com.alura.screenmatch.service.ConsumoApi;
import br.com.alura.screenmatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
        DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
        System.out.println(dados);

        // Instanciei a classe ConverteDados e atribuí o objeto a variavel "conversor".
        // Em seguida, criei uma variável "dados" do tipo DadosSerie,
        // que recebe o resultado da conversão do JSON retornado pela API.
        // Por fim, exibo na tela os dados convertidos para o formato da classe DadosSerie.

    }

    public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

}
