package Trabajos.Clase_29_09_26;

public class ListaLigadaADT<T> {
    private Nodo<T> head;

    public ListaLigadaADT(){
        this.head = null;
    }

    public void agregar(T dato){
        if(head == null){
            this.head = new Nodo<>(dato);
        }else{
            Nodo<T> actual = head;
            while(actual.getSiguiente() != null){
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(new Nodo<>(dato));

        }
    }

    public void transversal(){
        if(head == null){
            System.out.println("Vacia");
        }else {
            Nodo<T> actual = head;
 //           while (actual.getSiguiente() != null) {
 //               System.out.print("|" + actual.getDato());
  //              actual = actual.getSiguiente();
 //           }
            do{
                System.out.print("|" + actual.getDato());
                actual = actual.getSiguiente();
            }while(actual != null);
        }
    }

    public void actualizar(T aBuscar, T nuevoValor){
        if(head == null){
            System.out.println("Vacia");
        }else{
            Nodo<T> actual = this.head;
            while(!actual.getDato().equals(aBuscar)){
                actual = actual.getSiguiente();
            }
            actual.setDato(nuevoValor);
        }
    }
    public int getTamanio(){
        int contador = 0;
        if(head == null){
            return contador;
        }else {
            Nodo<T> actual = head;
            do{
                contador++;
                actual = actual.getSiguiente();
            }while(actual != null);
            return contador;
        }
    }
    public void agregarDespuesDe(T referencia, T valor ){
        if(head == null){
            System.out.println("Vacia");
        }else{
            Nodo<T> actual = this.head;
            while(!actual.getDato().equals(referencia)){
                actual = actual.getSiguiente();
            }
            Nodo<T> nuevoNodo = new Nodo<>(valor, actual.getSiguiente());
            actual.setSiguiente(nuevoNodo);
        }
    }
}
