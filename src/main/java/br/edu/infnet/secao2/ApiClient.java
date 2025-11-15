package br.edu.infnet.secao2;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiClient {
    public static void main(String[] args) throws Exception {
        buscarTitulosUsuario(1);
        criarPost();
    }

    public static void buscarTitulosUsuario(int userId) throws Exception {
        String path = "https://jsonplaceholder.typicode.com/posts?userId=" + userId;
        URL url = new URL(path);
        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
        conexao.setRequestMethod("GET");
        System.out.println("Response code: " + conexao.getResponseCode());
        System.out.println("--- --- ---");
        BufferedReader in = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
        String linha;
        while ((linha = in.readLine()) != null) {
            if(linha.trim().startsWith("\"title\"")) {
                String titulo = linha.split(":")[1].trim().replace(",","");
                System.out.println(titulo);
            }
        }
        in.close();
        System.out.println("--- --- ---");
    };

    public static void criarPost() throws Exception{
        /*Configuração da conexão*/
        String path = "https://jsonplaceholder.typicode.com/posts";
        URL url = new URL(path);
        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
        conexao.setRequestMethod("POST");
        conexao.setRequestProperty("Content-Type", "application/json");
        conexao.setDoOutput(true);
        /*Envio dos dados*/
        DataOutputStream out = new DataOutputStream(conexao.getOutputStream());
        out.writeBytes("{\"userId\": 99, \"id\": 1, \"title\": \"lorem ipsum titulo\", \"body\": \"lorem ipsum body\"}");
        out.flush();
        out.close();
        BufferedReader in = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
        String linha;
        while ((linha = in.readLine()) != null) {
            System.out.println(linha);
        }
        in.close();
    }
}
