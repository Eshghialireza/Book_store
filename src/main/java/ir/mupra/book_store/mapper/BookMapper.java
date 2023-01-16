package ir.mupra.book_store.mapper;

import ir.mupra.book_store.models.Book;
import ir.mupra.book_store.payload.book.BookRequest;
import org.mapstruct.Mapper;

@Mapper
public interface BookMapper {
    Book bookRequestToBook(BookRequest bookRequest);
}
