package entregas.Aula4;

import entregas.Aula04.Produto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProdutoTest {

    @Test
    void calcularValorTotalDeveMultiplicarPrecoPelaQuantidade() {
        Produto produto = new Produto("Produto", 100.0, 2);

        double obtido = produto.calcularValorEmEstoque();

        assertEquals(200.0, obtido, 0.001);
    }

    @Test
    void temEstoqueDeveRetornarTrueComQuantidadePositiva() {
        Produto produto = new Produto("Produto", 40.0, 11);

        boolean obtido = produto.temEstoque();

        assertTrue(obtido);
    }

    @Test
    void temEstoqueDeveRetornarFalseComQuantidadeIgualAZero() {
        Produto produto = new Produto("Produto", 40.0, 0);

        boolean obtido = produto.temEstoque();

        assertFalse(obtido);
    }

    @Test
    void precoZeroDeveLancarExcecao() {
        IllegalArgumentException excecao = assertThrows(
                IllegalArgumentException.class, () -> new Produto("Produto", 0.0, 51));

        assertEquals("O preço deve ser maior que zero.", excecao.getMessage());
    }

    @Test
    void precoNegativoDeveLancarExcecao() {
        IllegalArgumentException excecao = assertThrows(
                IllegalArgumentException.class, () -> new Produto("Produto", -2.0, 2));

        assertEquals("O preço deve ser maior que zero.", excecao.getMessage());
    }

    @Test
    void estoqueNegativoDeveLancarExcecao() {
        IllegalArgumentException excecao = assertThrows(
                IllegalArgumentException.class, () -> new Produto("Produto", 120.0, -1));

        assertEquals("O estoque não pode ser negativo.", excecao.getMessage());
    }
}
