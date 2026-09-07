package entregas.Aula4;


import entregas.Aula04.ContaDigital;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContaDigitalTest {
    @Test
    void contaDeveTerSaldoZero() {
        ContaDigital conta = new ContaDigital("Joao");

        assertEquals(0.0, conta.getSaldo(), 0.001);
    }

    @Test
    void depositarDeveAumentarSaldo() {
        ContaDigital conta = new ContaDigital("Joao");

        conta.depositar(100.0);

        assertEquals(100.0, conta.getSaldo(), 0.001);
    }

    @Test
    void sacarDeveDiminuirSaldo() {
        ContaDigital conta = new ContaDigital("Joao");
        conta.depositar(100.0);

        conta.sacar(40.0);

        assertEquals(60.0, conta.getSaldo(), 0.001);
    }

    @Test
    void depositoZeroDeveLancarExcecao() {
        ContaDigital conta = new ContaDigital("Joao");

        IllegalArgumentException excecao = assertThrows(IllegalArgumentException.class, () -> conta.depositar(0.0));

        assertAll(
                () -> assertEquals("O depósito deve ser maior que zero.", excecao.getMessage()),
                () -> assertEquals(0.0, conta.getSaldo(), 0.001)
        );
    }

    @Test
    void depositoNegativoDeveLancarExcecao() {
        ContaDigital conta = new ContaDigital("Joao");

        IllegalArgumentException excecao = assertThrows(IllegalArgumentException.class, () -> conta.depositar(-10.0));

        assertEquals("O depósito deve ser maior que zero.", excecao.getMessage());
    }

    @Test
    void saqueZeroDeveLancarExcecao() {
        ContaDigital conta = new ContaDigital("Joao");
        conta.depositar(100.0);

        IllegalArgumentException excecao = assertThrows(IllegalArgumentException.class, () -> conta.sacar(0.0));

        assertEquals("O saque deve ser maior que zero.", excecao.getMessage());
    }

    @Test
    void saqueNegativoDeveLancarExcecao() {
        ContaDigital conta = new ContaDigital("Maria");
        conta.depositar(100.0);

        IllegalArgumentException excecao = assertThrows(IllegalArgumentException.class, () -> conta.sacar(-10.0));

        assertEquals("O saque deve ser maior que zero.", excecao.getMessage());
    }

    @Test
    void saqueMaiorQueSaldoDeveLancarExcecaoESaldoNaoDeveMudar() {
        ContaDigital conta = new ContaDigital("Joao");
        conta.depositar(50.0);

        IllegalStateException excecao = assertThrows(IllegalStateException.class, () -> conta.sacar(100.0));

        assertAll(
                () -> assertEquals("Saldo insuficiente.", excecao.getMessage()),
                () -> assertEquals(50.0, conta.getSaldo(), 0.001)
        );
    }
}
