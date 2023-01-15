package ir.mupra.book_store.models;


import ir.mupra.book_store.models.base.BaseDomain;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseDomain<Long> {
    private String name;
    private String lastname;
    @Column(unique = true)
    private String username;
    private String password;
    @OneToMany(mappedBy = "user")
    private List<Book> books;
    @OneToMany(mappedBy = "user")
    private List<Publisher> publishers;
    @OneToMany(mappedBy = "user")
    private List<Author> authors;
}
