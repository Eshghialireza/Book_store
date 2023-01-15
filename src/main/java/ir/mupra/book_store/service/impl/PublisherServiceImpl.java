package ir.mupra.book_store.service.impl;

import ir.mupra.book_store.mapper.PublisherMapper;
import ir.mupra.book_store.models.Publisher;
import ir.mupra.book_store.models.User;
import ir.mupra.book_store.payload.publisher.PublisherPayload;
import ir.mupra.book_store.repository.PublisherRepository;
import ir.mupra.book_store.service.PublisherService;
import ir.mupra.book_store.service.base.impl.BaseServiceImpl;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

@Service
public class PublisherServiceImpl extends BaseServiceImpl<Publisher, Long, PublisherRepository> implements PublisherService {
    final PublisherMapper publisherMapper;
    final HttpSession session;

    public PublisherServiceImpl(PublisherRepository repository, HttpSession session, PublisherMapper publisherMapper, HttpSession session1) {
        super(repository, session);
        this.publisherMapper = publisherMapper;
        this.session = session1;
    }


    @Override
    public void addPublisher(PublisherPayload publisherPayload) {
        checkUserSignedIn();
        Publisher publisher = publisherMapper.publisherPayloadToPublisher(publisherPayload);
        User user = (User) session.getAttribute("userDetails");
        publisher.setUser(user);
        repository.save(publisher);
    }
}
