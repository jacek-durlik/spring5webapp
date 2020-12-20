package pl.anril.spring5webapp.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Include
    private Long id;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @ManyToMany(mappedBy = "authors")
    private Set<Book> books = new HashSet<>();
}
