package br.com.dcc193.dcc193201901welton.controller;

import br.com.dcc193.dcc193201901welton.dao.AtividadeRepository;
import br.com.dcc193.dcc193201901welton.dao.MenbroRepository;
import br.com.dcc193.dcc193201901welton.dao.SedeRepository;
import br.com.dcc193.dcc193201901welton.model.Menbro;
import br.com.dcc193.dcc193201901welton.model.Sede;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class homeController {
    @Autowired
    SedeRepository sedeRepository;
    @Autowired
    MenbroRepository menbroRepository;
    @Autowired
    AtividadeRepository atividadeRepository;

    @RequestMapping("/")
    ModelAndView GetSede(Model model) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("listaSede", sedeRepository.findAll());
        mv.setViewName("home");
        return mv;
    }

    @RequestMapping("cadastrarSede")
    String PostrSede(Sede sede) {
        sedeRepository.save(sede);
        return "redirect:/";
    }

    @RequestMapping("alterarSede")
    String UpdateSede(Long idSede, Sede sede) {
        sede.setId(idSede);
        sedeRepository.save(sede);
        return "redirect:/";
    }

    @RequestMapping("deletarSede")
    String DeleteSede(Long id) {
        sedeRepository.deleteById(id);
        return "redirect:/";
    }

    @RequestMapping("verMenbros")
    ModelAndView GetMembro(Long idSede, Model model) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("listaMenbro", menbroRepository.findBySede(sedeRepository.findById(idSede).get()));
        mv.addObject("idSede", idSede);
        mv.setViewName("membro");
        return mv;
    }

    @RequestMapping("cadastrarMenbro")
    String PostMenbro(Long idSede, Menbro menbro) {
        menbro.setSede(sedeRepository.findById(idSede).get());
        menbroRepository.save(menbro);
        return "redirect:verMenbros?idSede=" + idSede;
    }

    @RequestMapping("deletarMenbro")
    String DeletarMenbro(Long idSede, Long idMenbro) {
        menbroRepository.deleteById(idMenbro);
        return "redirect:verMenbros?idSede=" + idSede;
    }

    @RequestMapping("alterarMenbro")
    String UpdateMenbro(Long idSede, Long idMenbro, Menbro menbro) {
        menbro.setId(idMenbro);
        menbro.setSede(sedeRepository.findById(idSede).get());
        menbroRepository.save(menbro);
        return "redirect:verMenbros?idSede=" + idSede;
    }
}
