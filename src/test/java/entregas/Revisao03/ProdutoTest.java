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
    void deveRejeitarNomeEmBranco() {
        String nome = "   ";

        assertThrows(IllegalArgumentException.class,
                () -> new Produto(nome, 10.0, 5));
    }

    @Test
    void deveRejeitarNomeNulo() {
        assertThrows(IllegalArgumentException.class,
                () -> new Produto(null, 10.0, 5));
    }

    @Test
    void deveRejeitarPrecoZero() {
        assertThrows(IllegalArgumentException.class,
                () -> new Produto("Produto 3", 0.0, 5));
    }

    @Test
    void deveRejeitarPrecoNegativo() {
        assertThrows(IllegalArgumentException.class,
                () -> new Produto("Produto 5", -10.0, 5));
    }

    @Test
    void deveRejeitarDescontoNegativo() {
        Produto produto = new Produto("Produto 4", 100.0, 2);

        assertThrows(IllegalArgumentException.class,
                () -> produto.calcularValorComDesconto(-10.0));
    }

    @Test
    void deveRejeitarDescontoAcimaDeCem() {
        Produto produto = new Produto("Produto 3", 100.0, 2);

        IllegalArgumentException execao = assertThrows(IllegalArgumentException.class,
                () -> produto.calcularValorComDesconto(101.0));

        assertEquals("O percentual deve estar entre 0 e 100", execao.getMessage());
    }

    @Test
    void verificaDadosProduto() {
        Produto produto = new Produto("Produto ABC", 50.0, 3);

        assertAll(
                () -> assertEquals("Produto ABC", produto.getNome()),
                () -> assertEquals(50.0, produto.getPreco(), 0.001),
                () -> assertEquals(3, produto.getQuantidade()),
                () -> assertEquals(150.0, produto.calcularValorEstoque(), 0.001)
        );
    }
}
