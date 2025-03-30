package entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class AlumnoTest {
    //Materias Primer Año
    Materia alg = new Materia("Algoritmos");
    Materia arq = new Materia("Arquitectura");
    Materia syp = new Materia("Sistemas y Procesos");

    //Materias Segundo
    Materia pdp = new Materia("Paradigmas", Set.of(alg));
    Materia ads = new Materia("Analisis de Sistemas", Set.of(alg,syp));
    Materia so = new Materia("Sistemas Operativos", Set.of(arq));

    //Materias Tercero
    Materia dds = new Materia("Diseño de Sistemas", Set.of(pdp,ads));
    Materia bd = new Materia("Bases de Datos", Set.of(ads));

    @Test
    @DisplayName("El alumno puede cursar Diseño")
    public void puedeCursar(){
        Alumno alumno = new Alumno("Juan",314,Set.of(alg, arq, syp, pdp,ads,so));
        Assertions.assertTrue(alumno.puedeCursar(dds));
    }

    @Test
    @DisplayName("El alumno puede cursar Diseño")
    public void puedeCursarSinCorrelavitas(){
        Alumno alumno = new Alumno("Juan",314,Set.of(pdp,ads));
        Assertions.assertTrue(alumno.puedeCursar(dds));
    }

    @Test
    @DisplayName("El alumno NO puede cursar Diseño")
    public void noPuedeCursar(){
        Alumno alumno = new Alumno("Juan",314,Set.of(ads));
        Assertions.assertFalse(alumno.puedeCursar(dds));
    }

    @Test
    @DisplayName("Un alumno de primero puede cursar primero")
    public void puedeCursarPrimero(){
        Alumno alumno = new Alumno("Juan",314, null);
        Assertions.assertTrue(alumno.puedeCursar(arq));
    }

    @Test
    @DisplayName("Un alumno de primero NO puede cursar materias de segundo")
    public void puedeCursarSegundo(){
        //Juan es de primero y tiene Set vacio
        Alumno alumno = new Alumno("Juan",314);
        Assertions.assertFalse(alumno.puedeCursar(so));
    }

    @Test
    @DisplayName("Un alumno de segundo NO puede cursar materias de tercero")
    public void puedeCursarTercero(){
        Alumno alumno = new Alumno("Juan",314, Set.of(alg,arq,syp));
        Assertions.assertFalse(alumno.puedeCursar(dds));
    }

}