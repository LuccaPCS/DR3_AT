package br.edu.infnet.secao1;

public class GeradorDeUsuarios {
    public static Usuario criarUsuario(String nome, int idade) {
        String email = nome.toLowerCase() + "@gmail.com";
        String senha = "senha" + idade;

        return new Usuario(
                nome,
                email,
                senha,
                idade
        );
    }
}

