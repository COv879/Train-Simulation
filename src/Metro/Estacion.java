package Metro;

public class Estacion {
    private String nombre;
    private int capacidadMaxima;
    private int pasajerosActuales;

    // Constructor
    public Estacion(String nombre, int capacidadMaxima, int pasajerosActuales) {
        this.nombre = nombre;
        this.capacidadMaxima = capacidadMaxima;
        this.pasajerosActuales = pasajerosActuales;
    }

    // Métodos para gestionar pasajeros
    public void agregarPasajeros(int cantidad) {
        this.pasajerosActuales = Math.min(this.capacidadMaxima, this.pasajerosActuales + cantidad);
    }

    public void quitarPasajeros(int cantidad) {
        this.pasajerosActuales = Math.max(0, this.pasajerosActuales - cantidad);
    }

    // Getter y setter
    public String getNombre() {
        return nombre;
    }

    public int getPasajerosActuales() {
        return pasajerosActuales;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public String getCapacidadActual() {
        return String.valueOf(pasajerosActuales) + "/" + String.valueOf(capacidadMaxima);
    }

}
