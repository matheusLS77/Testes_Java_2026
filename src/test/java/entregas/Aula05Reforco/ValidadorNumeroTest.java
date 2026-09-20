package entregas.Aula05Reforco;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidadorNumeroTest {
    @ParameterizedTest(name = "numero={0}")
    @ValueSource(ints = {2, 4, 10, 20, 100, 1000})
    public void numerosParesDevemRetornarTrue(int numero) {
        assertTrue(ValidadorNumero.ehPar(numero));
    }

    @ParameterizedTest(name = "numero={0}")
    @ValueSource(ints = {1, 3, 5, 7, 15, 99, 101})
    public void numerosImparesDevemRetornarFalse(int numero) {
        assertFalse(ValidadorNumero.ehPar(numero));
    }
}

// Por que não seria interessante criar 12 métodos diferentes com @Test?
// Porque isso repetiria muito código
