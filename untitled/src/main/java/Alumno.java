
import java.util.Set;

public class Alumno {
    private String nombre;
    private int legajo;
    private Set<Materia> aprobadas; //Materias que el alumno aprobo

    public Alumno(String nombre,int legajo, Set<Materia> aprobadas) {
        this.nombre = nombre;
        this.aprobadas = aprobadas;
        this.legajo = legajo;
    }

    public String getNombre() {
        return nombre;
    }

    public Boolean puedeCursar(Materia materia){

        for (Materia correlativa : materia.getCorrelativas()) {
            if (!aprobadas.contains(correlativa)) {
                System.out.println("Rechazada: " + materia.getNombre());
                System.out.println("Motivo: " + this.getNombre() + " NO tiene " + correlativa.getNombre() + " aprobada");
                return false; //Si alguna correlativa no está aprobada, no puede cursar
            }
        }
        return true; //Si tiene TODAS las correlativas correspondientes puede cursar
    }
}
