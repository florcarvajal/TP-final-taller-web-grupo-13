package com.tallerwebi.dominio.entidades;

import java.util.ArrayList;
import java.util.List;

public class Carrito {
    private List<Libro> libros = new ArrayList<>();

    public void agregarLibro(Libro libro) {
       if(!libros.contains(libro)) {
           libros.add(libro);
       }
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public double total() {
        return libros.stream().mapToDouble(Libro::getPrecio).sum();
    }

    public void eliminarLibro(Libro libro) {
    libros.remove(libro);

    }

    public void vaciarCarrito() {
    libros.clear();
    }
}
