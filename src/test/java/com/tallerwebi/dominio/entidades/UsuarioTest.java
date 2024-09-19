package com.tallerwebi.dominio.entidades;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UsuarioTest {

    private Usuario usuario;

    @BeforeEach
    public void setUp() {
        usuario = new Usuario();
    }

    @Test
    public void testGetSetId() {
        usuario.setId(1L);
        assertEquals(1L, usuario.getId());
    }

    @Test
    public void testGetSetEmail() {
        String email = "usuario@gmail.com";
        usuario.setEmail(email);
        assertEquals(email, usuario.getEmail());
    }

    @Test
    public void testGetSetPassword() {
        String password = "password123";
        usuario.setPassword(password);
        assertEquals(password, usuario.getPassword());
    }

    @Test
    public void testGetSetRolAdmin() {
        String rol = "ADMIN";
        usuario.setRol(rol);
        assertEquals(rol, usuario.getRol());
    }

    @Test
    public void testGetSetRolNoAdimn() {
        String rol = "NO ADMIN";
        usuario.setRol(rol);
        assertEquals(rol, usuario.getRol());
    }

    @Test
    public void testGetSetActivo() {
        usuario.setActivo(true);
        assertTrue(usuario.getActivo());

        usuario.setActivo(false);
        assertFalse(usuario.getActivo());
    }

    @Test
    public void testActivar() {
        // Inicialmente el usuario no está activo
        assertFalse(usuario.getActivo());

        // Activamos al usuario
        usuario.activar();

        // Ahora el usuario debe estar activo
        assertTrue(usuario.getActivo());
    }

    @Test
    public void testActivo() {
        // Inicialmente, `activo()` debe devolver false
        assertFalse(usuario.activo());

        // Activamos el usuario
        usuario.activar();

        // Ahora `activo()` debe devolver true
        assertTrue(usuario.activo());
    }
}
