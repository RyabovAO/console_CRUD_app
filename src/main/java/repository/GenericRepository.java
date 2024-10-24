package repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public interface GenericRepository<T, ID> {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

//    <T> T getById(int id);
//    <T> List<T> getAllByType(T t);
//    void create(T t);
//    void update();
//    void delete();
}
