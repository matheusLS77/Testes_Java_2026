package entregas.Aula05Reforco;

public class ValidadorUsuario {
    public static boolean nomeValido(String nome) {
        if (nome == null || nome.isBlank()) {
            return false;
        }

        return nome.length() >= 3;
    }
}
