package br.edu.infnet.secao3.infra;

import br.edu.infnet.secao3.domain.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioServiceTest {
    private UsuarioService usuarioService;

    @BeforeEach
    void setUp() {
        usuarioService = new UsuarioService();
    }

    @DisplayName("Cadastro: Happy path")
    @Test
    void cadastrarUsuario() {
        Usuario usuario = new Usuario(0,"Eric","eric@gmail.com");
        Usuario usuarioCadastrado = usuarioService.cadastrarUsuario(usuario);

        assertEquals("Eric", usuarioCadastrado.getNome());
        assertEquals("eric@gmail.com", usuarioCadastrado.getEmail());
        assertTrue(usuarioCadastrado.getId() > 0);
    }

    @DisplayName("Busca usuario: inexistente")
    @Test
    void buscarUsuarioPorIdErro() {
        Exception  exception = assertThrows(IllegalArgumentException.class, () -> {
            usuarioService.buscarUsuarioPorId(99);
        });
    }
}