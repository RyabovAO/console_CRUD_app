package java.repository;

import java.util.List;

public interface GenericRepository<T, ID> {

    <T> T getById(int id);
    <T> List<T> getAllByType(T t);
    void create();
    void update();
    void delete();
}
