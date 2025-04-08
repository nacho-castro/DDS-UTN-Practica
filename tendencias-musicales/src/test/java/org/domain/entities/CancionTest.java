package org.domain.entities;

import org.domain.entities.popularidad.Auge;
import org.domain.entities.popularidad.Normal;
import org.domain.entities.popularidad.Tendencia;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class CancionTest {
    Artista artista;
    Album album;
    Cancion cancion;
    Normal normal;
    Auge auge;
    Tendencia tendencia;

    @BeforeEach
    public void init(){
         this.artista = new Artista("The Beatles");
         this.album = new Album("Abbey Road", artista,1969);
         this.cancion = new Cancion("Here comes the sun",album,1969);
       this.normal = new Normal();
       this.auge = new Auge();
       this.tendencia = new Tendencia();
    }

    @Test
    @DisplayName("La cancion se crea y tiene popularidad Normal")
    public void popularidadNormal(){
        Assertions.assertInstanceOf(Normal.class,cancion.getPopularidad());
        Assertions.assertEquals(cancion.reproducir(),normal.obtenerDetalle(cancion));
    }

    @Test
    @DisplayName("La cancion se reproduce >1000 y tiene popularidad EnAuge")
    public void popularidadEnAuge(){
        for(int i = 0; i < 2000; i++){
            cancion.reproducir();
        }
        Assertions.assertInstanceOf(Auge.class,cancion.getPopularidad());
        Assertions.assertEquals(cancion.reproducir(),auge.obtenerDetalle(cancion));
    }

    @Test
    @DisplayName("La cancion tiene dislikes y baja a popularidad Normal")
    public void popularidadBaja(){
        for(int i = 0; i < 2000; i++){
            cancion.reproducir();
        }
        Assertions.assertEquals(cancion.reproducir(),auge.obtenerDetalle(cancion));
        for(int i = 0; i < 5010; i++){
            cancion.darDislike();
        }
        Assertions.assertEquals(cancion.reproducir(),normal.obtenerDetalle(cancion));
        Assertions.assertInstanceOf(Normal.class,cancion.getPopularidad());
    }

    @Test
    @DisplayName("La cancion se viraliza y tiene popularidad Tendencia")
    public void popularidadTendencia(){
        for(int i = 0; i < 2000; i++){
            cancion.reproducir();
        }
        //En auge
        Assertions.assertInstanceOf(Auge.class,cancion.getPopularidad());
        for(int i = 0; i < 50001; i++){
            cancion.reproducir();
            cancion.darLike();
        }
        Assertions.assertInstanceOf(Tendencia.class,cancion.getPopularidad());
        Assertions.assertEquals(cancion.reproducir(),tendencia.obtenerDetalle(cancion));
    }

    @Test
    @DisplayName("La cancion Tendencia no se escucha en 24hs y vuelve a normal")
    public void popularidad24horas(){
        for(int i = 0; i < 2000; i++){
            cancion.reproducir();
        }
        //En auge
        Assertions.assertInstanceOf(Auge.class,cancion.getPopularidad());
        Assertions.assertEquals(cancion.reproducir(),auge.obtenerDetalle(cancion));
        for(int i = 0; i < 50001; i++){
            cancion.darLike();
            cancion.reproducir();
        }
        cancion.setUltReproduccion(LocalDateTime.of(2024, 1, 1, 12,0));
        Assertions.assertEquals(cancion.reproducir(),normal.obtenerDetalle(cancion));
        Assertions.assertInstanceOf(Normal.class,cancion.getPopularidad());
    }

    @Test
    @DisplayName("La cancion Tendencia se escucha dentro de las 24hs")
    public void popularidad10horas(){
        for(int i = 0; i < 2000; i++){
            cancion.reproducir();
        }
        //En auge
        Assertions.assertInstanceOf(Auge.class,cancion.getPopularidad());

        for(int i = 0; i < 50001; i++){
            cancion.darLike();
            cancion.reproducir();
        }//es tendencia

        LocalDateTime fechaActualMenos10hs = LocalDateTime.now().minusHours(10);
        cancion.setUltReproduccion(fechaActualMenos10hs);
        Assertions.assertInstanceOf(Tendencia.class,cancion.getPopularidad());
        Assertions.assertEquals(cancion.reproducir(),tendencia.obtenerDetalle(cancion));
    }
}