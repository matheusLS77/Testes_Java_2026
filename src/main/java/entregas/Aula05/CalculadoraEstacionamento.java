package entregas.Aula05;

public class CalculadoraEstacionamento {
    private int horas;
    private boolean fimDeSemana;

    public CalculadoraEstacionamento() {
    }

    public static double calcular(int horas, boolean fimDeSemana) {
        if (horas <= 0 || horas > 24) {
            throw new IllegalArgumentException("A permanência deve estar entre 1 e 24 horas.");
        }

        double valor = 5 + (horas - 1) * 2;

        if (fimDeSemana) {
            valor = valor + (valor * 0.2);
        }

        return valor;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public boolean isFimDeSemana() {
        return fimDeSemana;
    }

    public void setFimDeSemana(boolean fimDeSemana) {
        this.fimDeSemana = fimDeSemana;
    }
}
