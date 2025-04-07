package org.domain.entities.popularidad;

import org.domain.entities.Cancion;
import org.domain.entities.Icono;

import java.time.LocalDateTime;

public class Tendencia implements Popularidad {
    String icono = Icono.FIRE.texto();

    @Override
    public void actualizarPopularidad(Cancion cancion) {
        LocalDateTime ultReproduccion = cancion.getUltReproduccion();
        LocalDateTime hoy = LocalDateTime.now();

        if (ultReproduccion.isBefore(hoy.minusHours(24))) {
            Normal normal = new Normal();
            this.cambiarPopularidad(cancion, normal);
        }
    }

    @Override
    public String obtenerLeyenda(Cancion cancion) {
        return this.icono + " - " +
                cancion.getTitulo()
                + " - " + cancion.getNombreArtista()
                + " (" + cancion.getAlbum().getNombre()
                + " - " + cancion.getAlbum().getAnioLanzamiento() + ")";
    }

    @Override
    public void cambiarPopularidad(Cancion cancion, Popularidad popularidad) {
        cancion.setPopularidad(popularidad);
    }
}
