package entregas.Aula06;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Teste do Pagamento")
@Tag("pagamento")
public class PagamentoTest {

    @DisplayName("Pagamento por pix")
    @Nested
    @Tag("pix")
    class Pix {

        @DisplayName("Deve cobrar valor sem taxa")
        @ParameterizedTest(name = "valor R$ {0}, esperado: R$ {1}")
        @CsvSource({
                "1, 1",
                "2, 2",
                "3, 3",
                "4, 4",
                "5, 5"
        })
        void naoDeveCobrarTaxa(double valor, double esperado) {
            PagamentoPix pix = new PagamentoPix(valor);
            double resultado = pix.calcularTaxa(valor);

            assertEquals(esperado, resultado);
        }

        @Test
        @DisplayName("Deve lançar exceção para valor igual a zero")
        void deveLancarExcecaoParaValorNegativo() {
            double valor = -1;

            IllegalArgumentException excecao = assertThrows(IllegalArgumentException.class, ()
                    -> new PagamentoPix(valor).calcularTaxa(valor));

            assertEquals("O valor deve ser maior que zero.", excecao.getMessage());
        }
    }

    @DisplayName("Pagamento por cartão")
    @Nested
    @Tag("cartao")
    class Cartao {

        @Test
        @DisplayName("Deve cobrar R$125 com a taxa do cartão")
        void deveCobrarTaxa() {
            double valor = 100;
            PagamentoCartao cartao = new PagamentoCartao(valor);

            double pagamentoObtido = cartao.calcularTaxa(valor);

            assertEquals(102.5, pagamentoObtido, 0.001);
        }

        @Test
        @DisplayName("Deve lançar exceção para valor negativo")
        void deveLancarExcecaoParaValorIgualAZero() {
            double valor = 0;

            IllegalArgumentException excecao = assertThrows(IllegalArgumentException.class, ()
                    -> new PagamentoCartao(valor).calcularTaxa(valor));

            assertEquals("O valor deve ser maior que zero.", excecao.getMessage());
        }
    }

    @DisplayName("Teste polimorfico")
    @Nested
    @Tag("polimorfico")
    class Polimorfismo {

        @DisplayName("Confirma os dois tipos de pagamentos")
        @Test
        void deveCobrarTaxaCorretamente() {
            double valor = 1;

            PagamentoPix pix = new PagamentoPix(valor);
            PagamentoCartao cartao = new PagamentoCartao(valor);

            assertAll(
                    () -> assertEquals(1, pix.calcularTaxa(valor)),
                    () -> assertEquals(1.025, cartao.calcularTaxa(valor))
            );
        }

    }
}
