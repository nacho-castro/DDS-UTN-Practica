package entities;

import java.util.HashSet;
import java.util.Set;

public class Alumno {
    private String nombre;
    private int legajo;
    private Set<Materia> materiasAprobadas; //Materias que el alumno aprobo

    public Alumno(String nombre,int legajo, Set<Materia> materiasAprobadas) {
        this.nombre = nombre;
        //Evitar si llega nulo
        this.materiasAprobadas = (materiasAprobadas == null) ? new HashSet<>() : materiasAprobadas;
        this.legajo = legajo;
    }

    //Un alumno de primero no tiene aprobadas aun
    public Alumno(String nombre,int legajo) {
        this.nombre = nombre;
        this.materiasAprobadas = new HashSet<>();
        this.legajo = legajo;
    }

    //Si en un futuro aprueba materias, se agregan
    public void addMateriaAprobada(Materia materia) {
        this.materiasAprobadas.add(materia);
    }

    public String getNombre() {
        return nombre;
    }

    public Boolean puedeCursar(Materia materia) {
        //Recursividad:
        //Todas las correlativas directas deben estar aprobadas y debe tener las correlativas de aquellas.
        return materia.getCorrelativas()
                .stream()
                .allMatch(correlativa -> materiasAprobadas.contains(correlativa) && puedeCursar(correlativa));
    }
}
