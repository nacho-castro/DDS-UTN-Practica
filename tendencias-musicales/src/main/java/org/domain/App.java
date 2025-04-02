package org.domain;

import org.domain.entities.Album;
import org.domain.entities.Artista;
import org.domain.entities.Cancion;
import org.domain.entities.popularidad.Normal;

public class App {
    public static void main(String[] args) {
        Artista artista = new Artista("The Beatles");
        Album album = new Album("Abbey Road", artista,1969);
        Cancion cancion = new Cancion("Here comes the sun",album,1969);

        System.out.println(cancion.reproducir()); //normal
        for(int i = 0; i < 2000; i++){
            cancion.reproducir();
        }
        System.out.println(cancion.reproducir()); //auge
        for(int i = 0; i < 5010; i++){
            cancion.darDislike();
        }
        System.out.println(cancion.reproducir()); //normal
    }
}
