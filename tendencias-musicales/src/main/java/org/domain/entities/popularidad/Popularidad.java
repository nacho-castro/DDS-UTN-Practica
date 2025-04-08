package org.domain.entities.popularidad;

import org.domain.entities.Cancion;

public abstract class Popularidad {

    public void cambiarPopularidad(Cancion cancion, Popularidad popularidad) {
        cancion.setPopularidad(popularidad);
    }

    public String obtenerDetalle(Cancion cancion){
        return this.obtenerIcono() + " - " + this.obtenerLeyenda(cancion);
    }

    public abstract String obtenerLeyenda(Cancion cancion);

    protected abstract String obtenerIcono();

    public abstract void reproducir(Cancion cancion);
}
