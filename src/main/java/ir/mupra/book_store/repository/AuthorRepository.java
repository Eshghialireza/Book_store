package ir.mupra.book_store.repository;

import ir.mupra.book_store.models.Author;
import ir.mupra.book_store.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    List<Author> findByUser(User user);
}
