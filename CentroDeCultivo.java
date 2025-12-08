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
        super(nombre, comuna);

        // Validación específica
        if (toneladasProducidas < 0) {
            throw new IllegalArgumentException("Las toneladas producidas no pueden ser negativas.");
        }

        this.toneladasProducidas = toneladasProducidas;
    }


    /**
     * Retorna una representación legible del objeto (Implementación polimórfica).
     */
    @Override
    public void mostrarInformacion() {
        System.out.printf("| %-30s | %-15s | %,15d tons |\n", nombre, comuna, toneladasProducidas);
    }
}
