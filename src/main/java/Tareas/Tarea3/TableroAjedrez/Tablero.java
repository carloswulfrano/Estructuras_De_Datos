package Tareas.Tarea3.TableroAjedrez;

import Trabajos.Clase_01_09_26.Array2DADT;

public class Tablero {

    private static final int TAMANIO = 8;

    // Piezas negras (van en la fila 8) - en el orden: torre, caballo, alfil, reina, rey, alfil, caballo, torre
    private static final String[] PIEZAS_NEGRAS = {"\u265C", "\u265E", "\u265D", "\u265B", "\u265A", "\u265D", "\u265E", "\u265C"};
    private static final String PEON_NEGRO = "\u265F"; // va en toda la fila 7

    // Piezas blancas (van en la fila 1), mismo orden que las negras
    private static final String[] PIEZAS_BLANCAS = {"\u2656", "\u2658", "\u2657", "\u2655", "\u2654", "\u2657", "\u2658", "\u2656"};
    private static final String PEON_BLANCO = "\u2659"; // va en toda la fila 2

    private static final String CASILLA_VACIA = " ";

    private Array2DADT<String> tablero;

    public Tablero() {
        tablero = new Array2DADT<>(TAMANIO, TAMANIO);
        colocarPiezasIniciales();
    }

    // Coloca todas las piezas en su posición inicial dentro del Array2DADT.
    // La fila 0 del arreglo representa la fila "8" del tablero, y la fila 7 representa la fila "1".
    private void colocarPiezasIniciales() {
        for (int columna = 0; columna < TAMANIO; columna++) {
            tablero.insertarElemento(0, columna, PIEZAS_NEGRAS[columna]); // fila 8
            tablero.insertarElemento(1, columna, PEON_NEGRO);             // fila 7

            for (int fila = 2; fila <= 5; fila++) {
                tablero.insertarElemento(fila, columna, CASILLA_VACIA);   // filas 6, 5, 4 y 3
            }

            tablero.insertarElemento(6, columna, PEON_BLANCO);             // fila 2
            tablero.insertarElemento(7, columna, PIEZAS_BLANCAS[columna]); // fila 1
        }
    }

    // Imprime el tablero en consola, con el número de fila del lado izquierdo (8 arriba, 1 abajo)
    public void imprimir() {
        for (int fila = 0; fila < TAMANIO; fila++) {
            int numeroFila = TAMANIO - fila; // fila 0 del arreglo -> se muestra como "8"
            System.out.print(numeroFila + "  ");

            for (int columna = 0; columna < TAMANIO; columna++) {
                System.out.print(tablero.obtenerElemento(fila, columna) + "  ");
            }
            System.out.println();
        }
    }

}
