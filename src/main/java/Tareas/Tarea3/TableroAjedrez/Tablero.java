package Tareas.Tarea3.TableroAjedrez;
import Trabajos.Clase_01_09_26.Array2DADT;

public class Tablero {

    private static final int LADOTABLERO = 8;

    //piezas negras
    private static final String[] PIEZAS_NEGRAS = {"\u265C", "\u265E", "\u265D", "\u265B", "\u265A", "\u265D", "\u265E", "\u265C"};
    private static final String PEON_NEGRO = "\u265F";

    //piezas blancas
    private static final String[] PIEZAS_BLANCAS = {"\u2656", "\u2658", "\u2657", "\u2655", "\u2654", "\u2657", "\u2658", "\u2656"};
    private static final String PEON_BLANCO = "\u2659";

    private static final String CASILLA_VACIA = " ";
    private Array2DADT<String> tablero;


    public Tablero() {
        tablero = new Array2DADT<>(LADOTABLERO, LADOTABLERO);
        colocarPiezasIniciales();
    }


    private void colocarPiezasIniciales() {
        for (int columna = 0; columna < LADOTABLERO; columna++) {
                tablero.insertarElemento(0, columna, PIEZAS_NEGRAS[columna]); //fila 1 (o sea, 8)
                tablero.insertarElemento(1, columna, PEON_NEGRO); //fila 2 (o sea, 7)

            for (int fila = 2; fila <= 5; fila++) {
                tablero.insertarElemento(fila, columna, CASILLA_VACIA); //filas 3, 4, 5 y 6 (o sea, 6, 5, 4 y 3)
            }

            tablero.insertarElemento(6, columna, PEON_BLANCO); //fila 7 (o sea, 2)
            tablero.insertarElemento(7, columna, PIEZAS_BLANCAS[columna]); //fila 8 (o sea, 1)
        }
    }


    public void imprimir() {
        for (int fila = 0; fila < LADOTABLERO; fila++) {
                int numeroFila = LADOTABLERO - fila; //para que la fila 0 se muestre como 8
                System.out.print(numeroFila + "  ");

                 for (int columna = 0; columna < LADOTABLERO; columna++) {
                    System.out.print(tablero.obtenerElemento(fila, columna) + "  ");
                 }

            System.out.println();
        }
    }

}
