package com.tallerwebi.dominio.repositorios;

import com.tallerwebi.dominio.entidades.Libro;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RepositorioLibro {
    List<Libro> listarLibros();
    Libro buscarPorId(Long id);
    void guardar(Libro libro);
}