package com.tallerwebi.dominio.servicios;

import com.tallerwebi.dominio.entidades.Carrito;
import com.tallerwebi.dominio.entidades.Libro;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class ServicioCarrito {
    private static final String CARRITO_SESSION_KEY = "carrito";
    private Carrito carrito;
    private ServicioLibro servicioLibro;

    public ServicioCarrito() {
        this.carrito = new Carrito();

    }
    public void agregarLibroPorId(Long id, HttpSession session, ServicioLibro servicioLibro) {
        Carrito carrito = obtenerCarrito(session);
        Libro libro = servicioLibro.buscarPorId(id);
        if (libro != null) {
            carrito.agregarLibro(libro);
        }
    }

    public List<Libro> obtenerLibros(HttpSession session) {
        return obtenerCarrito(session).getLibros();
    }

    public double obtenerTotal(HttpSession session) {
        return obtenerCarrito(session).total();
    }

    private Carrito obtenerCarrito(HttpSession session) {
        Carrito carrito = (Carrito) session.getAttribute(CARRITO_SESSION_KEY);
        if (carrito == null) {
            carrito = new Carrito();
            session.setAttribute(CARRITO_SESSION_KEY, carrito);
        }
        return carrito;
    }
}