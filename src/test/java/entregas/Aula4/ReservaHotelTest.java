package entregas.Aula4;

import entregas.Aula04.ReservaHotel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ReservaHotelTest {

    @Test
    void reservaDeveTerDadosIniciaisCorretos() {
        ReservaHotel reserva = new ReservaHotel("Joao", 2, 100.0);

        assertAll(
                () -> assertEquals("Joao", reserva.getHospede()),
                () -> assertEquals(2, reserva.getQuantidadeDiarias()),
                () -> assertEquals(100.0, reserva.getValorDiaria(), 0.001),
                () -> assertFalse(reserva.isConfirmada()),
                () -> assertNull(reserva.getCodigoConfirmacao())
        );
    }

    @Test
    void calcularTotalDeveMultiplicarDiariasPeloValor() {
        ReservaHotel reserva = new ReservaHotel("Joao", 2, 100.0);

        double obtido = reserva.calcularTotal();

        assertEquals(200.0, obtido, 0.001);
    }

    @Test
    void confirmarDeveArmazenarCodigo() {
        ReservaHotel reserva = new ReservaHotel("Joao", 2, 200.0);

        reserva.confirmar("ABC123");

        assertAll(
                () -> assertTrue(reserva.isConfirmada()),
                () -> assertNotNull(reserva.getCodigoConfirmacao()),
                () -> assertEquals("ABC123", reserva.getCodigoConfirmacao())
        );
    }

    @Test
    void hospedeNuloDeveLancarExcecao() {
        IllegalArgumentException excecao = assertThrows(IllegalArgumentException.class, () -> new ReservaHotel(null, 2, 200.0));

        assertEquals("O hóspede é obrigatório.", excecao.getMessage());
    }

    @Test
    void hospedeEmBrancoDeveLancarExcecao() {
        IllegalArgumentException excecao = assertThrows(IllegalArgumentException.class, () -> new ReservaHotel("   ", 2, 200.0));

        assertEquals("O hóspede é obrigatório.", excecao.getMessage());
    }

    @Test
    void quantidadeZeroDeveLancarExcecao() {
        IllegalArgumentException excecao = assertThrows(IllegalArgumentException.class, () -> new ReservaHotel("Joao", 0, 100.0));

        assertEquals("A quantidade de diárias deve ser maior que zero.", excecao.getMessage());
    }

    @Test
    void quantidadeNegativaDeveLancarExcecao() {
        IllegalArgumentException excecao = assertThrows(IllegalArgumentException.class, () -> new ReservaHotel("Joao", -1, 100.0));

        assertEquals("A quantidade de diárias deve ser maior que zero.", excecao.getMessage());
    }

    @Test
    void valorZeroDeveLancarExcecao() {
        IllegalArgumentException excecao = assertThrows(IllegalArgumentException.class, () -> new ReservaHotel("Eva", 2, 0.0));

        assertEquals("O valor da diária deve ser maior que zero.", excecao.getMessage());
    }

    @Test
    void valorNegativoDeveLancarExcecao() {
        IllegalArgumentException excecao = assertThrows(IllegalArgumentException.class, () -> new ReservaHotel("Eva", 2, -1.0));

        assertEquals("O valor da diária deve ser maior que zero.", excecao.getMessage());
    }

    @Test
    void codigoNuloDeveLancarExcecao() {
        ReservaHotel reserva = new ReservaHotel("Joao", 2, 200.0);

        IllegalArgumentException excecao = assertThrows(IllegalArgumentException.class, () -> reserva.confirmar(null));

        assertEquals("O código de confirmação é obrigatório.", excecao.getMessage());
    }

    @Test
    void codigoEmBrancoDeveLancarExcecao() {
        ReservaHotel reserva = new ReservaHotel("Joao", 2, 200.0);

        IllegalArgumentException excecao = assertThrows(IllegalArgumentException.class, () -> reserva.confirmar("   "));

        assertEquals("O código de confirmação é obrigatório.", excecao.getMessage());
    }

    @Test
    void confirmarDuplicadoDeveLancarExcecao() {
        ReservaHotel reserva = new ReservaHotel("Gabriela", 5, 220.0);
        reserva.confirmar("ABC123");

        IllegalStateException excecao = assertThrows(IllegalStateException.class, () -> reserva.confirmar("ABC123"));

        assertAll(
                () -> assertEquals("A reserva já está confirmada.", excecao.getMessage()),
                () -> assertEquals("ABC123", reserva.getCodigoConfirmacao())
        );
    }
}
