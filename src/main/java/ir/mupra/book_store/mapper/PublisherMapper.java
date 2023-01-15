package ir.mupra.book_store.mapper;

import ir.mupra.book_store.models.Publisher;
import ir.mupra.book_store.payload.publisher.PublisherPayload;
import org.mapstruct.Mapper;

@Mapper
public interface PublisherMapper {
    Publisher publisherPayloadToPublisher(PublisherPayload publisherPayload);
}
