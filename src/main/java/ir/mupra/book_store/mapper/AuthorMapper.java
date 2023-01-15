package ir.mupra.book_store.mapper;

import ir.mupra.book_store.models.Author;
import ir.mupra.book_store.payload.author.AuthorPayload;
import org.mapstruct.Mapper;

@Mapper
public interface AuthorMapper {
    Author authorPayloadToAuthor(AuthorPayload authorPayload);
}
