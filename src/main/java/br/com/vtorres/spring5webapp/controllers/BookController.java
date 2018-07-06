package br.com.vtorres.spring5webapp.controllers;

import br.com.vtorres.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//indico para o spring que essa classe deve ser tratata como um controller
//e ele se tornou um spring bean
@Controller
public class BookController {

    private BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    //isso serve para mapear o path que sera chamado para acessar
    //esse metodo
    @RequestMapping("/books")
    public String getBooks(Model model){
        model.addAttribute("books", this.bookRepository.findAll());

        return "books";
    }
}
