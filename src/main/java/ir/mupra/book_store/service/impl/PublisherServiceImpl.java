package ir.mupra.book_store.service.impl;

import ir.mupra.book_store.mapper.PublisherMapper;
import ir.mupra.book_store.models.Publisher;
import ir.mupra.book_store.models.User;
import ir.mupra.book_store.payload.author.AuthorResponse;
import ir.mupra.book_store.payload.publisher.PublisherPayload;
import ir.mupra.book_store.payload.publisher.PublisherResponse;
import ir.mupra.book_store.repository.PublisherRepository;
import ir.mupra.book_store.service.PublisherService;
import ir.mupra.book_store.service.UserService;
import ir.mupra.book_store.service.base.impl.BaseServiceImpl;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherServiceImpl extends BaseServiceImpl<Publisher, Long, PublisherRepository> implements PublisherService {
    final PublisherMapper publisherMapper;
    final UserService userService;

    public PublisherServiceImpl(PublisherRepository repository, PublisherMapper publisherMapper, HttpSession session, UserService userService) {
        super(repository, session);
        this.publisherMapper = publisherMapper;
        this.userService = userService;
    }


    @Override
    public void addPublisher(PublisherPayload publisherPayload) {
        checkUserSignedIn();
        Publisher publisher = publisherMapper.publisherPayloadToPublisher(publisherPayload);
        User user = userService.getUserFromSession();
        publisher.setUser(user);
        repository.save(publisher);
    }

    @Override
    public List<PublisherResponse> findPublishersByUser() {
        checkUserSignedIn();
        User user = userService.getUserFromSession();
        List<PublisherResponse> authors = publisherMapper.authorsToAuthorsResponse(repository.findByUser(user));
        return authors;
    }
}
