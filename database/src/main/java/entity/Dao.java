package entity;

import java.util.List;
import java.util.Optional;

public interface Dao<K,E> {

    Optional<E> get(K k);

    List<E> getAll();

    boolean delete(K k);

    boolean save(E e);

    boolean update(E e);
}
