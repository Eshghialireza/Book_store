package ir.mupra.book_store.service.impl;

import ir.mupra.book_store.mapper.BookMapper;
import ir.mupra.book_store.models.Author;
import ir.mupra.book_store.models.Book;
import ir.mupra.book_store.models.Publisher;
import ir.mupra.book_store.payload.book.BookRequest;
import ir.mupra.book_store.payload.book.BookResponse;
import ir.mupra.book_store.repository.BookRepository;
import ir.mupra.book_store.service.AuthorService;
import ir.mupra.book_store.service.BookService;
import ir.mupra.book_store.service.PublisherService;
import ir.mupra.book_store.service.UserService;
import ir.mupra.book_store.service.base.impl.BaseServiceImpl;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl extends BaseServiceImpl<Book, Long, BookRepository> implements BookService {
    final BookMapper bookMapper;
    final AuthorService authorService;
    final PublisherService publisherService;
    final UserService userService;

    public BookServiceImpl(BookRepository repository, HttpSession session, BookMapper bookMapper, AuthorService authorService, PublisherService publisherService, UserService userService) {
        super(repository, session);
        this.bookMapper = bookMapper;
        this.authorService = authorService;
        this.publisherService = publisherService;
        this.userService = userService;
    }

    @Override
    public void addBook(BookRequest bookRequest, Long publisher_id, Long author_id) {
        checkUserSignedIn();
        Book book = bookMapper.bookRequestToBook(bookRequest);
        Author author = authorService.findById(author_id);
        Publisher publisher = publisherService.findById(publisher_id);
        book.setAuthor(author);
        book.setPublisher(publisher);
        book.setUser(userService.getUserFromSession());
        repository.save(book);
    }

    @Override
    public List<BookResponse> findUserBooks() {
        List<Book> books = repository.findByUser(userService.getUserFromSession());
        return bookMapper.bookToBookResponse(books);
    }
}
