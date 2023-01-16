package ir.mupra.book_store.service;

import ir.mupra.book_store.models.Book;
import ir.mupra.book_store.payload.book.BookRequest;
import ir.mupra.book_store.service.base.BaseService;

public interface BookService extends BaseService<Book, Long> {


    void addBook(BookRequest bookRequest, Long publisher_id, Long author_id);
}
