package ir.mupra.book_store.service.base.impl;

import ir.mupra.book_store.exception.NotFoundException;
import ir.mupra.book_store.exception.Unauthorized;
import ir.mupra.book_store.models.User;
import ir.mupra.book_store.models.base.BaseDomain;
import ir.mupra.book_store.service.base.BaseService;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Transactional
public class BaseServiceImpl<E extends BaseDomain<ID>,
        ID extends Serializable, R extends JpaRepository<E, ID>> implements BaseService<E, ID> {
    protected final R repository;
    public final HttpSession session;

    @Override
    public E findById(ID id) {
        Optional<E> eOptional = repository.findById(id);
        // TODO: 11/8/2022 change the exception
        return eOptional.orElseThrow(() -> new NotFoundException("no result found to complete your request"));
    }

    @Override
    public List<E> findAll() {
        return repository.findAll();
    }

    @Override
    public void delete(E e) {
        repository.delete(e);
    }

    @Override
    public void checkUserSignedIn() {
        User user = (User) session.getAttribute("userDetails");
        if (user == null) {
            throw new Unauthorized("please signIn");
        }
    }
}
