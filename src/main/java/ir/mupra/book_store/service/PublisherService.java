package ir.mupra.book_store.service;

import ir.mupra.book_store.models.Publisher;
import ir.mupra.book_store.payload.publisher.PublisherPayload;
import ir.mupra.book_store.service.base.BaseService;

public interface PublisherService extends BaseService<Publisher, Long> {
    void addPublisher(PublisherPayload publisherPayload);
}
