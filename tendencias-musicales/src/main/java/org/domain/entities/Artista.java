package org.domain.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Artista {
    private String nombre;

    public Artista(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
