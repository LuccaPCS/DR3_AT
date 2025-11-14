package br.edu.infnet;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EmailFakeTest {
    private EmailFake email = new EmailFake();

    @BeforeEach
    void setUp() { email = new EmailFake(); }

    @DisplayName("Testa enviar: Happy Path")
    @Test
    void enviar() {
        email.enviar("lucca.santos@gmail.com", "Olá");
        assertEquals("lucca.santos@gmail.com - Olá", email.getMensagens().get(0));
    }

    @AfterEach
    void tearDown() {
        email = null;
    }
}