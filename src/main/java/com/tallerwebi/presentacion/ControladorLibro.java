package com.tallerwebi.presentacion;


import com.tallerwebi.dominio.servicios.ServicioLibro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorLibro {
    private ServicioLibro servicioLibro;

    @Autowired
    public ControladorLibro(ServicioLibro servicioLibro) {
        this.servicioLibro = servicioLibro;
    }

    @RequestMapping(path = "/libros", method = RequestMethod.GET)
    public ModelAndView listarLibros() {
        ModelMap model = new ModelMap();
        model.put("libros", servicioLibro.listarLibros());
        return new ModelAndView("libros/lista", model);
    }

    @RequestMapping(path = "/libro/{id}", method = RequestMethod.GET)
    public ModelAndView verLibro(@PathVariable Long id) {
        ModelMap model = new ModelMap();
        model.put("libro", servicioLibro.buscarPorId(id));
        return new ModelAndView("libros/detalle", model);
    }
}
