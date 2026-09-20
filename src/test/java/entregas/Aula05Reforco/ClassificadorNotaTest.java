package entregas.Aula05Reforco;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ClassificadorNotaTest {
    @ParameterizedTest
    @CsvSource({
            "0.0, REPROVADO",
            "2.5, REPROVADO",
            "4.9, REPROVADO",
            "5.0, RECUPERACAO",
            "6.0, RECUPERACAO",
            "6.9, RECUPERACAO",
            "7.0, APROVADO",
            "8.5, APROVADO",
            "10.0, APROVADO"
    })
    void deveClassificarNota(double nota, String esperado) {
        String resultado = ClassificadorNota.classificar(nota);
        assertEquals(esperado, resultado);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-0.1, -1.0, -5.0, -100.0})
    void deveLancarExcecaoParaNotaNegativa(double nota) {
        IllegalArgumentException excecao = assertThrows(IllegalArgumentException.class, () -> ClassificadorNota.classificar(nota));
        assertEquals("Nota deve estar entre 0 e 10.", excecao.getMessage());
    }

    @ParameterizedTest
    @ValueSource(doubles = {10.1, 11.0, 20.0, 100.0})
    void deveLancarExcecaoParaNotaMaiorQueDez(double nota) {
        IllegalArgumentException excecao = assertThrows(IllegalArgumentException.class, () -> ClassificadorNota.classificar(nota));
        assertEquals("Nota deve estar entre 0 e 10.", excecao.getMessage());
    }
}