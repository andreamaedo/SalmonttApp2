package model;

/**
 * Clase que representa un centro de cultivo de salmón.
 * Hereda de UnidadOperativa.
 */
public class CentroDeCultivo extends UnidadOperativa { // <-- Herencia establecida
    private int toneladasProducidas;

    public int getToneladasProducidas() {
        return toneladasProducidas;
    }

    /**
     * Constructor del CentroDeCultivo.
     */
    public CentroDeCultivo(String nombre, String comuna, int toneladasProducidas) {
        // La llamada a super DEBE ser la primera línea.
        super(nombre, comuna);

        // Validación específica
        if (toneladasProducidas < 0) {
            throw new IllegalArgumentException("Las toneladas producidas no pueden ser negativas.");
        }

        this.toneladasProducidas = toneladasProducidas;
    }


    /**
     * Retorna una representación legible del objeto.
     */
    @Override
    public String toString() {
        // Accede a 'nombre' y 'comuna' gracias al 'protected' en la superclase
        return String.format("| %-30s | %-15s | %,15d tons |", nombre, comuna, toneladasProducidas);
    }
}
