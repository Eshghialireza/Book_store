package ir.mupra.book_store.models;

import ir.mupra.book_store.models.base.BaseDomain;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
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
    @OneToMany(mappedBy = "publisher")
    private List<Book> books = new ArrayList<>();

}
