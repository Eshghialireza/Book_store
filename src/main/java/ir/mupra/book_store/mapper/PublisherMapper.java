package ir.mupra.book_store.mapper;

import ir.mupra.book_store.models.Publisher;
import ir.mupra.book_store.payload.publisher.PublisherPayload;
import ir.mupra.book_store.payload.publisher.PublisherResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface PublisherMapper {
    Publisher publisherPayloadToPublisher(PublisherPayload publisherPayload);

    List<PublisherResponse> authorsToAuthorsResponse(List<Publisher> publishers);
}
