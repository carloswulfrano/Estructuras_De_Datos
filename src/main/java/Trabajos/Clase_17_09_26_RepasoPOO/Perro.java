package Trabajos.Clase_17_09_26_RepasoPOO;

public class Perro {
    private String raza;
    private int edad;
    private boolean vacunado;

    public Perro(String raza) {
        this.raza = raza;
    }

    public Perro() {
    }

    public Perro(String raza, int edad, boolean vacunado) {
        this.raza = raza;
        this.edad = edad;
        this.vacunado = vacunado;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean isVacunado() {
        return vacunado;
    }

    public void setVacunado(boolean vacunado) {
        this.vacunado = vacunado;
    }

    @Override
    public String toString() {
        return "Perro{" +
                "raza='" + raza + '\'' +
                ", edad=" + edad +
                ", vacunado=" + vacunado +
                '}';
    }
}
