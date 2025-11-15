package br.edu.infnet.secao3.infra;

import br.edu.infnet.secao3.domain.Usuario;

import java.util.Optional;

public class UsuarioService {
    private static UsuarioRepository usuarioRepository = new UsuarioRepository();

    public Optional<Usuario> buscarUsuarioPorId(long id) {
        if (id <= 0 || id > usuarioRepository.listarTodos().size()) {
            throw new IllegalArgumentException("ID inválido");
        }
        return usuarioRepository.buscarPorId(id);
    }

    public Usuario cadastrarUsuario(Usuario usuario) {
        if (usuario.getId() > 0) {
            throw new IllegalArgumentException("ID inválido");
        }
        if (usuario.getNome() == null) {
            throw new IllegalArgumentException("Nome inválido");
        }
        if (usuario.getEmail() == null || !usuario.getEmail().matches("^[\\w\\.-]+@[\\w\\.-]+\\.[a-zA-Z]{2,}$")) {
            throw new IllegalArgumentException("Email inválido");
        }
        return  usuarioRepository.inserir(usuario);
    }

    public void deletarUsuarioPorId(long id) {
        if (id <= 0 || id > usuarioRepository.listarTodos().size()) {
            throw new IllegalArgumentException("ID inválido");
        }
        usuarioRepository.deletar(id);
    }
}