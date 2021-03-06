package br.com.vtorres.spring5webapp.bootstrap;

import br.com.vtorres.spring5webapp.model.Author;
import br.com.vtorres.spring5webapp.model.Book;
import br.com.vtorres.spring5webapp.model.Publisher;
import br.com.vtorres.spring5webapp.repositories.AuthorRepository;
import br.com.vtorres.spring5webapp.repositories.BookRepository;
import br.com.vtorres.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{

    private PublisherRepository publisherRepository;
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    //por apontar que essa classe esta sendo gerenciada pelo spring
    //e ela tem essas dependencias, ela ira injetar os objetos criados
    //atraves de casa um dos contrutores
    public DevBootstrap(PublisherRepository publisherRepository, AuthorRepository authorRepository, BookRepository bookRepository) {
        this.publisherRepository = publisherRepository;
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    private void initData(){
        Publisher p1 = new Publisher("Publisher 1", "Street 1");
        Author a1 = new Author("Primeiro Nome", "Ultimo Nome");
        Book b1 = new Book("Titulo 1", "ISBN-11111", p1);
        a1.getBooks().add(b1);
        b1.getAuthors().add(a1);
        this.publisherRepository.save(p1);
        this.authorRepository.save(a1);
        this.bookRepository.save(b1);

        Publisher p2 = new Publisher("Publisher 2", "Street 2");
        Author a2 = new Author("Primeiro Nome Outro", "Ultimo Nome Outro");
        Book b2 = new Book("Titulo 2", "ISBN-22222", p2);
        a2.getBooks().add(b2);
        this.publisherRepository.save(p2);
        this.authorRepository.save(a2);
        this.bookRepository.save(b2);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
}
