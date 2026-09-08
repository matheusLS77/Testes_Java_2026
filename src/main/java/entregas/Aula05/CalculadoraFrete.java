package entregas.Aula05;

public class CalculadoraFrete {
    private double pesoKg;
    private double expressa;

    public CalculadoraFrete() {
    }

    public static double calcular(double pesoKg, boolean entregaExpressa) {
        if (pesoKg <= 0) {
            throw new IllegalArgumentException("O peso deve ser maior que zero.");
        }

        double freteComum = 8 + (pesoKg * 2);

        if (entregaExpressa) {
            return freteComum + (freteComum * 0.5);
        } else {
            return freteComum;
        }
    }

    public double getPesoKg() {
        return pesoKg;
    }

    public void setPesoKg(double pesoKg) {
        this.pesoKg = pesoKg;
    }

    public double getExpressa() {
        return expressa;
    }

    public void setExpressa(double expressa) {
        this.expressa = expressa;
    }
}
