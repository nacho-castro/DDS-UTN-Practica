package org.domain.entities.popularidad;

import org.domain.entities.Cancion;
import org.domain.entities.Icono;

public class Auge implements Popularidad {
    String icono = Icono.ROCKET.texto();

    @Override
    public void actualizarPopularidad(Cancion cancion){
        if (cancion.getCantReproducciones() > 50000 && cancion.getCantLikes() > 20000) {
            Popularidad tendencia = new Tendencia();
            this.cambiarPopularidad(cancion, tendencia);
        } else if (cancion.getCantDislikes() > 5000) {
            Popularidad normal = new Normal();
            this.cambiarPopularidad(cancion, normal);
        }
    }

    @Override
    public String obtenerLeyenda(Cancion cancion) {
        return this.icono + " - " +
                cancion.getNombreArtista()
                + " - "
                + cancion.getTitulo()
                + " (" + cancion.getAlbum().getNombre()
                + " - " + cancion.getAlbum().getAnioLanzamiento() + ")";
    }

    @Override
    public void cambiarPopularidad(Cancion cancion, Popularidad popularidad) {
        cancion.setPopularidad(popularidad);
    }
}
