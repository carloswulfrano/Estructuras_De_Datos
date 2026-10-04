package Trabajos.Clase_17_09_26_RepasoPOO.Composicion;

public class Teclado {
    private String marca;
    private String modelo;
    private int numeroTeclas;

    public Teclado() {
    }

    public Teclado(String marca, String modelo, int numeroTeclas) {
        this.marca = marca;
        this.modelo = modelo;
        this.numeroTeclas = numeroTeclas;
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

    public int getNumeroTeclas() {
        return numeroTeclas;
    }

    public void setNumeroTeclas(int numeroTeclas) {
        this.numeroTeclas = numeroTeclas;
    }

    @Override
    public String toString() {
        return "Teclado{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", numeroTeclas=" + numeroTeclas +
                '}';
    }
}
