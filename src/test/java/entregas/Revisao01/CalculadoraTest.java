package entregas.Revisao01;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {

    @Test
    void somarDeveRetornarResultadoCorreto() {
        Calculadora calculadora = new Calculadora();

        assertEquals(10, calculadora.somar(5, 5));
    }

    @Test
    void dividirDeveRetornarResultadoCorreto() {
        Calculadora calculadora = new Calculadora();

        assertEquals(5.0, calculadora.dividir(10, 2), 0.001);
    }

    @Test
    void divisaoPorZeroDeveLancarExcecao() {
        Calculadora calculadora = new Calculadora();

        IllegalArgumentException excecao = assertThrows(IllegalArgumentException.class, () -> calculadora.dividir(10, 0));
        assertEquals("Não é possível dividir por zero.", excecao.getMessage());
    }

    @Test
    void numeroParDeveRetornarVerdadeiro() {
        Calculadora calculadora = new Calculadora();

        assertTrue(calculadora.ehPar(4));
    }

    @Test
    void numeroImparDeveRetornarFalso() {
        Calculadora calculadora = new Calculadora();

        assertFalse(calculadora.ehPar(5));
    }

    @Test
    void gerarSequenciaDeveRetornarNumerosCorretos() {
        Calculadora calculadora = new Calculadora();

        assertArrayEquals(new int[]{1, 2, 3}, calculadora.gerarSequencia());
    }
}
