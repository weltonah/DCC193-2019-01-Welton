package br.com.dcc193.dcc193201901welton.controller;

import br.com.dcc193.dcc193201901welton.dao.MenbroRepository;
import br.com.dcc193.dcc193201901welton.dao.SedeRepository;
import br.com.dcc193.dcc193201901welton.model.Menbro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class MenbroController {


    @Autowired
    SedeRepository sedeRepository;
    @Autowired
    MenbroRepository menbroRepository;

    @RequestMapping("GetMenbro")
    String GetMenbro(Long idSede, Model model) {
        model.addAttribute("listaMenbro", menbroRepository.findByRefSede(sedeRepository.findById(idSede).get()));
        model.addAttribute("idSede", idSede);
        return "menbro";
    }

    @RequestMapping("PostMenbro")
    String PostMenbro(Long idSede, Menbro
            menbro) {
        menbro.setRefSede(sedeRepository.findById(idSede).get());
        menbroRepository.save(menbro);
        return "redirect:GetMenbro?idSede=" + idSede;
    }

    @RequestMapping("DeleteMenbro")
    String DeleteMenbro(Long idSede, Long idMenbro) {
        menbroRepository.deleteById(idMenbro);
        return "redirect:GetMenbro?idSede=" + idSede;
    }

    @RequestMapping("UpdateMenbro")
    String UpdateMenbro(Long idSede, Long idMenbro, Menbro menbro) {
        menbro.setId(idMenbro);
        menbro.setRefSede(sedeRepository.findById(idSede).get());
        menbroRepository.save(menbro);
        return "redirect:GetMenbro?idSede=" + idSede;
    }
}
