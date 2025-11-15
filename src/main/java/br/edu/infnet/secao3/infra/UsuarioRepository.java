package br.edu.infnet.secao3.infra;

import br.edu.infnet.secao3.domain.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsuarioRepository {
    private ArrayList<Usuario> usuarios =  new ArrayList<Usuario>();

    public UsuarioRepository() {
        usuarios.add(new Usuario(1, "Lucas", "lucas@gmail.com"));
        usuarios.add(new Usuario(2, "Raquel", "raquel@gmail.com"));
    }

    public List<Usuario> listarTodos() {
        return usuarios;
    }

    public Optional<Usuario> buscarPorId(long id) {
        return usuarios.stream().filter(u -> u.getId() == id).findAny();
    }

    public Usuario inserir(Usuario novoUsuario) {
        novoUsuario.setId(usuarios.size()+1);
        usuarios.add(novoUsuario);
        return novoUsuario;
    }

    public boolean deletar(long id) {
        return usuarios.removeIf(u -> u.getId() == id);
    };
}
