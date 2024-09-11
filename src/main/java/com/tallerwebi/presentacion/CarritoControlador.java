package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.entidades.Carrito;
import com.tallerwebi.dominio.entidades.Libro;
import com.tallerwebi.dominio.servicios.CarritoService;
import com.tallerwebi.dominio.servicios.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class CarritoControlador {

    private CarritoService carritoService;
    private final LibroService libroService;

    @Autowired
    public CarritoControlador(CarritoService carritoService, LibroService libroService) {
        this.carritoService = carritoService;
        this.libroService = libroService;
    }

    @PostMapping("/agregar/{id}")
    public String agregarLibroAlCarrito(@PathVariable Long id, HttpSession session) {
        Libro libro = libroService.buscarPorId(id);
        if (libro != null) {
            Carrito carrito = (Carrito) session.getAttribute("carrito");
            if (carrito == null) {
                carrito = new Carrito();
                session.setAttribute("carrito", carrito);
            }
            carrito.agregarLibro(libro);
        }
        return "redirect:/carrito"; // Redirige al carrito después de agregar el libro
    }


}
