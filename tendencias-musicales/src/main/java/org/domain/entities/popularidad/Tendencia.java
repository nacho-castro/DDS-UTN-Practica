package org.domain.entities.popularidad;

import lombok.Setter;
import org.domain.entities.Cancion;
import org.domain.entities.Icono;

import java.time.LocalDateTime;

public class Tendencia extends Popularidad {
    String icono = Icono.FIRE.texto();

    //Atributos de la CLASE. no de la instancia
    @Setter
    private static Integer minHoras = 24;

    @Override
    public void reproducir(Cancion cancion) {
        LocalDateTime ultReproduccion = cancion.getUltReproduccion();
        LocalDateTime hoy = LocalDateTime.now();

        if (ultReproduccion.isBefore(hoy.minusHours(minHoras))) {
            this.cambiarPopularidad(cancion, new Normal());
        }
    }

    @Override
    public String obtenerLeyenda(Cancion cancion) {
        return cancion.getTitulo()
                + " - " + cancion.getNombreArtista()
                + " (" + cancion.getAlbum().getNombre()
                + " - " + cancion.getAlbum().getAnioLanzamiento() + ")";
    }

    @Override
    protected String obtenerIcono() {
        return this.icono;
    }
}
