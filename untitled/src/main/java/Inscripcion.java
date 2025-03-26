import java.util.Set;

public class Inscripcion {
    private Alumno alumno;
    private Set<Materia> materiasInscriptas;
    private Boolean aprobada;

    public Inscripcion(Alumno alumno, Set<Materia> materiasInscriptas) {
        this.alumno = alumno;
        this.materiasInscriptas = materiasInscriptas;
    }

    public Boolean aprobada(){
        this.aprobada = materiasInscriptas
                    .stream()
                    .allMatch(materia -> alumno.puedeCursar(materia));
        return aprobada;
    }
}
