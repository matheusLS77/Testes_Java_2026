package entregas.Aula05;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraFreteTest {
    // Verifica diferentes pesos e modalidades.
    @ParameterizedTest(name = "peso={0}, expressa={1}, esperado={2}")
    @CsvSource({
            // peso, expressa, esperado
            "0.01, false,  8.02", // Fronteira válida
            "1.00, false, 10.00",
            "5.00, false, 18.00",
            "1.00, true,  15.00",
            "5.00, true,  27.00"
    })
    void calcularDeveRetornarFreteCorreto(double peso, boolean expressa, double esperado) {
        double obtido = CalculadoraFrete.calcular(peso, expressa);

        assertEquals(esperado, obtido, 0.001);
    }

    // Verifica a fronteira inválida e valores negativos.
    @ParameterizedTest(name = "peso inválido: {0}")
    @ValueSource(doubles = {0.0, -0.01, -10.0})
    void pesoInvalidoDeveLancarExcecao(double peso) {
        IllegalArgumentException excecao = assertThrows(IllegalArgumentException.class,
                () -> CalculadoraFrete.calcular(peso, false)
        );

        assertEquals("O peso deve ser maior que zero.", excecao.getMessage());
    }
}