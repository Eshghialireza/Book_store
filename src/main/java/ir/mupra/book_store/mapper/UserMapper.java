package ir.mupra.book_store.mapper;

import ir.mupra.book_store.models.User;
import ir.mupra.book_store.payload.user.UserSignUp;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    User mapUserSignUpToUser(UserSignUp userSignUp);
}
