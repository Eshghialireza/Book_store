package ir.mupra.book_store.service.impl;

import ir.mupra.book_store.mapper.AuthorMapper;
import ir.mupra.book_store.models.Author;
import ir.mupra.book_store.models.User;
import ir.mupra.book_store.payload.author.AuthorPayload;
import ir.mupra.book_store.payload.author.AuthorResponse;
import ir.mupra.book_store.repository.AuthorRepository;
import ir.mupra.book_store.service.AuthorService;
import ir.mupra.book_store.service.UserService;
import ir.mupra.book_store.service.base.impl.BaseServiceImpl;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl extends BaseServiceImpl<Author, Long, AuthorRepository> implements AuthorService {


    final AuthorMapper authorMapper;
    final UserService userService;

    public AuthorServiceImpl(AuthorRepository repository, HttpSession session, AuthorMapper authorMapper, UserService userService) {
        super(repository, session);
        this.authorMapper = authorMapper;
        this.userService = userService;
    }


    @Override
    public void addAuthor(AuthorPayload authorPayload) {
        checkUserSignedIn();
        Author author = authorMapper.authorPayloadToAuthor(authorPayload);
        User user = userService.getUserFromSession();
        author.setUser(user);
        repository.save(author);
    }

    @Override
    public List<AuthorResponse> findAuthorByUser() {
        checkUserSignedIn();
        User user = userService.getUserFromSession();
        List<AuthorResponse> authors = authorMapper.authorsToAuthorsResponse(repository.findByUser(user));
        return authors;
    }
}
