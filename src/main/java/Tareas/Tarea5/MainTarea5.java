import Tareas.Tarea5.NodoTarea5;

void main() {

    NodoTarea5 head = new NodoTarea5("Al", new NodoTarea5("B", new NodoTarea5("C", new NodoTarea5("De",
            new NodoTarea5("Mc", new NodoTarea5("Zi"))))));

    System.out.println(head);
    System.out.println(head.getDato());
    System.out.println(head.getSiguiente().getSiguiente().getSiguiente().getSiguiente().getSiguiente());

    NodoTarea5 valorFe = new NodoTarea5<>("Fe");
    valorFe.setSiguiente(head.getSiguiente().getSiguiente().getSiguiente().getSiguiente());
    head.getSiguiente().getSiguiente().getSiguiente().setSiguiente(valorFe);
    System.out.println("\n"+head);

    NodoTarea5 valorZz = new NodoTarea5<>("Zz");
    valorZz.setSiguiente(head.getSiguiente().getSiguiente().getSiguiente().getSiguiente().getSiguiente().getSiguiente().getSiguiente());
    head.getSiguiente().getSiguiente().getSiguiente().getSiguiente().getSiguiente().getSiguiente().setSiguiente(valorZz);
    System.out.println("\n"+head);

    NodoTarea5 valorAa = new NodoTarea5<>("Aa");
    valorAa.setSiguiente(head);
    head=valorAa;
    System.out.println("\n"+head);

}