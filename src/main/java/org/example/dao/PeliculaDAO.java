package org.example.dao;

import org.example.model.Pelicula;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PeliculaDAO implements DAO<Pelicula> {

    private Connection connection;

    public PeliculaDAO(Connection connection) {
        this.connection = connection;
    }

    /**
     * Añade una nueva película
     * @param p
     */
    @Override
    public void save(Pelicula p) {
        try(PreparedStatement ps = connection.prepareStatement("INSERT INTO pelicula (id, titulo, año, genero) VALUES (?,?,?,?)")){
            ps.setInt(1,p.getId());
            ps.setString(2,p.getTitulo());
            ps.setInt(3,p.getAño());
            ps.setString(4,p.getGenero());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Cuenta las películas que hay en la base de datos
     * @return
     */
    @Override
    public Integer countFilms() {
        int salida = 0;
        try {
            var st = connection.createStatement();
            ResultSet rs = st.executeQuery("select count(*) from pelicula");
            rs.next();
            salida = rs.getInt(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return salida;
    }

    /**
     * Muestra por pantalla las películas de la base de datos filtradas por su género
     * @param genero
     * @return
     */
    public List<Pelicula> filterByGenre(String genero){
        var list = new ArrayList<Pelicula>();
        try(PreparedStatement ps = connection.prepareStatement("SELECT * FROM pelicula WHERE genero=?")){
            ps.setString(1,genero);
            ResultSet resultSet = ps.executeQuery();
            while(resultSet.next()) {
                list.add(new Pelicula(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getInt(3),
                        resultSet.getString(4)
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public List<Pelicula> findAll() {
        return List.of();
    }

    @Override
    public Pelicula findById(Integer id) {
        return null;
    }

    @Override
    public void update(Pelicula pelicula) {

    }

    @Override
    public void delete(int id) {

    }
}
