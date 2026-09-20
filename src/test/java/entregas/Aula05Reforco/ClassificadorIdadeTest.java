package entregas.Aula05Reforco;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class ClassificadorIdadeTest {
    @ParameterizedTest(name = "Idade {0} => {1}")
    @CsvSource({
            "0, CRIANCA",
            "5, CRIANCA",
            "12, CRIANCA",
            "13, ADOLESCENTE",
            "17, ADOLESCENTE",
            "18, ADULTO",
            "30, ADULTO",
            "59, ADULTO",
            "60, IDOSO",
            "80, IDOSO"
    })
    void deveClassificarIdadeCorretamente(int idade, String esperado) {
        String resultado = ClassificadorIdade.classificar(idade);
        assertEquals(esperado, resultado);
    }

    @ParameterizedTest(name = "Idade inválida {0} deve lançar exceção")
    @ValueSource(ints = {-1, -5, -20, -100})
    void idadesInvalidasDevemLancarExcecao(int idade) {
        IllegalArgumentException excecao = assertThrows(IllegalArgumentException.class, () -> ClassificadorIdade.classificar(idade));
        assertEquals("Idade não pode ser negativa.", excecao.getMessage());
    }
}
