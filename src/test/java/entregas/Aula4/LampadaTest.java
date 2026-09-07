package entregas.Aula4;

import entregas.Aula04.Lampada;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LampadaTest {
    @Test
    void lampadaDeveEstarDesligadaEComIntensidadeZero() {
        Lampada lampada = new Lampada("Quarto");

        assertAll(
                () -> assertFalse(lampada.isLigada()),
                () -> assertEquals(0, lampada.getIntensidade())
        );
    }

    @Test
    void ligarDeveAlterarEstadoEIntensidade() {
        Lampada lampada = new Lampada("Quarto");

        lampada.ligar();

        assertAll(
                () -> assertTrue(lampada.isLigada()),
                () -> assertEquals(100, lampada.getIntensidade())
        );
    }

    @Test
    void desligarDeveRestaurarEstadoInicial() {
        Lampada lampada = new Lampada("Quarto");
        lampada.ligar();

        lampada.desligar();

        assertAll(
                () -> assertFalse(lampada.isLigada()),
                () -> assertEquals(0, lampada.getIntensidade())
        );
    }
}
