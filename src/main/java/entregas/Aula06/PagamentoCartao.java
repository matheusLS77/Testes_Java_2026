package entregas.Aula06;

public class PagamentoCartao extends Pagamento {

    public PagamentoCartao(double valor) {
        super(valor);
    }

    @Override
    public double calcularTaxa(double valor) {
        return valor + (valor * 2.5/100);
    }
}
