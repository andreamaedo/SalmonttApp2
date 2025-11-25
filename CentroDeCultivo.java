package model;

/**
 * Clase que representa un centro de cultivo de salmón.
 * Incluye validación básica en el constructor.
 */
public class CentroDeCultivo {

    private String nombre;
    private String comuna;
    private int toneladasProducidas;

    /**
     * Constructor del CentroDeCultivo.
     * @param nombre Nombre del centro (no puede ser nulo o vacío).
     * @param comuna Comuna donde se ubica el centro (no puede ser nulo o vacío).
     * @param toneladasProducidas Producción anual en toneladas (debe ser mayor o igual a cero).
     */
    public CentroDeCultivo(String nombre, String comuna, int toneladasProducidas) {
        // Validación básica de datos
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del centro no puede estar vacío.");
        }
        if (comuna == null || comuna.trim().isEmpty()) {
            throw new IllegalArgumentException("La comuna no puede estar vacía.");
        }
        if (toneladasProducidas < 0) {
            throw new IllegalArgumentException("Las toneladas producidas no pueden ser negativas.");
        }

        this.nombre = nombre.trim();
        this.comuna = comuna.trim();
        this.toneladasProducidas = toneladasProducidas;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getComuna() {
        return comuna;
    }

    public int getToneladasProducidas() {
        return toneladasProducidas;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public void setToneladasProducidas(int toneladasProducidas) {
        this.toneladasProducidas = toneladasProducidas;
    }

    /**
     * Retorna una representación legible del objeto.
     */
    @Override
    public String toString() {
        return String.format("| %-30s | %-15s | %,15d tons |", nombre, comuna, toneladasProducidas);
    }
}