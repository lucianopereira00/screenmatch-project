package br.com.alura.screenmatch.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoApi {
    public String obterDados(String endereco) {
        HttpClient client = HttpClient.newHttpClient(); //cria um novo cliente
        HttpRequest request = HttpRequest.newBuilder() //faz a requisição
                .uri(URI.create(endereco)) //esse "endereco" e a API q sera definida no main
                .build();
        HttpResponse<String> response;
        try{ //tenta procurar uma resposta
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) { //se nao achar uma resposta valida, roda esse bloco
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String json =  response.body(); //Foi criada a string Json para armazenar a resposta da api caso dê tudoc certo
        return json;
    }
}
