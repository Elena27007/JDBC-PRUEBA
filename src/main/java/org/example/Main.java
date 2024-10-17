package org.example;

import org.example.dao.JdbcUtils;
import org.example.dao.PeliculaDAO;
import org.example.model.Pelicula;

public class Main {
    public static void main(String[] args) {
        //new PeliculaDAO(JdbcUtils.getConnection()).save(new Pelicula(7,"From", 2017, "terror"));
        Integer c = new PeliculaDAO(JdbcUtils.getConnection()).countFilms();
        System.out.println("Número de películas: "+ c);
        //new PeliculaDAO(JdbcUtils.getConnection()).filterByGenre("accion").forEach(System.out::println);
    }
}