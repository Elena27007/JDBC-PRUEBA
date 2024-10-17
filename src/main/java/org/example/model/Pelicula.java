package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pelicula implements Serializable {
    private Integer id;
    private String titulo;
    private Integer año;
    private String genero;

    public Pelicula(String titulo, Integer año, String genero) {
        this.titulo = titulo;
        this.año = año;
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", año=" + año +
                ", genero='" + genero + '\'' +
                '}';
    }
}
