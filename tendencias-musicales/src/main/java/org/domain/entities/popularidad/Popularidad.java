package org.domain.entities.popularidad;

import org.domain.entities.Cancion;

public interface Popularidad {
    public String obtenerLeyenda(Cancion cancion);

    public void cambiarPopularidad(Cancion cancion, Popularidad popularidad);

    public void actualizarPopularidad(Cancion cancion);
}
