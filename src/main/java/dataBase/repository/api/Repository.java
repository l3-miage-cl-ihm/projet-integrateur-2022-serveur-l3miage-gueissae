package dataBase.repository.api;

import java.util.List;

/**
 * @param <T> the entity type
 * @param <I> the id type
 */
public interface Repository<T, I> {

    void save(T entity);

    void delete(T entity);

    T findById(I id);

    List<T> getAll();

}