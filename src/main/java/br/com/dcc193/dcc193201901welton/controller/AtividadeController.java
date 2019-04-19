package br.com.dcc193.dcc193201901welton.controller;

import br.com.dcc193.dcc193201901welton.dao.AtividadeRepository;
import br.com.dcc193.dcc193201901welton.dao.SedeRepository;
import br.com.dcc193.dcc193201901welton.model.Atividade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AtividadeController {


    @Autowired
    SedeRepository sedeRepository;
    @Autowired
    AtividadeRepository atividadeRepository;

    @RequestMapping("GetAtividade")
    String GetAtividade(Long idSede, Model model) {
        ModelAndView mv = new ModelAndView();
        model.addAttribute("listaAtividade", atividadeRepository.findBySede(sedeRepository.findById(idSede).get()));
        model.addAttribute("idSede", idSede);
        return "atividade";
    }

    @RequestMapping("PostAtividade")
    String PostAtividade(Long idSede, Atividade atividade) {
        atividade.setSede(sedeRepository.findById(idSede).get());
        atividadeRepository.save(atividade);
        return "redirect:GetAtividade?idSede=" + idSede;
    }

    @RequestMapping("DeleteAtividade")
    String DeleteAtividade(Long idSede, Long idAtividade) {
        atividadeRepository.deleteById(idAtividade);
        return "redirect:GetAtividade?idSede=" + idSede;
    }

    @RequestMapping("UpdateAtividade")
    String UpdateAtividade(Long idSede, Long idAtividade, Atividade atividade) {
        atividade.setId(idAtividade);
        atividade.setSede(sedeRepository.findById(idSede).get());
        atividadeRepository.save(atividade);
        return "redirect:GetAtividade?idSede=" + idSede;
    }
}
