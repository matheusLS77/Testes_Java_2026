package entregas.Aula05;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;


public class CalculadoraEstacionamentoTest {
    @ParameterizedTest(name = "horas={0}, fimDeSemana={1}, valorEsperado={2}")
    @CsvSource({
            "1, false, 5.0",
            "1, true, 6.0",
            "24, false, 51.0",
            "2, true, 8.4",
            "23, true, 58.8"
    })
    void calcularDeveRetornarValorCorreto(int horas, boolean fimDeSemana, double valorEsperado) {
        double valorCalculado = CalculadoraEstacionamento.calcular(horas, fimDeSemana);

        assertEquals(valorEsperado, valorCalculado, 0.01);
    }

    @ParameterizedTest(name = "permanência inválida: {0}")
    @ValueSource(ints = {0, -1, 25})
    void permanenciaInvalidaDeveLancarExcecao(int horas) {
       IllegalArgumentException excecao = assertThrows(IllegalArgumentException.class,
               () -> CalculadoraEstacionamento.calcular(horas, false));

        assertEquals("A permanência deve estar entre 1 e 24 horas.", excecao.getMessage());
    }
}
