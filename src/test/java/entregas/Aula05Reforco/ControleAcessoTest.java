package entregas.Aula05Reforco;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ControleAcessoTest {
    @ParameterizedTest(name = "Idade {0} e acompanhado {1} = {2}")
    @CsvSource({
        "15, false, false",
        "15, false, false",
        "16, true, true",
        "16, false, false",
        "17, true, true",
        "17, false, false",
        "18, true, true",
        "18, false, true",
        "25, false, true"

    })
    void deveVerificarAcessoCorretamente(int idade, boolean acompanhado, boolean esperado) {
        boolean resultado = ControleAcesso.podeEntrar(idade, acompanhado);
        assertEquals(esperado, resultado);
    }
}
