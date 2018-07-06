package br.com.vtorres.spring5webapp.controllers;

import br.com.vtorres.spring5webapp.repositories.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//indico para o spring que essa classe deve ser tratata como um controller
//e ele se tornou um spring bean
@Controller
public class AuthorController {

    private AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    //isso serve para mapear o path que sera chamado para acessar
    //esse metodo
    @RequestMapping("/authors")
    public String getAuthors(Model model){
        //nome do atributo mapeado no arquivo html
        model.addAttribute("authors", this.authorRepository.findAll());

        //nome do arquivo html
        return "authors";
    }
}
