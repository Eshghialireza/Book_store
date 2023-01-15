package ir.mupra.book_store.models;

import ir.mupra.book_store.models.base.BaseDomain;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Publisher extends BaseDomain<Long> {
    private String name;
    private String address;
    private Date establishmentDate;
    @ManyToOne
    private User user;
    @ManyToMany
    private List<Book> books;
}
