package ir.mupra.book_store.mapper;

import ir.mupra.book_store.models.Book;
import ir.mupra.book_store.payload.book.BookRequest;
import ir.mupra.book_store.payload.book.BookResponse;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PublisherMapper.class , AuthorMapper.class})
public interface BookMapper {
    Book bookRequestToBook(BookRequest bookRequest);

    List<BookResponse> bookToBookResponse(List<Book> bookList);
}
