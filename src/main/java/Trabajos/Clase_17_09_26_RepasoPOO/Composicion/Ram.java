package Trabajos.Clase_17_09_26_RepasoPOO.Composicion;

public class Ram {

    private String marca;
    private String modelo;
    private float capacidadGB;

    public Ram() {
    }

    public Ram(String marca, String modelo, float capacidadGB) {
        this.marca = marca;
        this.modelo = modelo;
        this.capacidadGB = capacidadGB;
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

    public float getCapacidadGB() {
        return capacidadGB;
    }

    public void setCapacidadGB(float capacidadGB) {
        this.capacidadGB = capacidadGB;
    }

    @Override
    public String toString() {
        return "Ram{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", capacidadGB=" + capacidadGB +
                '}';
    }
}
