package ir.mupra.book_store.models;

import ir.mupra.book_store.models.base.BaseDomain;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book extends BaseDomain<Long> {
    private String name;
    private Integer quantity;
    private Integer price;
    @ManyToOne
    private User user;
    @ManyToOne
    private Publisher publisher;
    @ManyToOne
    private Author author;
}
