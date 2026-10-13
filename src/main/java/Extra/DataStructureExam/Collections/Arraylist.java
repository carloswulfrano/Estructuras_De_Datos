package Extra.DataStructureExam.Collections;

import java.util.ArrayList;
import java.util.List;

public class Arraylist {
    static void main() {

        List<Persona> lista = new ArrayList<Persona>();
        lista.add(new Persona(1, "Carlos", 19));
        lista.add(new Persona(2, "Pedro", 23));
        lista.add(new Persona(3, "Juan", 69));
        lista.add(new Persona(4, "Julián", 12));

        System.out.println("------------FORI-----------------");
        //Imprimir por indice
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i).getNombre());
        }

        System.out.println("---------FOREACH-------------");
        //imprimir por foreach
        for (Persona persona : lista) {
            System.out.println(persona.getNombre() );
        }

        System.out.println("---------------toString------------");
        for (Persona persona : lista) {
            System.out.println(persona.toString());
        }

    }
}
