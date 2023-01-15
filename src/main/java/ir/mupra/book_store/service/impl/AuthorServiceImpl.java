package ir.mupra.book_store.service.impl;

import ir.mupra.book_store.mapper.AuthorMapper;
import ir.mupra.book_store.models.Author;
import ir.mupra.book_store.models.User;
import ir.mupra.book_store.payload.author.AuthorPayload;
import ir.mupra.book_store.repository.AuthorRepository;
import ir.mupra.book_store.service.AuthorService;
import ir.mupra.book_store.service.base.impl.BaseServiceImpl;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class AuthorServiceImpl extends BaseServiceImpl<Author, Long, AuthorRepository> implements AuthorService {


    final AuthorMapper authorMapper;
    final HttpSession session;

    public AuthorServiceImpl(AuthorRepository repository, HttpSession session, AuthorMapper authorMapper, HttpSession session1) {
        super(repository, session);
        this.authorMapper = authorMapper;
        this.session = session1;
    }

    @Override
    public void addAuthor(AuthorPayload authorPayload) {
        checkUserSignedIn();
        Author author = authorMapper.authorPayloadToAuthor(authorPayload);
        User user = (User) session.getAttribute("userDetails");
        author.setUser(user);
        repository.save(author);
    }
}
