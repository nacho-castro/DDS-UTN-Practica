import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String args[]){

        //MATERIAS
        //--------------------------------------------------------
        //Materias Primero
        Materia alg = new Materia("Algoritmos");
        Materia arq = new Materia("Arquitectura");
        Materia syp = new Materia("Sistemas y Procesos");

        //Materias Segundo
        Materia pdp = new Materia("Paradigmas");
        pdp.addCorrelativas(alg);

        Materia ads = new Materia("Analisis de Sistemas");
        ads.addCorrelativas(alg);
        ads.addCorrelativas(syp);

        Materia so = new Materia("Sistemas Operativos");
        so.addCorrelativas(arq);

        //ALUMNOS
        //--------------------------------------------------------
        //Materias que aprobo Pablo
        Set<Materia> materiasAprobadasPablo = new HashSet<>();
        materiasAprobadasPablo.add(alg);
        materiasAprobadasPablo.add(syp);

        Alumno pablo = new Alumno("pablo",314, materiasAprobadasPablo);

        //Se inscribe
        Set<Materia> inscriptasPablo = new HashSet<>();
        inscriptasPablo.add(ads);
        inscriptasPablo.add(pdp);
        inscriptasPablo.add(arq);
        //inscriptasPablo.add(so);

        Inscripcion inscripcion = new Inscripcion(pablo,inscriptasPablo);
        System.out.println("Inscripcion de " + pablo.getNombre() + ": "  + inscripcion.aprobada() + '\n');

        //--------------------------------------------------------
        //Materias que aprobo Lula
        Set<Materia> materiasAprobadasLula = new HashSet<>();
        materiasAprobadasLula.add(alg);
        materiasAprobadasLula.add(arq);

        Alumno lula = new Alumno("Lucia",324, materiasAprobadasLula);

        //Se inscribe
        Set<Materia> inscriptas = new HashSet<>();
        inscriptas.add(ads);
        inscriptas.add(pdp);
        inscriptas.add(so);

        Inscripcion inscripcion2 = new Inscripcion(lula,inscriptas);
        System.out.println("Inscripcion de " + lula.getNombre() + ": "  + inscripcion2.aprobada() + '\n');
    }
}
