package ir.mupra.book_store.service.impl;

import ir.mupra.book_store.exception.ApiDuplicateException;
import ir.mupra.book_store.mapper.UserMapper;
import ir.mupra.book_store.models.User;
import ir.mupra.book_store.payload.UserSignUp;
import ir.mupra.book_store.repository.UserRepository;
import ir.mupra.book_store.service.UserService;
import ir.mupra.book_store.service.base.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, Long, UserRepository> implements UserService {
    final UserMapper userMapper;

    public UserServiceImpl(UserRepository repository, UserMapper userMapper) {
        super(repository);
        this.userMapper = userMapper;
    }

    @Override
    public void addNewUser(UserSignUp userSignUp) {
        checkUserExist(userSignUp.getUsername());
        User user = userMapper.mapUserSignUpToUser(userSignUp);
        repository.save(user);
    }

    private void checkUserExist(String username) {
        Optional<User> user = repository.findByUsername(username);
        if (user.isPresent()) {
            throw new ApiDuplicateException("username exist");
        }
    }
}
