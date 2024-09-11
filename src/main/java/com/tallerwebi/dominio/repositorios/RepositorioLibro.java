package com.tallerwebi.dominio.repositorios;

import com.tallerwebi.dominio.entidades.Libro;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioLibro {
    Libro buscarLibroPorId(Long id);

    Libro guardar(Libro libro);

    void modificar(Libro libro);

    void eliminar(Long id);

    @SuppressWarnings("unchecked")
    List<Libro> buscarTodos();
}
