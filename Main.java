package ui;

import data.GestorUnidades;
import model.UnidadOperativa;
import java.util.List;

/**
 * Clase principal que ejecuta el programa y muestra los resultados de la jerarquía de clases.
 * Ahora aplica Polimorfismo y Colecciones Genéricas.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("==================================================");
        System.out.println("        SISTEMA DE GESTIÓN SALMONTT (v3.0)        ");
        System.out.println("==================================================");

        // 1. Crear instancias de prueba utilizando GestorUnidades
        GestorUnidades gestor = new GestorUnidades();
        // Colección Genérica (List) de la superclase (UnidadOperativa)
        List<UnidadOperativa> unidades = gestor.obtenerColeccionUnidades(); // <-- Llama al método ajustado

        if (unidades.isEmpty()) {
            System.out.println("No se crearon unidades operativas para mostrar.");
            return;
        }

        // 2. Mostrar los objetos creados por consola usando Polimorfismo (Paso 3)
        System.out.println("\n--- DETALLE DE UNIDADES OPERATIVAS (APLICANDO POLIMORFISMO) ---");
        imprimirEncabezado();

        // Recorre la colección usando la referencia de la Superclase
        for (UnidadOperativa unidad : unidades) {
            // Llama al método mostrarInformacion(). El método ejecutado (de CentroCultivo o PlantaProceso)
            // se determina automáticamente en tiempo de ejecución.
            unidad.mostrarInformacion();
        }

        System.out.println("----------------------------------------------------------------------");

        System.out.println("\nFIN DEL PROCESO. La jerarquía de clases fue implementada y probada con éxito.");
    }

    private static void imprimirEncabezado() {
        System.out.println("----------------------------------------------------------------------");
        System.out.println("| Nombre de la Unidad             | Comuna          | Detalle (tons)    |");
        System.out.println("----------------------------------------------------------------------");
    }


}
