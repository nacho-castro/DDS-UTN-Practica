package org.domain.entities.popularidad;

import org.domain.entities.Cancion;
import org.domain.entities.Icono;

public class Normal implements Popularidad {
    String icono = Icono.MUSICAL_NOTE.texto();

    @Override
    public void actualizarPopularidad(Cancion cancion) {
        if (cancion.getCantReproducciones() > 1000) {
            Popularidad enAuge = new Auge();
            this.cambiarPopularidad(cancion, enAuge);
        }
    }

    @Override
    public String obtenerLeyenda(Cancion cancion) {
        return this.icono + " - " + cancion.getNombreArtista()
                + " - " + cancion.getAlbum().getNombre()
                + " - " + cancion.getTitulo();
    }

    @Override
    public void cambiarPopularidad(Cancion cancion, Popularidad popularidad) {
        cancion.setPopularidad(popularidad);
    }
}
