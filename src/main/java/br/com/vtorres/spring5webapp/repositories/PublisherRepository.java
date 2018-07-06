package br.com.vtorres.spring5webapp.repositories;

import br.com.vtorres.spring5webapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
