package br.edu.infnet.secao3.infra;

import br.edu.infnet.secao3.domain.Usuario;

public class UsuarioService {
    private static UsuarioRepository usuarioRepository = new UsuarioRepository();

    public Usuario cadastrarUsuario(Usuario usuario) {
        if (usuario.getId() > 0) {
            throw new IllegalArgumentException("ID inválido");
        }
        if (usuario.getNome() == null || usuario.getNome().split(" ").length < 2) {
            throw new IllegalArgumentException("Nome inválido");
        }
        if (usuario.getEmail() == null || !usuario.getEmail().matches("^[\\w\\.-]+@[\\w\\.-]+\\.[a-zA-Z]{2,}$")) {
            throw new IllegalArgumentException("Email inválido");
        }
        return  usuarioRepository.inserir(usuario);
    }
}