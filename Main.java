package ui;

import data.GestorDatos;
import model.CentroDeCultivo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Clase principal que inicializa el sistema, carga, recorre y filtra los datos.
 * Cumple con los requisitos de la Fase 2 del encargo de Salmontt.
 */
public class Main {

    private static final int UMBRAL_PRODUCCION = 2000; // Definición del umbral para el filtro

    public static void main(String[] args) {

        List<CentroDeCultivo> centrosDeCultivo = new ArrayList<>();
        System.out.println("==================================================");
        System.out.println("        SISTEMA DE GESTIÓN SALMONTT (v2.0)        ");
        System.out.println("==================================================");


        // 1. CARGA DE DATOS DESDE ARCHIVO
        GestorDatos gestor = new GestorDatos();
        List<CentroDeCultivo> centrosArchivo = gestor.leerCentrosDeCultivo();

        if (centrosArchivo.isEmpty()) {
            System.out.println("=> RESULTADO: No se pudieron cargar centros desde el archivo.");
        } else {
            System.out.println("=> RESULTADO: Se cargaron " + centrosArchivo.size() + " centros válidos desde el archivo.");
            centrosDeCultivo.addAll(centrosArchivo); // Añade los centros del archivo
        }

        System.out.println("\n--- Creación y Adición Manual de Objetos (con Validación) ---");

        // Constructor: CentroDeCultivo(String nombre, String comuna, int toneladasProducidas)
        try {
            // Centros válidos
            centrosDeCultivo.add(new CentroDeCultivo("Aysén Principal", "Puerto Aysén", 2500));
            centrosDeCultivo.add(new CentroDeCultivo("Isla Dawson", "Punta Arenas", 1800));
            centrosDeCultivo.add(new CentroDeCultivo("Melinka Oeste", "Guaitecas", 3100));

            // Ejemplo de centro con datos no válidos
            // centrosDeCultivo.add(new CentroDeCultivo(null, "Puerto Montt", 500));

            System.out.println("Se agregaron 3 centros de cultivo manualmente.");
        } catch (IllegalArgumentException e) {
            System.err.println("Error al agregar centro manual: " + e.getMessage());
        }

        System.out.println("\n==================================================");


        if (centrosDeCultivo.isEmpty()) {
            System.out.println("La lista final está vacía. El sistema no tiene datos para procesar.");
            return; // Termina si la lista final está vacía
        }

        // 2. MUESTRA TODOS LOS ELEMENTOS DE LA COLECCIÓN (Recorrido)
        System.out.println("\n2. RECORRIDO COMPLETO: Total de " + centrosDeCultivo.size() + " Centros de Cultivo");
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("| Nombre del Centro               | Comuna          | Producción (tons)   |");
        System.out.println("----------------------------------------------------------------------------------");
        for (CentroDeCultivo centro : centrosDeCultivo) {
            System.out.println(centro.toString());
        }
        System.out.println("----------------------------------------------------------------------------------");


        // 3. FILTRA SEGÚN UNA CONDICIÓN
        // Condición: Producción de Toneladas mayor o igual a UMBRAL_PRODUCCION (2000 tons)
        List<CentroDeCultivo> centrosConAltaProduccion = centrosDeCultivo.stream()
                .filter(centro -> centro.getToneladasProducidas() >= UMBRAL_PRODUCCION)
                .collect(Collectors.toList());

        System.out.println("\n3. FILTRO: Centros con Producción Mayor o Igual a " + UMBRAL_PRODUCCION + " tons");
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("| Nombre del Centro               | Comuna          | Producción (tons)   |");
        System.out.println("----------------------------------------------------------------------------------");
        if (centrosConAltaProduccion.isEmpty()) {
            System.out.println("No se encontraron centros que cumplan con la condición.");
        } else {
            for (CentroDeCultivo centro : centrosConAltaProduccion) {
                System.out.println(centro.toString());
            }
        }
        System.out.println("----------------------------------------------------------------------------------");

        System.out.println("\nFIN DEL PROCESO. Sistema funcionando con carga, recorrido y filtrado.");
    }

    /**
     * Función para imprimir el encabezado de las tablas.
     */
    private static void imprimirEncabezado() {
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("| Nombre del Centro               | Comuna          | Producción (tons)   |");
        System.out.println("----------------------------------------------------------------------------------");
    }
}