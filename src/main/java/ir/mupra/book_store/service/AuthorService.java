package ir.mupra.book_store.service;

import ir.mupra.book_store.models.Author;
import ir.mupra.book_store.payload.author.AuthorPayload;
import ir.mupra.book_store.service.base.BaseService;

public interface AuthorService extends BaseService<Author, Long> {
    void addAuthor(AuthorPayload authorPayload);
}
