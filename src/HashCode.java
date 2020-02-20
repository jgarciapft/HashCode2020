import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class HashCode {
//    public static String fuckHashCode = "out.txt";

    // Datos del problema
    int B_libros;
    int L_Bibliotecas;
    int D_Dias;

    HashMap<Integer, Libro> libros;
    ArrayList<Biblioteca> bibliotecas;

    public HashCode() {
        libros = new HashMap<>();
        bibliotecas = new ArrayList<>();
    }

    void leerFicheroEntrada(String ruta) throws IOException {
        BufferedReader bufferFichero = new BufferedReader(new FileReader(ruta));
        String linea;

        // B, L, D
        linea = bufferFichero.readLine();
        leerDatosEntrada(linea);

        // puntuaciones de cada libro
        linea = bufferFichero.readLine();
        leerPuntuacionesLibro(linea);

        // Cada biblioteca
        do {
            // Datos biblioteca
            linea = bufferFichero.readLine();

            if (linea != null) {
                String[] datos = linea.trim().split(" ");

                // Libros
                linea = bufferFichero.readLine();

                if (linea != null) {
                    String[] tokenIdLibros = linea.trim().split(" ");
                    ArrayList<Libro> ALLibros = new ArrayList<>();

                    for (int i = 0; i < tokenIdLibros.length; i++) {
                        ALLibros.add(libros.get(Integer.parseInt(tokenIdLibros[i])));
                    }
                    ALLibros.sort(Comparator.comparingInt(l -> l.puntuacion));
                    Collections.reverse(ALLibros);

                    // Instanciar y añadir biblioteca
                    bibliotecas.add(new Biblioteca(Integer.parseInt(datos[0]), Integer.parseInt(datos[1]), ALLibros));
                }
            }
        } while (linea != null);
    }

    void leerDatosEntrada(String linea) {
        String[] datos = linea.trim().split(" ");

        setB_libros(Integer.parseInt(datos[0]));
        setL_Bibliotecas(Integer.parseInt(datos[1]));
        setD_Dias(Integer.parseInt(datos[2]));
    }

    void leerPuntuacionesLibro(String linea) {
        String[] tokenLibros = linea.trim().split(" ");

        for (String tokenLibro : tokenLibros) {
            Libro libro = new Libro(Integer.parseInt(tokenLibro));
            libros.put(libro.getId(), libro);
        }
    }

    void resolver() {
        int D_diasGastados = 0;
        int A_nBiblioSol = 0;
        ArrayList<Solucion.BibliotecaSol> soluciones = new ArrayList<>();

        for (int idx = 0; idx < bibliotecas.size() && D_diasGastados <= D_Dias; idx++) {
            Biblioteca biblioteca = bibliotecas.get(idx);

            D_diasGastados += biblioteca.costeDias();
            soluciones.add(new Solucion.BibliotecaSol(biblioteca.getId(),
                    biblioteca.getLibros().size(), biblioteca.getLibrosIDs()));
            A_nBiblioSol++;
        }

        Solucion solucion = new Solucion(A_nBiblioSol, soluciones);
        try {
            solucion.volcalSolucion();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getB_libros() {
        return B_libros;
    }

    public void setB_libros(int b_libros) {
        B_libros = b_libros;
    }

    public int getL_Bibliotecas() {
        return L_Bibliotecas;
    }

    public void setL_Bibliotecas(int l_Bibliotecas) {
        L_Bibliotecas = l_Bibliotecas;
    }

    public int getD_Dias() {
        return D_Dias;
    }

    public void setD_Dias(int d_Dias) {
        D_Dias = d_Dias;
    }
}
