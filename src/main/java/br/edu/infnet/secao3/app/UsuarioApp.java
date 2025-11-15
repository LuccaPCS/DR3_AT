package br.edu.infnet.secao3.app;

import br.edu.infnet.secao3.controller.UsuarioController;
import io.javalin.Javalin;

public class UsuarioApp {
    public static void main(String[] args) {
        Javalin app = Javalin.create()
                .port(7000)
                .start();
        app.get("/usuarios", UsuarioController.listarTodos);
        app.get("/usuarios/:id", UsuarioController.obterPorId);
        app.post("/usuarios", UsuarioController.inserirUsuario);
        app.delete("/usuarios/:id", UsuarioController.deletarUsuario);
    }
}
