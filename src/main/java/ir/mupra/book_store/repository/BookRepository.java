package ir.mupra.book_store.repository;

import ir.mupra.book_store.models.Book;
import ir.mupra.book_store.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByUser(User user);
}
