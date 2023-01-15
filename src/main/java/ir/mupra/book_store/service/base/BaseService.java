package ir.mupra.book_store.service.base;

import ir.mupra.book_store.models.base.BaseDomain;

import java.io.Serializable;
import java.util.List;

public interface BaseService<E extends BaseDomain<ID>, ID extends Serializable> {
    E findById(ID id);

    List<E> findAll();

    void delete(E e);

    void checkUserSignedIn();
}
