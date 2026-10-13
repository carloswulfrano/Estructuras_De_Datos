import Tareas.Tarea5.NodoTarea5;

void main() {
    NodoTarea5<String> head = new  NodoTarea5<>("Al", new NodoTarea5<>("B", new NodoTarea5<>("C", new NodoTarea5<>("De", new NodoTarea5<>("Mc", new NodoTarea5<>("Zi"))))));
    System.out.println(head);

    System.out.println("\n" + head.getDato());

    NodoTarea5<String> cursor = head;
    while (cursor.getSiguiente() != null){
        cursor = cursor.getSiguiente();
    }
    System.out.println("\n-----------Ultimo Nodo--------------");
    System.out.println(cursor);

    NodoTarea5<String> cursor2 = head;
    while (!(cursor2.getDato().equals("De"))){
        cursor2 = cursor2.getSiguiente();
    }
    NodoTarea5<String> rfMc = cursor2.getSiguiente();
    NodoTarea5<String> fe = new NodoTarea5<>("Fe",  rfMc);
    cursor2.setSiguiente(fe);
    System.out.println("\n----------Fe agregado despues de De----------------");
    System.out.println(head);

    NodoTarea5<String> cursor3 = head;
    while (cursor3.getSiguiente() != null){
        cursor3 = cursor3.getSiguiente();
    }
    cursor3.setSiguiente(new NodoTarea5<>("Zz"));
    System.out.println("\n--------------Zz al final de la lista----------------");
    System.out.println(head);

    NodoTarea5<String> rfAa = new NodoTarea5<>("Aa", head);
    head = rfAa;
    System.out.println("\n--------------Aa al inicio--------------");
    System.out.println(head);

}