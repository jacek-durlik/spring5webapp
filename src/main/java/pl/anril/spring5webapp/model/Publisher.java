package pl.anril.spring5webapp.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@RequiredArgsConstructor
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Include
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String addressLine1;

    @NonNull
    private String city;

    @NonNull
    private String state;

    @NonNull
    private String zipcode;

    @OneToMany
    @JoinColumn(name = "publisher_id")
    @ToString.Exclude
    private Set<Book> books = new HashSet<>();
}
