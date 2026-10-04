package Trabajos.Clase_17_09_26_RepasoPOO.Composicion;

public class Procesador {

    private String marca;
    private String modelo;
    private float velocidadGHz;

    public Procesador() {
    }

    public Procesador(String marca, String modelo, float velocidadGHz) {
        this.marca = marca;
        this.modelo = modelo;
        this.velocidadGHz = velocidadGHz;
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

    public float getVelocidadGHz() {
        return velocidadGHz;
    }

    public void setVelocidadGHz(float velocidadGHz) {
        this.velocidadGHz = velocidadGHz;
    }

    @Override
    public String toString() {
        return "Procesador{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", velocidadGHz=" + velocidadGHz + " GHz " +
                '}';
    }

    public boolean encender(){
        System.out.println("Encendiendo el procesador...");
        return true;
    }

}
