package ir.mupra.book_store.payload.publisher;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PublisherRequest {
    private String name;
    private String address;
    private Date establishmentDate;
}
