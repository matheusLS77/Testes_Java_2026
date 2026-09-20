package entregas.Aula05Reforco;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AutenticadorTest {
    @ParameterizedTest(name = "usuário: {0}, senha: {1}, ativo: {2}")
    @MethodSource("tentativasDeAutenticacao")
    void deveAutenticar(String usuario, String senha, boolean ativo, boolean esperado) {
        boolean resultado = Autenticador.autenticar(usuario, senha, ativo);
        assertEquals(esperado, resultado);
    }

    static Stream<Arguments> tentativasDeAutenticacao() {
        return Stream.of(
                Arguments.of("admin", "Senai123", true, true),
                Arguments.of("admin", "senha", true, false),
                Arguments.of("usuario", "Senai123", true, false),
                Arguments.of("admin", "Senai123", false, false),
                Arguments.of(null, "Senai123", true, false),
                Arguments.of("admin", null, true, false)
        );
    }
}
