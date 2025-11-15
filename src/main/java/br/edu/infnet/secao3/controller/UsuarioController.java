package br.edu.infnet.secao3.controller;

import br.edu.infnet.secao3.domain.Usuario;
import br.edu.infnet.secao3.infra.UsuarioRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import io.javalin.Handler;

public class UsuarioController {
    private static UsuarioRepository usuarioRepository =  new UsuarioRepository();

    public static Handler listarTodos = ctx -> {
        List<Usuario> usuarios = usuarioRepository.listarTodos();
        ctx.json(usuarios);
    };

    public static Handler obterPorId = ctx -> {
        int id = Integer.parseInt(Objects.requireNonNull(ctx.param("id")));
        Optional<Usuario> usuario = usuarioRepository.buscarPorId(id);
        if (usuario.isPresent()) {
            ctx.json(usuario.get());
        } else {
            ctx.html("Not found");
        }
    };

    public static Handler inserirUsuario = ctx -> {
        Usuario novoUsuario = ctx.bodyAsClass(Usuario.class);
        novoUsuario = usuarioRepository.inserir(novoUsuario);
        ctx.json(novoUsuario);
    };

    public static Handler deletarUsuario = ctx -> {

    };
}
