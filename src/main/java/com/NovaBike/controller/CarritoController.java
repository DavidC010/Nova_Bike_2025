package com.NovaBike.controller;

import com.NovaBike.domain.Producto;
import com.NovaBike.service.ProductoService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/carrito")
@SessionAttributes("carrito")
public class CarritoController {

    @Autowired
    private ProductoService productoService;

    //  Si no existe el carrito, se crea uno nuevo
    @ModelAttribute("carrito")
    public List<Producto> inicializarCarrito() {
        return new ArrayList<>();
    }

    //  Agregar producto al carrito
    @GetMapping("/agregar/{id}")
    public String agregarAlCarrito(@PathVariable("id") Long id,
                                   @ModelAttribute("carrito") List<Producto> carrito) {

        Producto producto = productoService.getProducto(id.intValue());
        if (producto != null) {
            // ️ Evita duplicados comparando por ID, no por equals()
            boolean yaExiste = carrito.stream().anyMatch(p -> p.getId().equals(producto.getId()));
            if (!yaExiste) {
                carrito.add(producto);
            }
        }
        return "redirect:/carrito/ver";
    }

    //  Mostrar carrito
   @GetMapping("/ver")
public String verCarrito(@ModelAttribute("carrito") List<Producto> carrito, Model model) {
    double total = carrito.stream()
        .mapToDouble(p -> {
            try {
                return Double.parseDouble(String.valueOf(p.getPrecio()));
            } catch (Exception e) {
                return 0.0;
            }
        })
        .sum();

    model.addAttribute("carrito", carrito);
    model.addAttribute("total", total);
    return "producto/pedidos";
}

    // Eliminar producto del carrito
    @GetMapping("/eliminar/{id}")
    public String eliminarDelCarrito(@PathVariable("id") Long id,
                                     @ModelAttribute("carrito") List<Producto> carrito) {

        //  Usar equals() con conversión a long por seguridad
        carrito.removeIf(p -> p.getId().longValue() == id.longValue());
        return "redirect:/carrito/ver";
    }
}
