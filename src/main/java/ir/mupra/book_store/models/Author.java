package ir.mupra.book_store.models;

import ir.mupra.book_store.models.base.BaseDomain;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Author extends BaseDomain<Long> {
    private String name;
    private Date birthDay;

    @ManyToOne
    private User user;
    @OneToMany(mappedBy = "author")
    private List<Book> books = new ArrayList<>();
}
