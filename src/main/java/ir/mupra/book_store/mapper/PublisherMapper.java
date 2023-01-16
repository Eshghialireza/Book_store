package ir.mupra.book_store.mapper;

import ir.mupra.book_store.models.Publisher;
import ir.mupra.book_store.payload.publisher.PublisherRequest;
import ir.mupra.book_store.payload.publisher.PublisherResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface PublisherMapper {
    Publisher publisherPayloadToPublisher(PublisherRequest publisherRequest);

    List<PublisherResponse> authorsToAuthorsResponse(List<Publisher> publishers);
}
