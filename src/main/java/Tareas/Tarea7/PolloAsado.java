package Tareas.Tarea7;

import java.util.Objects;

public class PolloAsado {
    private  String nombre;
    private float precio;
    private int piezas;
    private boolean complementos;

    public PolloAsado() {
    }

    public PolloAsado(String nombre, float precio, int piezas, boolean complementos) {
        this.nombre = nombre;
        this.precio = precio;
        this.piezas = piezas;
        this.complementos = complementos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getPiezas() {
        return piezas;
    }

    public void setPiezas(int piezas) {
        this.piezas = piezas;
    }

    public boolean isComplementos() {
        return complementos;
    }

    public void setComplementos(boolean complementos) {
        this.complementos = complementos;
    }

    @Override
    public String toString() {
        return "PolloAsado{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", piezas=" + piezas +
                ", complementos=" + complementos +
                '}';
    }

    //me lo dio la IA
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        PolloAsado otro = (PolloAsado) obj;

        return this.piezas == otro.piezas && this.complementos == otro.complementos
                && Float.compare(this.precio, otro.precio) == 0 && this.nombre.equals(otro.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(piezas, complementos, nombre);
    }



    public void cocinar(){
        System.out.println("Cocinando el pollo..." + this.nombre);
    }

    public void vender(){
        System.out.println("Vendiendo el pollo..." + this.nombre);
    }

}
