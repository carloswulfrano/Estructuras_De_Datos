package Tareas.Tarea7;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }

        Perro perro = (Perro) o;
        return this.edad == perro.edad && this.vacunado == perro.vacunado  && Objects.equals(this.raza, perro.raza);
    }
}
