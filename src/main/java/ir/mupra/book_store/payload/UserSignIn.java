package ir.mupra.book_store.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSignIn {
    private String username;
    private String password;
}
