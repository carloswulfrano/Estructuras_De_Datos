package Extra.DataStructureExam.Collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayListVSLinkedList {
    static void main(String[] args) {


        List<Persona> lista = new ArrayList<Persona>();
        lista.add(new Persona(1, "Carlos", 19));
        lista.add(new Persona(2, "Pedro", 23));
        lista.add(new Persona(3, "Juan", 69));
        lista.add(new Persona(4, "Julián", 12));


        List<Persona> listaLinked = new LinkedList<>();
        listaLinked.add(new Persona(1, "Carlos", 19));
        listaLinked.add(new Persona(2, "Pedro", 23));
        listaLinked.add(new Persona(3, "Juan", 69));
        listaLinked.add(new Persona(4, "Julián", 12));

        //remove en Arraylist
        lista.remove(1);

        //remove en Linked List
        String nombreBorrar = "Pedro";
        for (Persona p : listaLinked) {
            if (p.getNombre().equals(nombreBorrar)) {
                listaLinked.remove(p);
                break;
            }
        }

        System.out.println("---------Luego de elimiar-----------");
        System.out.println("ArrayList");
        for (Persona p : lista) {
            System.out.println(p);
        }

        System.out.println("LinkedList");
        for (Persona p : listaLinked) {
            System.out.println(p);
        }

        System.out.println("-----------Tamaño de las listas---------");
        System.out.println("ArrayList: " +  lista.size());
        System.out.println("LinkedList: " +  listaLinked.size());

        System.out.println("---Primer y ultimo objeto (Linked List)---");
        System.out.println("Primero de LinkedList: " + listaLinked.getFirst().toString());
        System.out.println("Ultimo LinkedList: " + listaLinked.getLast().toString());
    }
}
