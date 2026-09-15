package entregas.Aula05;

public class CalculadoraFrete {
    private double pesoKg;
    private boolean expressa;

    public CalculadoraFrete() {
    }

    public static double calcular(double pesoKg, boolean expressa) {
        // Verificacao de peso inválido
        if (pesoKg <= 0) {
            throw new IllegalArgumentException("O peso deve ser maior que zero.");
        }

        // Cálculo do frete comum
        double freteComum = 8 + (pesoKg * 2);

        if (expressa) {
            // Cálculo do frete expresso
            return freteComum * 1.5;
        }

        return freteComum;
    }

    public double getPesoKg() {
        return pesoKg;
    }

    public void setPesoKg(double pesoKg) {
        this.pesoKg = pesoKg;
    }

    public boolean getExpressa() {
        return expressa;
    }

    public void setExpressa(boolean expressa) {
        this.expressa = expressa;
    }
}
