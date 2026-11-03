package entregas.Revisao03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProdutoTest {

    @Test
    void deveCalcularValorEstoque() {
        Produto produto = new Produto("Produto 1", 25.0, 4);

        double valorEstoque = produto.calcularValorEstoque();

         assertEquals(100.0, valorEstoque, 0.001);
    }

    @Test
    void deveCalcularValorComDesconto() {
        Produto produto = new Produto("Produto 2", 80.0, 1);

        double precoDesconto = produto.calcularValorComDesconto(25.0);

        assertEquals(60.0, precoDesconto, 0.001);
    }

    @Test
    void precoNegativoDeveLancarExcecao() {
        IllegalArgumentException execao = assertThrows(IllegalArgumentException.class,
                () -> new Produto("Produto 3", -50.0, 2));

        assertEquals("O preço deve ser maior que zero", execao.getMessage());
    }

    @Test
    void descontosForaDoIntervaloDeveLancarExcecao() {
        Produto produto = new Produto("Produto 3", 100.0, 2);

        IllegalArgumentException execao = assertThrows(IllegalArgumentException.class,
                () -> produto.calcularValorComDesconto(-25.0));

        assertEquals("O percentual deve estar entre 0 e 100", execao.getMessage());
    }

    @Test
    void verificaDadosProduto() {
        Produto produto = new Produto("Produto 4", 50.0, 3);

        assertAll(
                () -> assertEquals("Produto 4", produto.getNome()),
                () -> assertEquals(50.0, produto.getPreco(), 0.001),
                () -> assertEquals(3, produto.getQuantidade()),
                () -> assertEquals(150.0, produto.calcularValorEstoque(), 0.001)
        );
    }
}
