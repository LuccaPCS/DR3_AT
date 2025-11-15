package br.edu.infnet.secao1;

import br.edu.infnet.secao1.Calculadora;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculadoraTest {
    private Calculadora calculadora1;

    @BeforeEach
    void setUp() { calculadora1 = new Calculadora(); }

    @DisplayName("Teste de soma: Happy Path")
    @Test
    void testaSomar() {
        int soma = calculadora1.somar(15, 25);
        assertEquals(40, soma);
    }

    @DisplayName("Teste de subtração: Happy Path")
    @Test
    void testaSubtrair() {
        int subtracao = calculadora1.subtrair(15, 25); /*Act*/
        assertEquals(-10, subtracao); /*Assert*/
    }

    @DisplayName("Teste de divisão: Por zero")
    @Test
    void testaDivisaoZero() {
        Exception exception = assertThrows(Exception.class, () -> {
            calculadora1.dividir(5, 0);
        });
        assertEquals("Não é possível dividir por zero!", exception.getMessage());
    }

    @AfterEach
    void tearDown() {
        calculadora1 = null;
    }
}