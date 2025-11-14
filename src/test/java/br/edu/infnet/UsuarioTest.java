package br.edu.infnet;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {

    @DisplayName("Testa método getNome()")
    @Test
    void testaGetNome() {
        Usuario u1 = GeradorDeUsuarios.criarUsuario("Rafael", 33);
        assertEquals("Rafael", u1.getNome());
    }

    @DisplayName("Testa método apresentacao()")
    @Test
    void testaApresentacao() {
        Usuario u2 = GeradorDeUsuarios.criarUsuario("Camila", 40);
        assertEquals("Olá, meu nome é Camila e tenho 40 anos.", u2.apresentacao());
    }
}