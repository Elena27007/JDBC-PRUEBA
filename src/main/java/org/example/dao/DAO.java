package org.example.dao;

import java.util.List;

public interface DAO<T> {
    public void save(T t);
    public Integer countFilms();
    public List<T> filterByGenre(String genero);
    public List<T> findAll();
    public T findById(Integer id);
    public void update(T t);
    public void delete(int id);

}
