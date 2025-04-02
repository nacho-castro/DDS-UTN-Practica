package org.domain.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Album {
    private String nombre;
    private Artista artista;
    private Integer anioLanzamiento;

    public Album(String nombre, Artista artista, Integer anioLanzamiento) {
        this.nombre = nombre;
        this.artista = artista;
        this.anioLanzamiento = anioLanzamiento;
    }

    public Artista getArtista() {
        return artista;
    }

    public String getNombre() {
        return nombre;
    }

    public int getAnioLanzamiento() {
        return anioLanzamiento;
    }
}
