package org.domain.entities;

import lombok.Getter;
import lombok.Setter;
import org.domain.entities.popularidad.Normal;
import org.domain.entities.popularidad.Popularidad;

import java.time.LocalDateTime;

@Getter
@Setter
public class Cancion {
    private String titulo;
    private Album album;
    private Integer cantLikes;
    private Integer cantDislikes;
    private Integer cantReproducciones;
    private Integer anioLanzamiento;
    private LocalDateTime ultReproduccion;
    private Popularidad popularidad;

    public Cancion(String titulo, Album album, Integer anioLanzamiento) {
        this.cantReproducciones = 0;
        this.cantLikes = 0;
        this.cantDislikes = 0;
        this.titulo = titulo;
        this.album = album;
        this.anioLanzamiento = anioLanzamiento;
        this.popularidad = new Normal();
    }

    public String reproducir() {
        this.cantReproducciones++;
        popularidad.reproducir(this);
        this.ultReproduccion = LocalDateTime.now();
        return popularidad.obtenerDetalle(this);
    }

    public Integer darLike() {
        this.cantLikes++;
        return cantLikes;
    }

    public Integer darDislike() {
        this.cantDislikes++;
        return cantDislikes;
    }

    public String getNombreArtista() {
        return album.getArtista().getNombre();
    }

}
