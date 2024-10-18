package Metro;

import java.io.*;
import java.util.*;

public class RedMetro {
    private String nombre;
    private List<Linea> lineas;

    // Constructor
    public RedMetro(String nombre, List<Linea> lineas) {
        this.nombre = nombre;
        this.lineas = lineas;
    }


    public void mostrarEstado() {
        System.out.println("Red de Metro: " + nombre);
        for (Linea linea : lineas) {
            System.out.println("Línea: " + linea.getNombre());
            for (Estacion estacion : linea.getEstaciones()) {
                System.out.print("Estación: " + estacion.getNombre() +
                        " [" + estacion.getCapacidadActual() + "/" + estacion.getCapacidadMaxima() + "]");

                // Mostrar trenes en la estación
                List<Tren> trenes = linea.getTrenes();
                for (Tren tren : trenes) {
                    if (tren.getEstacionActual().equals(estacion)) {
                        System.out.print(" | Tren (" + tren.getPasajerosActuales() + "/" + tren.getCapacidadMaxima() +
                                ") Dirección: " + (tren.getDireccion() == 1 ? "->" : "<-"));
                    }
                }
                System.out.println();  // Nueva línea después de cada estación
            }
            System.out.println();  // Nueva línea después de cada línea de metro
        }
    }
    // Método para leer el archivo red.metro
    public static RedMetro leerArchivo(String archivo) throws IOException {
        BufferedReader lector = new BufferedReader(new FileReader(archivo));
        String nombreRed = lector.readLine();  // Leer el nombre de la red (primera línea)
        List<Linea> lineas = new ArrayList<>();

        String lineaTexto;
        while ((lineaTexto = lector.readLine()) != null) {
            Linea linea = procesarLinea(lineaTexto);
            lineas.add(linea);
        }
        lector.close();
        return new RedMetro(nombreRed, lineas);
    }

    // Método para procesar cada línea y extraer estaciones y trenes
    private static Linea procesarLinea(String lineaTexto) {
        // Separar la línea en nombre y estaciones
        String[] partes = lineaTexto.split(":");
        String nombreLinea = partes[0].trim().substring(1);  // Eliminar el guión inicial "-"

        String[] estacionesTexto = partes[1].split(">");  // Separar las estaciones
        List<Estacion> estaciones = new ArrayList<>();
        List<Tren> trenes = new ArrayList<>();

        for (String estacionTexto : estacionesTexto) {
            Estacion estacion = procesarEstacion(estacionTexto);
            estaciones.add(estacion);

            // Verificar si hay trenes en la estación
            if (estacionTexto.contains("*")) {
                Tren tren = procesarTren(estacionTexto, estacion);
                trenes.add(tren);
            }
        }

        return new Linea(nombreLinea, estaciones, trenes);
    }

    // Método para procesar una estación
    private static Estacion procesarEstacion(String estacionTexto) {
        String[] partes = estacionTexto.split("_");
        String nombreEstacion = partes[0].trim();

        String[] capacidadDatos = partes[1].split("/");  // Dividir la capacidad estación
        int capacidadMaximaEstacion = Integer.parseInt(capacidadDatos[0]);
        int capacidadActualEstacion = Integer.parseInt(capacidadDatos[1]);

        return new Estacion(nombreEstacion, capacidadMaximaEstacion, capacidadActualEstacion);
    }

    // Método para procesar un tren en una estación
    private static Tren procesarTren(String estacionTexto, Estacion estacion) {
        // Obtener la parte del tren: está después de "*" (tren presente)
        String[] partesTren = estacionTexto.split("\\*")[1].split("-");
        String[] capacidadTren = partesTren[0].split("/");

        int capacidadMaximaTren = Integer.parseInt(capacidadTren[0]);
        int pasajerosActualesTren = Integer.parseInt(capacidadTren[1]);

        // Detectar la dirección del tren
        int direccion = partesTren[1].startsWith("+") ? 1 : -1;

        return new Tren(capacidadMaximaTren, pasajerosActualesTren, direccion, estacion);
    }
}
