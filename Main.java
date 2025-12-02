package ui;

import data.GestorUnidades;
import model.UnidadOperativa;
import model.CentroDeCultivo;
import model.PlantaProceso;

import java.util.List;

/**
 * Clase principal que ejecuta el programa y muestra los resultados de la jerarquía de clases.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("==================================================");
        System.out.println("        SISTEMA DE GESTIÓN SALMONTT (v3.0)        ");
        System.out.println("==================================================");

        // 1. Crear instancias de prueba utilizando GestorUnidades
        GestorUnidades gestor = new GestorUnidades();
        List<UnidadOperativa> unidades = gestor.crearUnidadesDePrueba();

        if (unidades.isEmpty()) {
            System.out.println("No se crearon unidades operativas para mostrar.");
            return;
        }

        // 2. Mostrar los objetos creados por consola usando toString()
        System.out.println("\n--- JERARQUÍA DE UNIDADES OPERATIVAS CREADAS (" + unidades.size() + " en total) ---");

        // Impresión de Centros de Cultivo
        System.out.println("\nCENTROS DE CULTIVO (Subclase: Producción)");
        imprimirEncabezadoCentroCultivo();

        for (UnidadOperativa unidad : unidades) {
            if (unidad instanceof CentroDeCultivo) {
                // Se utiliza el toString() sobrescrito de CentroCultivo
                System.out.println(unidad.toString());
            }
        }
        System.out.println("----------------------------------------------------------------------");

        // Impresión de Plantas de Proceso
        System.out.println("\nPLANTAS DE PROCESO (Subclase: Capacidad)");
        imprimirEncabezadoPlantaProceso();

        for (UnidadOperativa unidad : unidades) {
            if (unidad instanceof PlantaProceso) {
                // Se utiliza el toString() sobrescrito de PlantaProceso
                System.out.println(unidad.toString());
            }
        }
        System.out.println("----------------------------------------------------------------------");

        System.out.println("\nFIN DEL PROCESO. La jerarquía de clases fue implementada y probada con éxito.");
    }

    private static void imprimirEncabezadoCentroCultivo() {
        System.out.println("----------------------------------------------------------------------");
        System.out.println("| Nombre del Centro               | Comuna          | Producción (tons) |");
        System.out.println("----------------------------------------------------------------------");
    }

    private static void imprimirEncabezadoPlantaProceso() {
        System.out.println("----------------------------------------------------------------------");
        System.out.println("| Nombre de la Planta             | Comuna          | Capacidad (tons)  |");
        System.out.println("----------------------------------------------------------------------");
    }
}
