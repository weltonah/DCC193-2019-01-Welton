package br.com.dcc193.dcc193201901welton.controller;

import br.com.dcc193.dcc193201901welton.dao.SedeRepository;
import br.com.dcc193.dcc193201901welton.model.Sede;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class homeController {
    @Autowired
    SedeRepository sedeRepository;

    @RequestMapping("/")
    String home(Model model){
        model.addAttribute("listaSede", sedeRepository.findAll());
        return "home";
    }
    @RequestMapping("/cadastrarSede")
    String cadastrarSede(Sede sede){
        sedeRepository.save(sede);
        return "redirect:/";
    }
    @RequestMapping("/alterarSede")
    String alterarSede(Sede sede){
        sedeRepository.save(sede);
        return "redirect:/";
    }
    @RequestMapping("deletarSede/{id}")
    String deletarSede(@PathVariable("id") Long id){
        sedeRepository.deleteById(id);
        return "redirect:/";
    }
}
