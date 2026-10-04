import Tareas.Tarea5.NodoTarea5;

void main() {

    System.out.println("--------------Creación de lista enlazada e impresión del estado inicial-----------\n");
    NodoTarea5<String> head = new NodoTarea5("Al", new NodoTarea5("B", new NodoTarea5("C", new NodoTarea5("De", new NodoTarea5("Mc", new NodoTarea5("Zi"))))));
    System.out.println(head);

    System.out.println("\n--------Impresión del primer dato del primer nodo-------\n");
    System.out.println(head.getDato());

    System.out.println("\n------Impresión del estado completo del ultimo nodo-------\n");
    NodoTarea5 cursor = head;
    while (cursor.getSiguiente() != null){
        cursor = cursor.getSiguiente();
    }
    System.out.println(cursor);

    System.out.println("\n----------Insertar nodo con valor de Fe entre De y Mc----------\n");
    NodoTarea5 actual = head;
    while (!(actual.getDato().equals("De"))){
        actual = actual.getSiguiente();
    }
    NodoTarea5 rfMc = actual.getSiguiente();
    NodoTarea5 <String> fe = new NodoTarea5<>("Fe", rfMc);
    actual.setSiguiente(fe);
    System.out.println(head);

    System.out.println("\n--------Insertar Nodo con valor de Z al final-------------\n");
    NodoTarea5 tmp = head;
    while(tmp.getSiguiente() != null){
        tmp = tmp.getSiguiente();
    }

    NodoTarea5 rfNull =  tmp.getSiguiente();
    NodoTarea5 <String> Zz = new NodoTarea5<>("Zz", rfNull);
    tmp.setSiguiente(Zz);
    System.out.println(head);

    System.out.println("\n--------------Insertar nodo con valor de Aa al principio-----------\n");
    NodoTarea5 <String> Aa = new NodoTarea5<>("Aa", head);
    head = Aa;
    System.out.println(head);


}