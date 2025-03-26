
import java.util.HashSet;
import java.util.Set;

public class Materia {
    private String nombre;
    private Set<Materia> correlativas;

    public Materia(String nombre) {
        this.nombre = nombre;
        this.correlativas = new HashSet<>();
    }

    public void addCorrelativas(Materia materia){
        this.correlativas.add(materia);
    }

    public Set<Materia> getCorrelativas() {
        return correlativas;
    }

    public String getNombre() {
        return nombre;
    }
}
