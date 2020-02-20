import java.util.Objects;

public class Libro {

    static int ID_REF = 0;

    int id;
    int puntuacion;

    public Libro(int puntuacion) {
        id = ID_REF++;
        this.puntuacion = puntuacion;
    }

    public Libro(int id, int puntuacion) {
        this.id = id;
        this.puntuacion = puntuacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Libro libro = (Libro) o;
        return id == libro.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
