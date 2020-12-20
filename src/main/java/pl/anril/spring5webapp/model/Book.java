package pl.anril.spring5webapp.model;

import lombok.*;

import javax.persistence.*;
import java.security.PublicKey;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Book {
    @NonNull
    private String title;
    @NonNull
    private String isbn;
    @ManyToMany
    @JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "author_id"))
    @ToString.Exclude
    private Set<Author> authors = new HashSet<>();
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Include
    private Long id;

    @ManyToOne
    private Publisher publisher;
}
