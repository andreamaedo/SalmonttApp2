package data;

import model.CentroDeCultivo;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase encargada de la lectura de datos desde un archivo plano.
 */
public class GestorDatos {

    private static final String RUTA_ARCHIVO = "centros_cultivo.txt";

    /**
     * Lee y parsea los Centros de Cultivo desde el archivo.
     * @return Una lista de objetos CentroDeCultivo válidos.
     */
    public List<CentroDeCultivo> leerCentrosDeCultivo() {
        List<CentroDeCultivo> centros = new ArrayList<>();
        BufferedReader br = null;
        int lineNumber = 0;

        try {
            br = new BufferedReader(new FileReader(RUTA_ARCHIVO));
            String linea;

            while ((linea = br.readLine()) != null) {
                lineNumber++;
                String[] datos = linea.split(";");

                if (datos.length == 3) {
                    try {
                        String nombre = datos[0].trim();
                        String comuna = datos[1].trim();
                        int toneladas = Integer.parseInt(datos[2].trim());

                        CentroDeCultivo centro = new CentroDeCultivo(nombre, comuna, toneladas);
                        centros.add(centro);
                    } catch (NumberFormatException e) {
                        System.err.println("[Error de Datos] Línea " + lineNumber + ": La producción debe ser un número entero. -> " + linea);
                    } catch (IllegalArgumentException e) {
                        System.err.println("[Error de Validación] Línea " + lineNumber + ": " + e.getMessage() + " -> " + linea);
                    }
                } else {
                    System.err.println("[Error de Formato] Línea " + lineNumber + ": Línea ignorada, se esperaban 3 campos separados por ';'. -> " + linea);
                }
            }
        } catch (IOException e) {
            System.err.println("[Error de Archivo] No se pudo leer '" + RUTA_ARCHIVO + "'. Asegúrese de que el archivo existe en la raíz del proyecto. Mensaje: " + e.getMessage());
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    // Ignora error al cerrar
                }
            }
        }
        return centros;
    }
}
