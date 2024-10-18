package Metro;

import java.util.List;

public class Linea {
    private String nombre;
    private List<Estacion> estaciones;
    private List<Tren> trenes;

    // Constructor
    public Linea(String nombre, List<Estacion> estaciones, List<Tren> trenes) {
        this.nombre = nombre;
        this.estaciones = estaciones;
        this.trenes = trenes;
    }

    // Mover trenes a la siguiente estación
    public void moverTrenes() {
        for (Tren tren : trenes) {
            tren.mover(this);
        }
    }

    // Obtener la siguiente estación en la dirección del tren
    public Estacion obtenerSiguienteEstacion(Estacion estacionActual, int direccion) {
        int index = estaciones.indexOf(estacionActual);
        if (index != -1) {
            int nuevoIndex = index + direccion;
            if (nuevoIndex >= 0 && nuevoIndex < estaciones.size()) {
                return estaciones.get(nuevoIndex);
            }
        }
        return null;  // Si no hay una estación siguiente (al final de la línea)
    }

    // Métodos adicionales como getters
    public String getNombre() {
        return nombre;
    }

    public List<Estacion> getEstaciones() {
        return estaciones;
    }

    // En la clase Linea
    public List<Tren> getTrenes() {
        return trenes;
    }

}
