package ir.mupra.book_store.payload.book;

import ir.mupra.book_store.payload.author.AuthorResponse;
import ir.mupra.book_store.payload.publisher.PublisherResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookResponse {
    private String name;
    private Integer quantity;
    private Integer price;
    private AuthorResponse author;
    private PublisherResponse publisher;
}
