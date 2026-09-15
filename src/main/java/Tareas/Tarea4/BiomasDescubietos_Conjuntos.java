package Tareas.Tarea4;
import Trabajos.Clase_03_09_26.ConjuntoADT;

public class BiomasDescubietos_Conjuntos {

    static void main(String[] args) {

        //Conjunto inicial
        ConjuntoADT<String> biomasDescubiertos1 = new ConjuntoADT<>();

        biomasDescubiertos1.agregarElemento("Desierto");
        biomasDescubiertos1.agregarElemento("Taiga");
        biomasDescubiertos1.agregarElemento("Pantano");
        biomasDescubiertos1.agregarElemento("Desierto"); // ya existe, no se debe duplicar

        System.out.println("Biomas descubiertos del primer conjunto: " + biomasDescubiertos1);
        System.out.println("Cantidad de biomas distintos: " + biomasDescubiertos1.longitud());
        System.out.println("Descubrí Pantano? " + biomasDescubiertos1.contieneElemento("Pantano"));
        System.out.println("Descubrí Selva? " + biomasDescubiertos1.contieneElemento("Selva"));

        biomasDescubiertos1.eliminarElemento("Pantano");
        System.out.println("Eliminando Pantano: " + biomasDescubiertos1);

        //para probar con otro conjunto
        ConjuntoADT<String> biomasDescubiertos2 = new ConjuntoADT<>();
        biomasDescubiertos2.agregarElemento("Taiga");
        biomasDescubiertos2.agregarElemento("Selva");
        biomasDescubiertos2.agregarElemento("Sabana");

        System.out.println("\nBiomas del segundo conjunto: " + biomasDescubiertos2);

        ConjuntoADT<String> union = biomasDescubiertos1.union(biomasDescubiertos2);
        System.out.println("Unión (todos los biomas que los dos descubrieron): " + union);

        ConjuntoADT<String> interseccion = biomasDescubiertos1.interseccion(biomasDescubiertos2);
        System.out.println("Intersección (biomas que ambos descubrieron): " + interseccion);

        ConjuntoADT<String> diferencia = biomasDescubiertos1.diferencia(biomasDescubiertos2);
        System.out.println("Diferencia (los que hay en el primer conjunto y en el segundo no): " + diferencia);

        System.out.println("Los biomas de biomasDescubiertos1 son subconjunto de la unión? " + biomasDescubiertos1.esSubConjunto(union));

        //Prueba de equals
        ConjuntoADT<String> copiaExacta = new ConjuntoADT<>();
        copiaExacta.agregarElemento("Desierto");
        copiaExacta.agregarElemento("Taiga");

        System.out.println("biomasDescubiertos1 es igual a copiaExacta? " + biomasDescubiertos1.equals(copiaExacta));

    }
}

