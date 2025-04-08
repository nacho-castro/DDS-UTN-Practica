package org.domain.entities;

import org.domain.entities.popularidad.Auge;
import org.domain.entities.popularidad.Normal;
import org.domain.entities.popularidad.Tendencia;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class CancionTest {
    Artista artista = new Artista("The Beatles");
    Album album = new Album("Abbey Road", artista,1969);
    Cancion cancion = new Cancion("Here comes the sun",album,1969);

    @Test
    @DisplayName("La cancion se crea y tiene popularidad Normal")
    public void popularidadNormal(){
        System.out.println(cancion.reproducir());
        Assertions.assertInstanceOf(Normal.class,cancion.getPopularidad());
        Assertions.assertEquals(cancion.reproducir(),"\uD83C\uDFB5 - The Beatles - Abbey Road - Here comes the sun");
    }

    @Test
    @DisplayName("La cancion se reproduce >1000 y tiene popularidad EnAuge")
    public void popularidadEnAuge(){
        for(int i = 0; i < 2000; i++){
            cancion.reproducir();
        }
        System.out.println(cancion.reproducir());
        Assertions.assertInstanceOf(Auge.class,cancion.getPopularidad());
        Assertions.assertEquals(cancion.reproducir(),"\uD83D\uDE80 - The Beatles - Here comes the sun (Abbey Road - 1969)");
    }

    @Test
    @DisplayName("La cancion tiene dislikes y baja a popularidad Normal")
    public void popularidadBaja(){
        for(int i = 0; i < 2000; i++){
            cancion.reproducir();
        }
        System.out.println(cancion.reproducir()); //en auge
        for(int i = 0; i < 5010; i++){
            cancion.darDislike();
        }
        System.out.println(cancion.reproducir()); //en auge pero se cambia
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
        System.out.println(cancion.reproducir());
        Assertions.assertInstanceOf(Tendencia.class,cancion.getPopularidad());
        Assertions.assertEquals(cancion.reproducir(),"\uD83D\uDD25 - Here comes the sun - The Beatles (Abbey Road - 1969)");
    }

    @Test
    @DisplayName("La cancion Tendencia no se escucha en 24hs y vuelve a normal")
    public void popularidad24horas(){
        for(int i = 0; i < 2000; i++){
            cancion.reproducir();
        }
        //En auge
        Assertions.assertInstanceOf(Auge.class,cancion.getPopularidad());

        for(int i = 0; i < 50001; i++){
            cancion.darLike();
            cancion.reproducir();
        }
        cancion.setUltReproduccion(LocalDateTime.of(2024, 1, 1, 12,0));
        System.out.println(cancion.reproducir());
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
        System.out.println(cancion.reproducir());

        Assertions.assertInstanceOf(Tendencia.class,cancion.getPopularidad());
    }
}