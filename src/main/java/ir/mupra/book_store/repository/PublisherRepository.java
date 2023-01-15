package ir.mupra.book_store.repository;

import ir.mupra.book_store.models.Publisher;
import ir.mupra.book_store.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Long> {

    List<Publisher> findByUser(User user);
}
