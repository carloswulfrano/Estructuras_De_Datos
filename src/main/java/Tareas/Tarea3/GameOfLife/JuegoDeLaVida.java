package Tareas.Tarea3.GameOfLife;
import Trabajos.Clase_01_09_26.Array2DADT;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class JuegoDeLaVida {

    //constantes para despues comparar y saber si esta viva o muerta
    private static final int VIVA = 1;
    private static final int MUERTA = 0;

    private Array2DADT<Integer> tablero;
    private int filas;
    private int columnas;

    //para leer el archivo xddd
    public boolean leerArchivo(String ruta) {
        File archivo = new File(ruta);

        try {
            //primero leemos para saber el tamaño
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

            //leemos por segunda vez para rellenar con los datos
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

            //por si no se encuentra el arcvhio CSV
        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el archivo.");
            System.out.println("Se buscó en: " + archivo.getAbsolutePath());
            return false;
        }
    }


    private int contarVecinosVivos(int fila, int columna) {
        int contador = 0;

        for (int fil = -1; fil <= 1; fil++) {           //para moverse alrededor
            for (int colum = -1; colum <= 1; colum++) { //de la celda
                if (fil == 0 && colum == 0) {           //aca estas en la celda que se esta revisando
                    continue;                           //entonces no cuenta la misma celda
                }

                int filaVecina = fila + fil;
                int columnaVecina = columna + colum;

                //para saber si el vecino existe o no, en el caso de los bordes
                if (filaVecina >= 0 && filaVecina < filas && columnaVecina >= 0 && columnaVecina < columnas) {
                    if (tablero.obtenerElemento(filaVecina, columnaVecina) == VIVA) {
                        contador++;
                    }
                }
            }
        }
        return contador;
    }


    public void siguienteGeneracion() {
        //un tablero nuevo
        Array2DADT<Integer> nuevoTablero = new Array2DADT<>(filas, columnas);

        //dos for anidados para saber si esta viva la celda y cuantos vecinos vivos tiene
        for (int fila = 0; fila < filas; fila++) {
            for (int columna = 0; columna < columnas; columna++) {
                int vecinosVivos = contarVecinosVivos(fila, columna);
                int estadoActual = tablero.obtenerElemento(fila, columna);
                int nuevoEstado;

                if (estadoActual == VIVA) {
                    //regla 1: sobrevive
                    if (vecinosVivos == 2 || vecinosVivos == 3) {
                        nuevoEstado = VIVA;
                    } else {
                    //reglas 2 y 3: muere por soledad o sobrepoblación
                        nuevoEstado = MUERTA;
                    }
                } else {
                    //regla 4: nace
                    if (vecinosVivos == 3) {
                        nuevoEstado = VIVA;
                    } else {
                        nuevoEstado = MUERTA;
                    }
                }
                //se va guardando en el tablero nuevo
                nuevoTablero.insertarElemento(fila, columna, nuevoEstado);
            }
        }

        //reemplazamos el tablero viejo por el nuevp
        tablero = nuevoTablero;
    }


    public void imprimir() {

        //dos for anidados ppara mostrar si esta viva o muerta la celda
        for (int fila = 0; fila < filas; fila++) {
            for (int columna = 0; columna < columnas; columna++) {
                int estado = tablero.obtenerElemento(fila, columna);
                //aca usamos un operador ternario para saber si esta viava o muerta (usted lo enseño el semestre pasado en P.O.O.)
                System.out.print(estado == VIVA ? "O " : ". ");
            }
            System.out.println();
        }
    }
}
