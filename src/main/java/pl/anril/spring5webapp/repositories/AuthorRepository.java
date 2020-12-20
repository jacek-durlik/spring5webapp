package pl.anril.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.anril.spring5webapp.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
