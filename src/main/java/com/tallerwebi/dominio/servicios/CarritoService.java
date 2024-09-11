package com.tallerwebi.dominio.servicios;

import com.tallerwebi.dominio.entidades.Libro;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarritoService {
    void agregarLibro(Libro libro);
    void eliminarLibro(Libro libro);
    void vaciarCarrito();
    List<Libro> obtenerLibros();
    Double calcularTotal();
}
