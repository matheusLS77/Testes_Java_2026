package entregas.Revisao02;

import entregas.Revisao02.ContaBancaria;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContaBancariaTest {
    private ContaBancaria conta;

    @BeforeEach
    void prepararConta() {
        conta = new ContaBancaria("João");
    }

    @Test
    void deveIniciarComSaldoDeCemReais() {
        assertEquals(100.0, conta.getSaldo(), 0.001);
    }

    @Test
    void deveDepositarCinquentaReais() {
        conta.depositar(50.0);

        assertEquals(150.0, conta.getSaldo(), 0.001);
    }

    @Test
    void deveSacarTrintaReais() {
        conta.sacar(30.0);

        assertEquals(70.0, conta.getSaldo(), 0.001);
    }

    @Test
    void naoDevePermitirSaqueAcimaDoSaldo() {
        assertThrows(IllegalStateException.class, () -> conta.sacar(200.0));

        assertEquals(100.0, conta.getSaldo(), 0.001);
    }
}
