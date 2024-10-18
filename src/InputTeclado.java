import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class InputTeclado {
    static BufferedReader bf = new BufferedReader( new InputStreamReader( System.in ) );

    public static String leer() {
        try {
            return bf.readLine();
        } catch ( IOException e ) {
            return null;
        }
    }

    public static int leerInt() {
        String valor = leer();
        try {
            return Integer.parseInt( valor );
        } catch ( NumberFormatException e ) {
            return 0;
        }
    }

    public static boolean leerBoolean() {
        return Boolean.parseBoolean( leer() );
    }

}
