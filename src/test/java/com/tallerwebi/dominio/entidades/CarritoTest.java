package com.tallerwebi.dominio.entidades;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;

public class CarritoTest {

    private Carrito carrito;
    private Libro libroMock;

    @BeforeEach
    public void setUp() {
        carrito = new Carrito();
        libroMock = mock(Libro.class);
    }

    @Test
    public void testAgregarLibro() {
        carrito.agregarLibro(libroMock);
        assertEquals(1, carrito.getLibros().size());
    }

    @Test
    public void testAgregarLibroDuplicadoNoSeAgrega() {
        carrito.agregarLibro(libroMock);
        carrito.agregarLibro(libroMock);
        assertEquals(1, carrito.getLibros().size());
    }

    @Test
    public void testEliminarLibro() {
        carrito.agregarLibro(libroMock);
        carrito.eliminarLibro(libroMock);
        assertEquals(0, carrito.getLibros().size());
    }

    @Test
    public void testVaciarCarrito() {
        carrito.agregarLibro(libroMock);
        carrito.vaciarCarrito();
        assertEquals(0, carrito.getLibros().size());
    }

    @Test
    public void testCalcularTotal() {
        Libro libro1 = mock(Libro.class);
        Libro libro2 = mock(Libro.class);

        when(libro1.getPrecio()).thenReturn(4000.0);
        when(libro2.getPrecio()).thenReturn(2000.0);

        carrito.agregarLibro(libro1);
        carrito.agregarLibro(libro2);

        assertEquals(6000.0, carrito.total());
    }
}
