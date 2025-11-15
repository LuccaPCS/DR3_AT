package br.edu.infnet.secao3.app;

import io.javalin.Javalin;

public class HelloWorld {
    public static void main(String[] args) {
        Javalin app = Javalin.create()
                .port(7000)
                .start();
        app.get("/hello", ctx -> ctx.html("Hello, World!"));
    }
}
