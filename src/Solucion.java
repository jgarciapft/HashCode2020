import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Solucion {

    int A_nBiblioSol;
    ArrayList<BibliotecaSol> bibliotecasSol;

    public Solucion(int a_nBiblioSol, ArrayList<BibliotecaSol> bibliotecasSol) {
        A_nBiblioSol = a_nBiblioSol;
        this.bibliotecasSol = bibliotecasSol;
    }

    void volcalSolucion() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(Main.ruta_salida));
        StringBuilder sb = new StringBuilder();

        sb.append(A_nBiblioSol).append("\n");
        for (BibliotecaSol bibliotecaSol : bibliotecasSol) {
            sb.append(bibliotecaSol.toString());
        }

        System.out.println(sb.toString());
        writer.write(sb.toString());
        writer.close();
    }

    public static class BibliotecaSol {

        int y_idBiblio;
        int k_nLibros;
        ArrayList<Integer> idsLibros;

        public BibliotecaSol(int y_idBiblio, int k_nLibros, ArrayList<Integer> idsLibros) {
            this.y_idBiblio = y_idBiblio;
            this.k_nLibros = k_nLibros;
            this.idsLibros = idsLibros;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(y_idBiblio).append(" ").append(k_nLibros).append("\n");

            for (Integer idLibro : idsLibros) {
                sb.append(idLibro).append(" ");
            }
            sb.append("\n");

            return sb.toString();
        }
    }
}
