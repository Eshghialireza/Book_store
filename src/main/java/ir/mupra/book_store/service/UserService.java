package ir.mupra.book_store.service;

import ir.mupra.book_store.models.User;
import ir.mupra.book_store.payload.user.UserSignIn;
import ir.mupra.book_store.payload.user.UserSignUp;
import ir.mupra.book_store.service.base.BaseService;
import jakarta.servlet.http.HttpSession;

public interface UserService extends BaseService<User, Long> {

    void addNewUser(UserSignUp userSignUp);

    void signIn(UserSignIn userSignIn, HttpSession session);

    User getUserFromSession();
}
