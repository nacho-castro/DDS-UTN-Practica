package org.domain.entities.popularidad;

import lombok.Setter;
import org.domain.entities.Cancion;
import org.domain.entities.Icono;

public class Auge extends Popularidad {
    String icono = Icono.ROCKET.texto();
    private Integer reproduccionesLocales = 0;

    //Atributos de la CLASE. no de la instancia
    @Setter
    private static Integer minReproducciones = 50000;
    @Setter
    private static Integer minLikes = 20000;
    @Setter
    private static Integer minDislikes = 5000;

    @Override
    public void reproducir(Cancion cancion){
        this.reproduccionesLocales++;
        if (this.reproduccionesLocales > minReproducciones && cancion.getCantLikes() > minLikes) {
            this.cambiarPopularidad(cancion, new Tendencia());
        } else if (cancion.getCantDislikes() > minDislikes) {
            this.cambiarPopularidad(cancion, new Normal());
        }
    }

    @Override
    public String obtenerLeyenda(Cancion cancion) {
        return cancion.getNombreArtista()
                + " - "
                + cancion.getTitulo()
                + " (" + cancion.getAlbum().getNombre()
                + " - " + cancion.getAlbum().getAnioLanzamiento() + ")";
    }

    @Override
    protected String obtenerIcono() {
        return this.icono;
    }
}
