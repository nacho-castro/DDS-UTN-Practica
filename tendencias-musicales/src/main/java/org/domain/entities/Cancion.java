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

        popularidad.actualizarPopularidad(this);
        String mensaje = popularidad.obtenerLeyenda(this);

        this.ultReproduccion = LocalDateTime.now();
        return mensaje;
    }

    public Integer darLike() {
        this.cantLikes++;
        popularidad.actualizarPopularidad(this);
        return cantLikes;
    }

    public Integer darDislike() {
        this.cantDislikes++;
        popularidad.actualizarPopularidad(this);
        return cantDislikes;
    }

    public Integer getCantReproducciones() {
        return cantReproducciones;
    }

    public String getNombreArtista() {
        return album.getArtista().getNombre();
    }

    public String getTitulo() {
        return titulo;
    }

    public Album getAlbum() {
        return album;
    }

    public Integer getCantLikes() {
        return cantLikes;
    }

    public Integer getCantDislikes() {
        return cantDislikes;
    }

    public LocalDateTime getUltReproduccion() {
        return ultReproduccion;
    }

    public Popularidad getPopularidad() {
        return popularidad;
    }

    public void setPopularidad(Popularidad popularidad) {
        this.popularidad = popularidad;
    }

    public void setUltReproduccion(LocalDateTime ultReproduccion) {
        this.ultReproduccion = ultReproduccion;
    }
}
