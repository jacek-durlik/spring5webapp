package pl.anril.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.anril.spring5webapp.model.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
