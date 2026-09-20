package entregas.Aula05Reforco;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class EstacionamentoTest {
    @ParameterizedTest(name = "{0} horas")
    @CsvSource({
        "1, 5.0",
        "2, 10.0",
        "3, 10.0",
        "4, 15.0",
        "6, 15.0",
        "7, 25.0"
    })
    void deveCalcularValorCorretamente(int horas, double esperado) {
        double resultado = Estacionamento.calcularValor(horas);
        assertEquals(esperado, resultado, 0.001);
    }

    @ParameterizedTest(name = "{0} horas")
    @ValueSource(ints = {0, -1, -5, -100})
    void horasInvalidasDevemLancarExcecao(int horas) {
        IllegalArgumentException excecao = assertThrows(IllegalArgumentException.class, () -> Estacionamento.calcularValor(horas));
        assertEquals("Tempo inválido.", excecao.getMessage());
    }
}
