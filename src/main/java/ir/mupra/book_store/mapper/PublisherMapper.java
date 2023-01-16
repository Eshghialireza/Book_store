package ir.mupra.book_store.mapper;

import ir.mupra.book_store.models.Publisher;
import ir.mupra.book_store.payload.publisher.PublisherRequest;
import ir.mupra.book_store.payload.publisher.PublisherResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PublisherMapper {
    Publisher publisherPayloadToPublisher(PublisherRequest publisherRequest);

    List<PublisherResponse> authorsToAuthorsResponse(List<Publisher> publishers);

    static PublisherResponse publisherToPublisherResponse(Publisher publisher) {
        if (publisher == null) {
            return null;
        }
        PublisherResponse publisherResponse = new PublisherResponse();
        publisherResponse.setAddress(publisher.getAddress());
        publisherResponse.setName(publisher.getName());
        publisherResponse.setEstablishmentDate(publisher.getEstablishmentDate());
        publisherResponse.setId(publisher.getId());
        return publisherResponse;
    }
}
