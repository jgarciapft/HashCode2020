import java.io.IOException;

public class Main {

    public static String ruta_salida;

    public static void main(String[] args) {
        ruta_salida = args[1];
        HashCode hashCode = new HashCode();

        try {
            hashCode.leerFicheroEntrada(args[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }
        hashCode.resolver();

        System.out.println("//");
    }

}
