package Generic;
import Entity.Product;

import java.util.*;

public interface IGeneric<T> {
    T addNew(T t);
    T update(T t);
    boolean Delete(String id);

    T findById(String id);

    List<T> findByName(String name);
}
