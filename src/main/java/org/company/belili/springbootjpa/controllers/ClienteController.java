package org.company.belili.springbootjpa.controllers;

import org.company.belili.springbootjpa.models.entity.Cliente;
import org.company.belili.springbootjpa.models.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;
import java.util.Map;

@Controller
//TODO --> Identify anotation Spring
@SessionAttributes("cliente")
public class ClienteController {

    @Autowired
    @Qualifier("clienteDaoJPA")
    private IClienteService iClienteService;

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public String listar(Model model) {
        model.addAttribute("titulo", "Listado de Clientes");
        model.addAttribute("clientes", iClienteService.findAll());
        return "listar";
    }

    @GetMapping("/form")
    public String crear(Map<String, Object> model) {
        Cliente cliente = new Cliente();
        model.put("cliente", cliente);
        model.put("titulo", "Formulario del Cliente");
        return "form";
    }

    @RequestMapping(value = "/form/{id}")
    public String editar(@PathVariable(value = "id") Long id, Map<String, Object> model) {
        Cliente cliente = null;

        if (id > 0) {
            cliente = iClienteService.findOne(id);
        } else {
            return "redirect:listar";
        }
        model.put("cliente", cliente);
        model.put("titulo", "Formulario del Cliente");
        return "form";
    }

    @PostMapping("/form")
    public String guardar(@Valid Cliente cliente, BindingResult bindingResult, Model model, SessionStatus status) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("titulo", "Formulario del Cliente");
            return "form";
        }
        iClienteService.save(cliente);
        status.setComplete();
        return "redirect:/listar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") Long id) {
        if (id > 0) {
            iClienteService.delete(id);
        }
        return "redirect:/listar";
    }

}
