package com.tallerwebi.infraestructura.repositoriosimpl;

import com.tallerwebi.dominio.entidades.Libro;
import com.tallerwebi.dominio.repositorios.RepositorioLibro;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("repositorioLibro")
public class RepositorioLibroImpl implements RepositorioLibro {
    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioLibroImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Libro> listarLibros() {
        return sessionFactory.getCurrentSession().createQuery("from Libro", Libro.class).list();
    }

    @Override
    public Libro buscarPorId(Long id) {
        return sessionFactory.getCurrentSession().get(Libro.class, id);
    }

    @Override
    public void guardar(Libro libro) {
        sessionFactory.getCurrentSession().save(libro);
    }
}
