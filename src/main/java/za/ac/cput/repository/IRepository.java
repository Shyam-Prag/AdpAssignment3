package za.ac.cput.repository;

import java.util.Set;
import za.ac.cput.entity.Address;

@Deprecated
public interface IRepository <T, ID>{
    public T create (T t);
    public T read(ID id);
    public T update(T t);
    public boolean delete(ID id);
    public Set<T> getAll();
}
