package ui;

import data.GestorUnidades;
import data.GestorEntidades;
import model.UnidadOperativa;
import java.util.List;

/**
 * Clase principal que ejecuta el programa y muestra los resultados de la jerarquía de clases.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("==================================================");
        System.out.println("        SISTEMA DE GESTIÓN SALMONTT (v3.0)        ");
        System.out.println("==================================================");

        // 1. Mostrar Colección de Unidades Operativas (Herencia/Polimorfismo)

        GestorUnidades gestorUnidades = new GestorUnidades();

        List<UnidadOperativa> unidades = gestorUnidades.obtenerColeccionUnidades();

        if (!unidades.isEmpty()) {

            // 2. Mostrar los objetos creados usando Polimorfismo
            System.out.println("\n--- DETALLE DE UNIDADES OPERATIVAS (POLIMORFISMO EN ACCIÓN) ---");
            imprimirEncabezado();

            // Recorre la colección usando la referencia de la Superclase
            for (UnidadOperativa unidad : unidades) {
                unidad.mostrarInformacion();
            }
            System.out.println("----------------------------------------------------------------------");
        }

        // 3. Demostración de Interfaz Registrable e Instanceof
        GestorEntidades.demostrarPolimorfismoRegistrable();

        System.out.println("\nFIN DEL PROCESO. La jerarquía de clases fue implementada y probada con éxito.");
    }

    private static void imprimirEncabezado() {
        System.out.println("----------------------------------------------------------------------");
        System.out.println("| Nombre de la Unidad             | Comuna          | Detalle (tons)    |");
        System.out.println("----------------------------------------------------------------------");
    }
}
