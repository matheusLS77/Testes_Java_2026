package entregas.Aula05Reforco;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidadorSenhaTest {
    @ParameterizedTest(name = "Senha: {0} - Válida: {1}")
    @CsvSource({
            "Senha123, true",
            "Teste2026, true",
            "senha123, false",
            "SENHAAAA, false",
            "senha1234, false",
            "Abc1, false",
            "12345678, false",
            "XyZW1999, true",
            "abcdefg1, false",
            "ABCDEFG1, true"
    })
    void deveValidarSenhasCorretamente(String senha, boolean esperado) {
        boolean resultado = ValidadorSenha.senhaValida(senha);
        assertEquals(esperado, resultado);
    }
}
