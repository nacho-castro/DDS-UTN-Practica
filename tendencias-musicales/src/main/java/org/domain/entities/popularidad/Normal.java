package org.domain.entities.popularidad;

import org.domain.entities.Cancion;
import org.domain.entities.Icono;

public class Normal extends Popularidad {
    String icono = Icono.MUSICAL_NOTE.texto();
    private Integer reproduccionesLocales = 0;

    //Atributos de la CLASE, NO de la instancia
    private static Integer minReproducciones = 1000;

    @Override
    public void reproducir(Cancion cancion) {
        this.reproduccionesLocales++;
        if (this.reproduccionesLocales > minReproducciones) {
            this.cambiarPopularidad(cancion, new Auge());
        }
    }

    @Override
    public String obtenerLeyenda(Cancion cancion) {
        return cancion.getNombreArtista()
                + " - " + cancion.getAlbum().getNombre()
                + " - " + cancion.getTitulo();
    }

    @Override
    protected String obtenerIcono() {
        return this.icono;
    }
}
