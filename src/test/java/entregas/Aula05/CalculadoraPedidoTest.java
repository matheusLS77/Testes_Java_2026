package entregas.Aula05;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculadoraPedidoTest {
    @ParameterizedTest(name = "{0}")
    @MethodSource("cenariosDePedido")
    void calcularDeveAtenderCenariosValidos(
            String descricao,
            Item item,
            int percentualCupom,
            double esperado) {

        // Act: execute o cálculo.
        double resultado = CalculadoraPedido.calcular(item, percentualCupom);

        // Assert: compare esperado e obtido usando delta.
        assertEquals(esperado, resultado, 0.01);
    }

    static Stream<Arguments> cenariosDePedido() {
        return Stream.of(
                 Arguments.of("sem desconto", new Item("A", 1, 1), 0, 1.0),
                Arguments.of("com desconto de 1%", new Item("A", 1, 1), 1, 0.99),
                 Arguments.of("com desconto de 29%", new Item("B", 1, 1), 29, 0.71),
                 Arguments.of("com desconto total", new Item("C", 1, 1), 30, 0.7)
        );
    }

    @ParameterizedTest
    @NullSource
    void itemNuloDeveLancarExcecao(Item item) {
        // Use assertThrows e verifique a mensagem.
        IllegalArgumentException excecao = assertThrows(IllegalArgumentException.class, () -> CalculadoraPedido.calcular(item, 0));

        assertEquals("O item é obrigatório.", excecao.getMessage());
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"   ", "\t", ""})
    void nomeAusenteDeveLancarExcecao(String nome) {
        // Crie um Item usando o nome recebido.
        Item item = new Item(nome, 1, 1);

        // Depois verifique a exceção e sua mensagem.
        IllegalArgumentException excecao = assertThrows(IllegalArgumentException.class, () -> CalculadoraPedido.calcular(item, 0));

        assertEquals("O nome do item é obrigatório.", excecao.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 31})
    void cupomInvalidoDeveLancarExcecao(int percentualCupom) {
        Item item = new Item("A", 1, 1);

        IllegalArgumentException excecao = assertThrows(IllegalArgumentException.class, () -> CalculadoraPedido.calcular(item, percentualCupom));

       assertEquals("O cupom deve estar entre 0 e 30.", excecao.getMessage());
    }

    @Test
    @Timeout(value = 1, unit = TimeUnit.MILLISECONDS)
    void calcularDeveTerminarRapidamente() {
        Item item = new Item("A", 1, 1);
        CalculadoraPedido.calcular(item, 0);
    }
}
