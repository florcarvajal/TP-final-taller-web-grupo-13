package com.tallerwebi.infraestructura.serviciosimpl;

import com.tallerwebi.dominio.entidades.Libro;
import com.tallerwebi.dominio.repositorios.RepositorioLibro;
import com.tallerwebi.dominio.servicios.LibroService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("libroService")
public class LibroServiceImpl implements LibroService {

    private final RepositorioLibro repositorioLibro;

    public LibroServiceImpl(RepositorioLibro repositorioLibro) {
        this.repositorioLibro = repositorioLibro;
    }

    @Override
    public List<Libro> buscarTodos() {
        return repositorioLibro.buscarTodos();
    }

    @Override
    public Libro buscarPorId(Long id) {
        return repositorioLibro.buscarLibroPorId(id).orElseThrow(() ->
                new ResourceNotFoundException("Book not found with id: " + id));
    }

    @Override
    public Libro guardar(Libro libro) {
        return repositorioLibro.guardar(libro);
    }

    @Override
    public void eliminar(Long id) {
        repositorioLibro.eliminar(id);
    }
}
