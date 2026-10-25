package entregas.Revisao01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UsuarioTest {

    @Test
    void usuarioDeveTerNomeCorreto() {
        Usuario usuario = new Usuario("Joao", "joao");

        assertEquals("Joao", usuario.getNome());
    }

    @Test
    void usuarioDeveTerLoginCorreto() {
        Usuario usuario = new Usuario("Joao", "joao");

        assertEquals("joao", usuario.getLogin());
    }
}
