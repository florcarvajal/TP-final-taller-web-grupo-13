package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.servicios.ServicioCarrito;
import com.tallerwebi.dominio.servicios.ServicioLibro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class ControladorCarrito {


    private final ServicioCarrito servicioCarrito;
    private final ServicioLibro servicioLibro;

    @Autowired
    public ControladorCarrito(ServicioCarrito servicioCarrito, ServicioLibro servicioLibro) {
        this.servicioCarrito = servicioCarrito;
        this.servicioLibro = servicioLibro;
    }

    @PostMapping("/agregar-al-carrito/{id}")
    public String agregarAlCarrito(@PathVariable("id") Long id, HttpSession session) {
        servicioCarrito.agregarLibroPorId(id, session, servicioLibro);
        return "redirect:/libros";
    }



    @RequestMapping("/carrito")
    public ModelAndView verCarrito(HttpSession session) {
        ModelMap model = new ModelMap();
        model.put("libros", servicioCarrito.obtenerLibros(session));
        model.put("total", servicioCarrito.obtenerTotal(session));
        return new ModelAndView("carrito", model);
    }

}


