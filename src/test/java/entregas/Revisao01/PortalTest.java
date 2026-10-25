package entregas.Revisao01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PortalTest {

    @Test
    void loginCorretoDeveRetornarVerdadeiro() {
        Portal portal = new Portal();

        assertTrue(portal.entrar("ana", "1234"));
    }

    @Test
    void loginIncorretoDeveRetornarFalso() {
        Portal portal = new Portal();

        assertFalse(portal.entrar("ana", "senhaErrada"));
    }

    @Test
    void usuarioDeveIniciarDeslogado() {
        Portal portal = new Portal();

        assertNull(portal.getUsuarioLogado());
    }

    @Test
    void sairDeveDeslogarUsuario() {
        Portal portal = new Portal();
        portal.entrar("ana", "1234");

        portal.sair();
        assertNull(portal.getUsuarioLogado());
    }

    @Test
    void loginIncorretoDeveDeslogarUsuario() {
        Portal portal = new Portal();
        portal.entrar("ana", "1234");

        portal.entrar("ana", "errada");
        assertNull(portal.getUsuarioLogado());
    }
}
