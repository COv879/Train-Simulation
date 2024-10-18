import Metro.RedMetro;
import java.io.IOException;
import java.util.logging.Logger;

public class SimulacionMetro {
    public static void main(String[] args) {

        System.out.println("Simulación de Metro");
        System.out.println("Bienvenido, Ingresa la opción: ");
        boolean seguir = true;

        while (seguir) {
            System.out.println("1. Leer archivo");
            System.out.println("2. Cerrar");
            switch (InputTeclado.leerInt()) {
                case 1:
                    try {
                        RedMetro red = RedMetro.leerArchivo("RedMetro.txt");
                        red.mostrarEstado();
                        seguir = false;
                    } catch (IOException e) {
                        System.out.println("Error leyendo el archivo: " + e.getMessage());
                        Logger.getLogger(SimulacionMetro.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
                    }
                    break;
                case 2:
                    seguir = false;
                    System.out.println("Hasta pronto");
                    break;
                default:
                    System.out.println("Ingrese una opciòn correcta");
            }
        }
    }
}
