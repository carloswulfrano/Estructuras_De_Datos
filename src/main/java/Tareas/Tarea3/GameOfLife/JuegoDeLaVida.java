package Tareas.Tarea3.GameOfLife;

import Trabajos.Clase_01_09_26.Array2DADT;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class JuegoDeLaVida {

    private static final int VIVA = 1;
    private static final int MUERTA = 0;

    private Array2DADT<Integer> tablero;
    private int filas;
    private int columnas;

    // Lee la configuración inicial de población desde un archivo CSV
    // (cada celda debe ser 0 = muerta o 1 = viva)
    public boolean leerArchivo(String ruta) {
        File archivo = new File(ruta);

        try {
            // Primera pasada: contamos filas y columnas para saber el tamaño del tablero
            Scanner contadorLector = new Scanner(archivo);
            filas = 0;
            columnas = 0;

            while (contadorLector.hasNextLine()) {
                String linea = contadorLector.nextLine();
                if (!linea.trim().isEmpty()) {
                    if (filas == 0) {
                        columnas = linea.split(",").length;
                    }
                    filas++;
                }
            }
            contadorLector.close();

            tablero = new Array2DADT<>(filas, columnas);

            // Segunda pasada: ahora sí llenamos el tablero con los valores del archivo
            Scanner lector = new Scanner(archivo);
            int fila = 0;

            while (lector.hasNextLine()) {
                String linea = lector.nextLine();
                if (!linea.trim().isEmpty()) {
                    String[] campos = linea.split(",");
                    for (int columna = 0; columna < columnas; columna++) {
                        int valor = Integer.parseInt(campos[columna].trim());
                        tablero.insertarElemento(fila, columna, valor);
                    }
                    fila++;
                }
            }
            lector.close();
            return true;

        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el archivo.");
            System.out.println("Se buscó en: " + archivo.getAbsolutePath());
            return false;
        }
    }

    // Cuenta cuántos de los 8 vecinos de una celda están vivos.
    // Las celdas fuera del tablero se consideran muertas (no se envuelve el tablero).
    private int contarVecinosVivos(int fila, int columna) {
        int contador = 0;

        for (int df = -1; df <= 1; df++) {
            for (int dc = -1; dc <= 1; dc++) {
                if (df == 0 && dc == 0) {
                    continue; // no contamos la propia celda
                }

                int filaVecina = fila + df;
                int columnaVecina = columna + dc;

                if (filaVecina >= 0 && filaVecina < filas && columnaVecina >= 0 && columnaVecina < columnas) {
                    if (tablero.obtenerElemento(filaVecina, columnaVecina) == VIVA) {
                        contador++;
                    }
                }
            }
        }
        return contador;
    }

    // Calcula la siguiente generación aplicando las 4 reglas del juego
    public void siguienteGeneracion() {
        Array2DADT<Integer> nuevoTablero = new Array2DADT<>(filas, columnas);

        for (int fila = 0; fila < filas; fila++) {
            for (int columna = 0; columna < columnas; columna++) {
                int vecinosVivos = contarVecinosVivos(fila, columna);
                int estadoActual = tablero.obtenerElemento(fila, columna);
                int nuevoEstado;

                if (estadoActual == VIVA) {
                    if (vecinosVivos == 2 || vecinosVivos == 3) {
                        nuevoEstado = VIVA;   // Regla 1: sobrevive
                    } else {
                        nuevoEstado = MUERTA; // Reglas 2 y 3: muere por soledad o sobrepoblación
                    }
                } else {
                    if (vecinosVivos == 3) {
                        nuevoEstado = VIVA;   // Regla 4: nace
                    } else {
                        nuevoEstado = MUERTA; // Regla 4: sigue muerta
                    }
                }

                nuevoTablero.insertarElemento(fila, columna, nuevoEstado);
            }
        }

        // Reemplazamos el tablero viejo por el nuevo ya calculado
        tablero = nuevoTablero;
    }

    // Imprime el tablero actual: "O" para célula viva, "." para célula muerta
    public void imprimir() {
        for (int fila = 0; fila < filas; fila++) {
            for (int columna = 0; columna < columnas; columna++) {
                int estado = tablero.obtenerElemento(fila, columna);
                System.out.print(estado == VIVA ? "O " : ". ");
            }
            System.out.println();
        }
    }
}
