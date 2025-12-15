package model;

/**
 * Clase que representa un centro de cultivo de salmón.
 * Hereda de UnidadOperativa e implementa Registrable.
 */
public class CentroDeCultivo extends UnidadOperativa implements Registrable {
    private int toneladasProducidas;

    public int getToneladasProducidas() {
        return toneladasProducidas;
    }

    public CentroDeCultivo(String nombre, String comuna, int toneladasProducidas) {
        super(nombre, comuna);

        if (toneladasProducidas < 0) {
            throw new IllegalArgumentException("Las toneladas producidas no pueden ser negativas.");
        }

        this.toneladasProducidas = toneladasProducidas;
    }

    // Implementación de la Interfaz Registrable
    @Override
    public void registrar() {
        System.out.println("[REGISTRO] Centro de cultivo '" + nombre + "' registrado.");
    }

    @Override
    public void mostrarResumen() {
        System.out.println("Resumen de Cultivo: " + nombre + " en " + comuna + ". Producción: " + toneladasProducidas + " tons.");
    }

    // Implementación polimórfica de UnidadOperativa
    @Override
    public void mostrarInformacion() {
        System.out.printf("| %-30s | %-15s | %,15d tons (Cultivo) |\n", nombre, comuna, toneladasProducidas);
    }
}
