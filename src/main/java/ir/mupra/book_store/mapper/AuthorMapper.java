package ir.mupra.book_store.mapper;

import ir.mupra.book_store.models.Author;
import ir.mupra.book_store.payload.author.AuthorRequest;
import ir.mupra.book_store.payload.author.AuthorResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
    Author authorPayloadToAuthor(AuthorRequest authorRequest);

    List<AuthorResponse> authorsToAuthorsResponse(List<Author> authors);

    static AuthorResponse authorToAuthorResponse(Author author) {
        if (author == null) {
            return null;
        }
        AuthorResponse authorResponse = new AuthorResponse();
        authorResponse.setName(author.getName());
        authorResponse.setBirthDay(author.getBirthDay());
        authorResponse.setId(author.getId());
        return authorResponse;
    }
}
