package Trabajos.Clase_03_09_26;
import java.util.ArrayList;


public class ConjuntoADT <T>{
    private ArrayList<T> elementos;

    public ConjuntoADT() {
        this.elementos = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "ConjuntoADT{" +
                "elementos=" + elementos +
                '}';
    }

    public ArrayList<T> getElementos() {
        return elementos;
    }

    public void setElementos(ArrayList<T> elementos) {
        this.elementos = elementos;
    }

    public int longitud() {
        return elementos.size();
    }

    public boolean contieneElemento(T elemento) {
        return elementos.contains(elemento);
    }

    public void agregarElemento(T elemento) {
        if (!contieneElemento(elemento)) {
            elementos.add(elemento);
        }
    }

    public void eliminarElemento(T elemento) {
        elementos.remove(elemento);
    }

    public boolean equals(ConjuntoADT<T> otroConjunto) {
        if (this.longitud() != otroConjunto.longitud()) {
            return false;
        }
        for (T elemento : elementos) {
            if (!otroConjunto.contieneElemento(elemento)) {
                return false;
            }
        }
        return true;
    }

    public boolean esSubConjunto(ConjuntoADT<T> otroConjunto) {
        for (T elemento : elementos) {
            if (!otroConjunto.contieneElemento(elemento)) {
                return false;
            }
        }
        return true;
    }

    public ConjuntoADT<T> union(ConjuntoADT<T> otroConjunto) {
        ConjuntoADT<T> resultado = new ConjuntoADT<>();

        for (T elemento : this.elementos) {
            resultado.agregarElemento(elemento);
        }
        for (T elemento : otroConjunto.getElementos()) {
            resultado.agregarElemento(elemento);
        }

        return resultado;
    }

    public ConjuntoADT<T> interseccion(ConjuntoADT<T> otroConjunto) {
        ConjuntoADT<T> resultado = new ConjuntoADT<>();

        for (T elemento : this.elementos) {
            if (otroConjunto.contieneElemento(elemento)) {
                resultado.agregarElemento(elemento);
            }
        }

        return resultado;
    }

    public ConjuntoADT<T> diferencia(ConjuntoADT<T> otroConjunto) {
        ConjuntoADT<T> resultado = new ConjuntoADT<>();

        for (T elemento : this.elementos) {
            if (!otroConjunto.contieneElemento(elemento)) {
                resultado.agregarElemento(elemento);
            }
        }

        return resultado;
    }
}
