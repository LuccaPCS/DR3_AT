package br.edu.infnet;

public class Usuario {
    private String nome;
    private String email;
    private String senha;
    private int idade;

    public Usuario(String nome, String email, String senha, int idade) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public String apresentacao() {
        return "Olá, meu nome é " + nome + " e tenho " + idade + " anos.";
    }
}
