package ir.mupra.book_store.controller;

import ir.mupra.book_store.payload.UserSignUp;
import ir.mupra.book_store.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody UserSignUp userSignUp) {
        userService.addNewUser(userSignUp);
        return ResponseEntity.ok("user created successfully");
    }
}
