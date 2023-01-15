package ir.mupra.book_store.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSignUp {
    private String name;
    private String lastname;
    private String username;
    private String password;
}
