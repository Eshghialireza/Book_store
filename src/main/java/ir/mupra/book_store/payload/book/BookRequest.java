package ir.mupra.book_store.payload.book;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookRequest {
    private String name;
    private Integer quantity;
    private Integer price;
}
