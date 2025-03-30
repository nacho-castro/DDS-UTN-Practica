package entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class InscripcionTest {

    //Materias Primer Año
    Materia alg = new Materia("Algoritmos");
    Materia arq = new Materia("Arquitectura");
    Materia syp = new Materia("Sistemas y Procesos");

    //Materias Segundo
    Materia pdp = new Materia("Paradigmas", Set.of(alg));
    Materia ads = new Materia("Analisis de Sistemas", Set.of(alg,syp));
    Materia so = new Materia("Sistemas Operativos", Set.of(arq));

    @Test
    @DisplayName("Pablo aprueba la inscripcion.")
    public void inscripcionAprobada(){
        //Alumno Pablo
        Alumno pablo = new Alumno("pablo",314, Set.of(alg,syp));

        //Se inscribe
        Inscripcion inscripcion = new Inscripcion(pablo, Set.of(ads, pdp, arq));
        Assertions.assertTrue(inscripcion.aprobada());
    }

    @Test
    @DisplayName("Lula NO aprueba la inscripcion.")
    public void inscripcionRechazada(){
        //Alumna Lula
        Alumno lula = new Alumno("Lucia",324, Set.of(alg,arq));

        //Se inscribe
        Inscripcion inscripcion = new Inscripcion(lula, Set.of(ads, pdp, so));
        Assertions.assertFalse(inscripcion.aprobada());
    }

    @Test
    @DisplayName("Alumno de primero se inscribe correctamente")
    public void inscripcionPrimero(){
        //Lara aun no tiene aprobadas. Set vacio.
        Alumno lara = new Alumno("Lara",333);

        //Se inscribe
        Inscripcion inscripcion = new Inscripcion(lara, Set.of(alg, arq, syp));
        Assertions.assertTrue(inscripcion.aprobada());
    }

    @Test
    @DisplayName("Alumno de primero no se puede inscribir a segundo")
    public void inscripcionSegundo(){
        Alumno lara = new Alumno("Lara",333);

        //Se inscribe
        Inscripcion inscripcion = new Inscripcion(lara, Set.of(so, pdp, ads));
        Assertions.assertFalse(inscripcion.aprobada());
    }
}