package ir.mupra.book_store.mapper;

import ir.mupra.book_store.models.Author;
import ir.mupra.book_store.payload.author.AuthorRequest;
import ir.mupra.book_store.payload.author.AuthorResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface AuthorMapper {
    Author authorPayloadToAuthor(AuthorRequest authorRequest);

    List<AuthorResponse> authorsToAuthorsResponse(List<Author> authors);
}
