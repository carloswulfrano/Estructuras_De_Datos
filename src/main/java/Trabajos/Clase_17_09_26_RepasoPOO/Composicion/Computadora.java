package Trabajos.Clase_17_09_26_RepasoPOO.Composicion;

public class Computadora {
    private String marca;
    private String modelo;
    private boolean esPortatil;
    private Procesador procesador;
    private Ram ram;
    private Teclado teclado;

    public Computadora() {
    }

    public Computadora(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public Computadora(String marca) {
        this.marca = marca;
    }

    public Computadora(String marca, String modelo, boolean esPortatil, Procesador procesador, Ram ram, Teclado teclado) {
        this.marca = marca;
        this.modelo = modelo;
        this.esPortatil = esPortatil;
        this.procesador = procesador;
        this.ram = ram;
        this.teclado = teclado;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public boolean isEsPortatil() {
        return esPortatil;
    }

    public void setEsPortatil(boolean esPortatil) {
        this.esPortatil = esPortatil;
    }

    public Procesador getProcesador() {
        return procesador;
    }

    public void setProcesador(Procesador procesador) {
        this.procesador = procesador;
    }

    public Ram getRam() {
        return ram;
    }

    public void setRam(Ram ram) {
        this.ram = ram;
    }

    public Teclado getTeclado() {
        return teclado;
    }

    public void setTeclado(Teclado teclado) {
        this.teclado = teclado;
    }

    @Override
    public String toString() {
        return "Computadora{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", esPortatil=" + esPortatil +
                ", procesador=" + procesador +
                ", ram=" + ram +
                ", teclado=" + teclado +
                '}';
    }

    public void encender(){
        procesador.encender();
        System.out.println("Encendiendo la computadora...");
    }

    public void apagar(){
        System.out.println("Apagando la computadora...");
    }
}
