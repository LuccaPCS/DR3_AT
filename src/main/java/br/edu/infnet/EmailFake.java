package br.edu.infnet;

import java.util.ArrayList;
import java.util.List;

public class EmailFake implements ServicoEmail{
    private List<String> mensagens = new ArrayList<>();
    @Override
    public void enviar(String destinatario, String mensagem) {
        mensagens.add(destinatario + " - " + mensagem);
    }

    public List<String> getMensagens() {
        return mensagens;
    }
}
