package br.com.vtorres.spring5webapp.repositories;

import br.com.vtorres.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
