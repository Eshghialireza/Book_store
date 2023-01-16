package ir.mupra.book_store.payload.author;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class AuthorResponse {
    private Long Id;
    private String name;
    private Date birthDay;
}
