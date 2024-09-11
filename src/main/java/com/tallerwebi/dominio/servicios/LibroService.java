package com.tallerwebi.dominio.servicios;

import com.tallerwebi.dominio.entidades.Libro;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LibroService {

    List<Libro> buscarTodos();

    Libro buscarPorId(Long id);

    Libro guardar(Libro libro);

    void eliminar(Long id);
}
