package com.example.demo.Controller;

// Importamos el modelo (datos) y el repositorio (base de datos)
import com.example.demo.Model.Item;
import com.example.demo.Repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

// Indica que esta clase maneja peticiones HTTP y devuelve un archivo HTML
@Controller
public class ItemController {

    // Spring busca una instancia de ItemRepository y la conecta
    @Autowired
    private ItemRepository Repository;

    // Responde cuando el usuario entra al index
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("items", Repository.findAll());
        model.addAttribute("item", new Item());
        return "index";
    }

    @PostMapping("/agregar")
    public String agregar(@ModelAttribute Item item) {
        Repository.save(item);
        // Redirige de nuevo a la ruta principal para ver la lista actualizada
        return "redirect:/";
    }
}