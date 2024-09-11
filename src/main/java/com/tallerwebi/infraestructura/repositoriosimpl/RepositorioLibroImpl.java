package com.tallerwebi.infraestructura.repositoriosimpl;

import com.tallerwebi.dominio.entidades.Libro;
import com.tallerwebi.dominio.repositorios.RepositorioLibro;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("repositorioLibro")
public class RepositorioLibroImpl implements RepositorioLibro {

    private final SessionFactory sessionFactory;

    @Autowired
    public RepositorioLibroImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Libro buscarLibroPorId(Long id) {
        final Session session = sessionFactory.getCurrentSession();
        return (Libro) session.createCriteria(Libro.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
    }

    @Override
    public Libro guardar(Libro libro) {
        sessionFactory.getCurrentSession().save(libro);
        return libro;
    }

    @Override
    public void modificar(Libro libro) {
        sessionFactory.getCurrentSession().update(libro);
    }

    @Override
    public void eliminar(Long id) {
        final Session session = sessionFactory.getCurrentSession();
        Libro libro = (Libro) session.createCriteria(Libro.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
        if (libro != null) {
            session.delete(libro);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Libro> buscarTodos() {
        return sessionFactory.getCurrentSession().createCriteria(Libro.class).list();
    }
}