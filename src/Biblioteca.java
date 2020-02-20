import java.util.ArrayList;

public class Biblioteca {

    static int ID_REF = 0;

    int id;
    int D_diasSignup;
    int L_librosXdia;
    ArrayList<Libro> libros;

    public Biblioteca(int d_diasSignup, int l_librosXdia, ArrayList<Libro> libro) {
        id = ID_REF++;
        D_diasSignup = d_diasSignup;
        L_librosXdia = l_librosXdia;
        this.libros = libro;
    }

    public int costeDias() {
        return D_diasSignup + (int) Math.ceil(((float) libros.size()) / ((float) L_librosXdia));
    }

    public ArrayList<Integer> getLibrosIDs() {
        ArrayList<Integer> ids = new ArrayList<>();

        for (Libro libro : libros) {
            ids.add(libro.getId());
        }

        return ids;
    }

    public static int getIdRef() {
        return ID_REF;
    }

    public static void setIdRef(int idRef) {
        ID_REF = idRef;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getD_diasSignup() {
        return D_diasSignup;
    }

    public void setD_diasSignup(int d_diasSignup) {
        D_diasSignup = d_diasSignup;
    }

    public int getL_librosXdia() {
        return L_librosXdia;
    }

    public void setL_librosXdia(int l_librosXdia) {
        L_librosXdia = l_librosXdia;
    }

    public ArrayList<Libro> getLibros() {
        return libros;
    }

    public void setLibros(ArrayList<Libro> libros) {
        this.libros = libros;
    }
}
