package pl.anril.spring5webapp.bootstrap;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.anril.spring5webapp.model.Author;
import pl.anril.spring5webapp.model.Book;
import pl.anril.spring5webapp.model.Publisher;
import pl.anril.spring5webapp.repositories.AuthorRepository;
import pl.anril.spring5webapp.repositories.BookRepository;
import pl.anril.spring5webapp.repositories.PublisherRepository;

@Component
@RequiredArgsConstructor
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    @Override
    public void run(String... args) throws Exception {
        Publisher publisher = new Publisher();
        publisher.setName("SFG publishing");
        publisher.setCity("St Petersburg");
        publisher.setState("FL");
        publisherRepository.save(publisher);

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        publisher.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(publisher);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2ee Development without EJB", "76785765");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        publisher.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(publisher);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of books: "+bookRepository.count());
        System.out.println("Number of authors: "+authorRepository.count());
        System.out.println("Publisher number of books: "+publisher.getBooks().size());
    }
}
