package com.tallerwebi.dominio.entidades;

import java.util.ArrayList;
import java.util.List;

public class Carrito {

    private List<Libro> libros;

    public Carrito() {
        libros = new ArrayList<>();
    }

    public void agregarLibro(Libro libro) {
        if (!libros.contains(libro)) {
            libros.add(libro);
        }
    }

    public void eliminarLibro(Libro libro) {
        libros.remove(libro);
    }

    public void vaciarCarrito() {
        libros.clear();
    }

    public List<Libro> obtenerLibros() {
        return libros;
    }

    public Double calcularTotal() {
        return libros.stream()
                .mapToDouble(Libro::getPrecio)
                .sum();
    }
}

