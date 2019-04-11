package br.com.dcc193.dcc193201901welton.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class homeController {
    @RequestMapping("/")
    String home(){
        return "home";
    }
}
