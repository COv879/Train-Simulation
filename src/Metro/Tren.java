package Metro;

public class Tren {
    private int capacidadMaxima;
    private int pasajerosActuales;
    private int direccion;  // 1 para adelante, -1 para atrás
    private Estacion estacionActual;

    // Constructor
    public Tren(int capacidadMaxima, int pasajerosActuales, int direccion, Estacion estacionActual) {
        this.capacidadMaxima = capacidadMaxima;
        this.pasajerosActuales = pasajerosActuales;
        this.direccion = direccion;
        this.estacionActual = estacionActual;
    }

    // Métodos para mover el tren
    public void mover(Linea linea) {
        // Obtén la siguiente estación dependiendo de la dirección
        Estacion siguienteEstacion = linea.obtenerSiguienteEstacion(estacionActual, direccion);
        if (siguienteEstacion != null) {
            estacionActual = siguienteEstacion;
        } else {
            // Cambia de dirección si llegas al final de la línea
            direccion *= -1;
            estacionActual = linea.obtenerSiguienteEstacion(estacionActual, direccion);
        }
    }

    // Métodos para gestionar pasajeros
    public void subirPasajeros(int cantidad) {
        pasajerosActuales = Math.min(capacidadMaxima, pasajerosActuales + cantidad);
    }

    public void bajarPasajeros(int cantidad) {
        pasajerosActuales = Math.max(0, pasajerosActuales - cantidad);
    }

    // Getters
    public Estacion getEstacionActual() {
        return estacionActual;
    }

    public int getPasajerosActuales() {
        return pasajerosActuales;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public int getDireccion() {
        return direccion;
    }
}

