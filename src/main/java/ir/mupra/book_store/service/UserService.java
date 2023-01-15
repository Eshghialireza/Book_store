package ir.mupra.book_store.service;

import ir.mupra.book_store.models.User;
import ir.mupra.book_store.payload.UserSignUp;
import ir.mupra.book_store.service.base.BaseService;

public interface UserService extends BaseService<User, Long> {

    void addNewUser(UserSignUp userSignUp);
}
