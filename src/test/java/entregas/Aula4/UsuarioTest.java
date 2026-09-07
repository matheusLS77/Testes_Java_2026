package entregas.Aula4;

import entregas.Aula04.Usuario;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {

    @Test
    void usuarioRecemCriadoDeveTerDadosIniciaisCorretos() {
        Usuario usuario = new Usuario("Joao", "joao@email.com");

        assertAll(
                () -> assertEquals("Joao", usuario.getNome()),
                () -> assertEquals("joao@email.com", usuario.getEmail()),
                () -> assertNull(usuario.getTelefone()),
                () -> assertTrue(usuario.isAtivo())
        );
    }

    @Test
    void definirTelefoneDeveArmazenarValor() {
        Usuario usuario = new Usuario("Joao", "joao@email.com");
        usuario.definirTelefone("(47) 12345678");

        assertAll(
                () -> assertNotNull(usuario.getTelefone()),
                () -> assertEquals("(47) 12345678", usuario.getTelefone())
        );
    }

    @Test
    void telefoneNuloDeveLancarExcecao() {
        Usuario usuario = new Usuario("joao", "joao@email.com");

        IllegalArgumentException excecao = assertThrows(
                IllegalArgumentException.class, () -> usuario.definirTelefone(null)
        );

        assertEquals("O telefone é obrigatório.", excecao.getMessage());
    }

    @Test
    void telefoneEmBrancoDeveLancarExcecao() {
        Usuario usuario = new Usuario("joao", "joao@email.com");

        IllegalArgumentException excecao = assertThrows(
                IllegalArgumentException.class, () -> usuario.definirTelefone("   ")
        );

        assertEquals("O telefone é obrigatório.", excecao.getMessage());
    }

    @Test
    void desativarDeveAlterarParaInativo() {
        Usuario usuario = new Usuario("joao", "joao@email.com");

        usuario.desativar();

        assertFalse(usuario.isAtivo());
    }
}
