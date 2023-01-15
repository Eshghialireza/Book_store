package ir.mupra.book_store.controller;

import ir.mupra.book_store.payload.author.AuthorPayload;
import ir.mupra.book_store.payload.author.AuthorResponse;
import ir.mupra.book_store.payload.publisher.PublisherPayload;
import ir.mupra.book_store.payload.publisher.PublisherResponse;
import ir.mupra.book_store.payload.user.UserSignIn;
import ir.mupra.book_store.payload.user.UserSignUp;
import ir.mupra.book_store.service.AuthorService;
import ir.mupra.book_store.service.PublisherService;
import ir.mupra.book_store.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    final UserService userService;
    final AuthorService authorService;
    final PublisherService publisherService;
    final HttpSession session;

    public UserController(UserService userService, AuthorService authorService, PublisherService publisherService, HttpSession session) {
        this.userService = userService;
        this.authorService = authorService;
        this.publisherService = publisherService;
        this.session = session;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody UserSignUp userSignUp) {
        userService.addNewUser(userSignUp);
        return ResponseEntity.ok("user created successfully");
    }

    @PostMapping("/sign-in")
    public ResponseEntity<?> signIn(@RequestBody UserSignIn userSignIn) {
        userService.signIn(userSignIn, session);
        return ResponseEntity.ok("welcome");
    }

    @PostMapping("/add-author")
    public ResponseEntity<?> addAuthor(@RequestBody AuthorPayload authorPayload) {
        authorService.addAuthor(authorPayload);
        return ResponseEntity.ok("author added");
    }

    @PostMapping("/add-publisher")
    public ResponseEntity<?> addPublisher(@RequestBody PublisherPayload publisherPayload) {
        publisherService.addPublisher(publisherPayload);
        return ResponseEntity.ok("publisher added");
    }

    @GetMapping("/logout")
    public ResponseEntity<?> logout() {
        session.removeAttribute("userDetails");
        return ResponseEntity.ok("logged out");
    }

    // using this api to find authors that added by a user to add to another book.
    @GetMapping("/user-authors")
    public ResponseEntity<List<AuthorResponse>> findAuthors() {
        List<AuthorResponse> authorResponses = authorService.findAuthorByUser();
        return new ResponseEntity<>(authorResponses, HttpStatus.ACCEPTED);
    }
    @GetMapping("/user-publishers")
    public ResponseEntity<List<PublisherResponse>> findPublishers() {
        List<PublisherResponse> publisherResponses = publisherService.findPublishersByUser();
        return new ResponseEntity<>(publisherResponses, HttpStatus.ACCEPTED);
    }
}
