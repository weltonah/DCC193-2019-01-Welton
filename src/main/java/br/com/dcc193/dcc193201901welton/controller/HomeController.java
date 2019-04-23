package br.com.dcc193.dcc193201901welton.controller;

import br.com.dcc193.dcc193201901welton.dao.AtividadeRepository;
import br.com.dcc193.dcc193201901welton.dao.MenbroRepository;
import br.com.dcc193.dcc193201901welton.dao.SedeRepository;
import br.com.dcc193.dcc193201901welton.model.Atividade;
import br.com.dcc193.dcc193201901welton.model.Menbro;
import br.com.dcc193.dcc193201901welton.model.Sede;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Comparator;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    SedeRepository sedeRepository;
    @Autowired
    MenbroRepository menbroRepository;
    @Autowired
    AtividadeRepository atividadeRepository;

    @RequestMapping("/")
    String Home(Model model) {
        List<Sede> resultOrdenado = sedeRepository.findAll();
        resultOrdenado.sort(Comparator.comparing(Sede::getHorasTotais));
        model.addAttribute("listaSede", resultOrdenado);
        return "home";
    }

    @RequestMapping("PostSede")
    String PostSede(Sede sede) {
        sedeRepository.save(sede);
        return "redirect:/";
    }

    @RequestMapping("UpdateSede")
    String UpdateSede(Long idSede, Sede sede) {
        sede.setId(idSede);
        sedeRepository.save(sede);
        return "redirect:/";
    }

    @RequestMapping("DeleteSede")
    String DeleteSede(Long id) {
        Sede sede = sedeRepository.findById(id).get();
        for (Menbro menbro : sede.getMenbro()) {
            menbroRepository.deleteById(menbro.getId());
        }
        for (Atividade atividade : sede.getAtividades()) {
            atividadeRepository.deleteById(atividade.getId());
        }
        sedeRepository.deleteById(id);
        return "redirect:/";
    }
}
