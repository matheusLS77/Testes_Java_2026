package entregas.Aula05;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraFreteTest {
    @DisplayName("Deve calcular o frete corretamente para diferentes pesos e tipos de frete")
    //Define valores recebidos
    @ParameterizedTest(name = "peso={0}, expressa={1}, esperado={2}")
    // Dados fornecidos
    @CsvSource({
            // peso, expressa, esperado
            "0.01, false,  8.02",
            "1.00, false, 10.00",
            "5.00, false, 18.00",
            "1.00, true,  15.00",
            "5.00, true,  27.00"
    })
    void calcularFreteCorreto(double peso, boolean expressa, double esperado) {
        double obtido = CalculadoraFrete.calcular(peso, expressa);

        // Verifica se o valor obtido é igual ao valor esperado
        assertEquals(esperado, obtido, 0.001);
    }

    @DisplayName("Deve lançar exceção para peso inválido")
    @ParameterizedTest(name = "peso inválido: {0}")
    // Lista de pesos inválidos para teste
    @ValueSource(doubles = {0.0, -0.01, -10.0})
    void pesoInvalidoDeveLancarExcecao(double peso) {
        // Verifica se a exceção é lançada para pesos inválidos
        IllegalArgumentException excecao = assertThrows(IllegalArgumentException.class,
                () -> CalculadoraFrete.calcular(peso, false)
        );

        // Verifica se a mensagem da exceção é a esperada
        assertEquals("O peso deve ser maior que zero.", excecao.getMessage());
    }
}