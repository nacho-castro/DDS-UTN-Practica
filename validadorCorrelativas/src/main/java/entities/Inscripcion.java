package entities;

import java.util.Set;

public class Inscripcion {
    private Alumno alumno;
    private Set<Materia> materiasInscriptas;
    private Boolean estaAprobada;

    public Inscripcion(Alumno alumno, Set<Materia> materiasInscriptas) {
        this.alumno = alumno;
        this.materiasInscriptas = materiasInscriptas;
    }

    public Boolean aprobada(){
        this.estaAprobada = materiasInscriptas
                    .stream()
                    .allMatch(materia -> alumno.puedeCursar(materia));
        return estaAprobada;
    }
}
