package entregas.Aula05Reforco;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class ValidadorUsuarioTest {
    @ParameterizedTest(name = "nome={0}")
    @ValueSource(strings = {"Ana", "Carlos", "Maria", "Joao123", "usuario"})
    void nomesValidosDevemRetornarTrue(String nome) {
        assertTrue(ValidadorUsuario.nomeValido(nome));
    }

    @ParameterizedTest(name = "nome={0}")
    @ValueSource(strings = {"", "   "})
    @NullAndEmptySource
    void nomesInvalidosDevemRetornarFalse(String nome) {
        assertFalse(ValidadorUsuario.nomeValido(nome));
    }
}

// @NullAndEmptySource testa automaticamente Strings contendo espaços? Descubra como adicionar esses valores ao teste.
// Testa apenas null e ""