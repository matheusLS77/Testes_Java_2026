package entregas.Aula06;

public class PagamentoPix extends Pagamento {

    public PagamentoPix(double valor) {
        super(valor);
    }

    @Override
    public double calcularTaxa(double valor) {
        return valor;
    }
}
