package com.tallerwebi.infraestructura.serviciosimpl;

import com.tallerwebi.dominio.entidades.Libro;
import com.tallerwebi.dominio.repositorios.RepositorioLibro;

import com.tallerwebi.dominio.servicios.ServicioLibro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service("servicioLibro")
@Transactional
public class ServicioLibroImpl implements ServicioLibro {
    private RepositorioLibro repositorioLibro;

    @Autowired
    public ServicioLibroImpl(RepositorioLibro repositorioLibro) {
        this.repositorioLibro = repositorioLibro;
    }

    @Override
    public List<Libro> buscarTodos() {
        return List.of();
    }

    @Override
    public List<Libro> listarLibros() {
        return repositorioLibro.listarLibros();
    }

    @Override
    public Libro buscarPorId(Long id) {
        return repositorioLibro.buscarPorId(id);
    }

    @Override
    public Libro guardar(Libro libro) {
        return null;
    }

    @Override
    public void eliminar(Long id) {

    }
}
