package Trabajos.Clase_01_09_26;

public class Array2DADT <T>{
    private int filas;
    private int columnas;
    private Object[][] datos;

    public Array2DADT(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.datos = new Object[filas][columnas];
    }

    public T obtenerElemento(int fila, int columna) {
        if (indiceValido(fila, columna)) {
            return (T) datos[fila][columna];
        } else {
            System.out.println("Indice fuera de rango");
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public void insertarElemento(int fila, int columna, T elemento) {
        if (indiceValido(fila, columna)) {
            datos[fila][columna] = elemento;
        } else {
            System.out.println("Indice fuera de rango");
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    private boolean indiceValido(int fila, int columna) {
        return fila >= 0 && fila < filas && columna >= 0 && columna < columnas;
    }

    public int filas() {
        return filas;
    }

    public int columnas() {
        return columnas;
    }
}
