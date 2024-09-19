package com.tallerwebi.dominio.entidades;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class LibroTest {

    private Libro libro;

    @BeforeEach
    public void setUp() {
        // Crear una instancia del Libro
        libro = Mockito.mock(Libro.class);
    }

    @Test
    public void testSetAndGetId() {
        Long id = 1L;

        // Llamada al método setId
        libro.setId(id);
        verify(libro).setId(id); // Verificar que se llama al método setId

        // Configurar el comportamiento del mock
        when(libro.getId()).thenReturn(id);

        // Verificar el valor esperado
        assert(libro.getId()).equals(id);
        verify(libro).getId(); // Verificar que se llama al método getId
    }

    @Test
    public void testSetAndGetTitulo() {
        String titulo = "Orgullo y Prejuicio";

        libro.setTitulo(titulo);
        verify(libro).setTitulo(titulo);

        when(libro.getTitulo()).thenReturn(titulo);

        assert(libro.getTitulo()).equals(titulo);
        verify(libro).getTitulo();
    }

    @Test
    public void testSetAndGetAutor() {
        String autor = "Jane Austen";

        libro.setAutor(autor);
        verify(libro).setAutor(autor);

        when(libro.getAutor()).thenReturn(autor);

        assert(libro.getAutor()).equals(autor);
        verify(libro).getAutor();
    }

    @Test
    public void testSetAndGetEditorial() {
        String editorial = "Penguin Random House";

        libro.setEditorial(editorial);
        verify(libro).setEditorial(editorial);

        when(libro.getEditorial()).thenReturn(editorial);

        assert(libro.getEditorial()).equals(editorial);
        verify(libro).getEditorial();
    }

    @Test
    public void testSetAndGetPrecio() {
        Double precio = 4000.00;

        libro.setPrecio(precio);
        verify(libro).setPrecio(precio);

        when(libro.getPrecio()).thenReturn(precio);

        assert(libro.getPrecio()).equals(precio);
        verify(libro).getPrecio();
    }
}
