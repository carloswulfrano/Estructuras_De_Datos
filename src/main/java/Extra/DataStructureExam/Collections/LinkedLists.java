package Extra.DataStructureExam.Collections;

import java.util.LinkedList;
import java.util.List;

public class LinkedLists {
    static void main(String[] args) {
        List<Persona> lista = new LinkedList<>();
        lista.add(new Persona(1, "Carlos", 19));
        lista.add(new Persona(2, "Pedro", 23));
        lista.add(new Persona(3, "Juan", 69));
        lista.add(new Persona(4, "Julián", 12));

        lista.add(0, new Persona(5, "Maria", 19));

        System.out.println("---------FOREACH-------------");
        //imprimir por foreach
        for (Persona persona : lista) {
            System.out.println(persona.getNombre() );
        }
    }
}
