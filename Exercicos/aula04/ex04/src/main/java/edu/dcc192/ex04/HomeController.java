package edu.dcc192.ex04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @Autowired
    private GeradorSenha senha;

    @GetMapping("/")
    public ModelAndView home1(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login");
        mv.addObject("senha", senha.GerarSenha()); 
        return mv;
    }

    @Autowired
    private Dados dados;
    @GetMapping("/menu")
    public ModelAndView home2(@RequestParam("nome") String nome){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("menu");
        mv.addObject("dados", dados.pegaDados());
        mv.addObject("nome", nome);
        return mv;
    }
    

}
