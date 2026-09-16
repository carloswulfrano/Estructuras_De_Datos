package Tareas.Tarea5;


public class NodoTarea5 <T>{
    private T dato;
    private NodoTarea5<T> siguiente;

    public NodoTarea5() {
    }

    public NodoTarea5(T dato) {
        this.dato = dato;
    }

    public NodoTarea5(T dato, NodoTarea5<T> siguiente) {
        this.dato = dato;
        this.siguiente = siguiente;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public NodoTarea5<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoTarea5<T> siguiente) {
        this.siguiente = siguiente;
    }

    @Override
    public String toString() {
        return "Nodo{" +
                "dato=" + dato +
                ", siguiente=" + siguiente +
                '}';
    }
}
