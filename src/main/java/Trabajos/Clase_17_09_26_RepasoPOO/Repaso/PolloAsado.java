package Trabajos.Clase_17_09_26_RepasoPOO.Repaso;

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

    public void cocinar(){
        System.out.println("Cocinando el pollo..." + this.nombre);
    }

    public void vender(){
        System.out.println("Vendiendo el pollo..." + this.nombre);
    }

}
