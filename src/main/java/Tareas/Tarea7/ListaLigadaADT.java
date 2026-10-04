package Tareas.Tarea7;

public class ListaLigadaADT<T> {
    private Nodo<T> head;

    public ListaLigadaADT(){
        this.head = null;
    }

    //lo hice yo
    public boolean estaVacia(){
        if (this.head == null){
            System.out.println("Lista vacia");
            return true;
        }else {
            System.out.println("La lista no esta vacia, tiene estos datos: " + head);
            return false;
        }

    }

    //lo hizo el prof
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

    //lo hizo el prof
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

    //lo hice yo
    public void agregarAlInicio(T dato){
        if(head == null){
            this.head = new Nodo<>(dato);
        }else {
            Nodo<T> actual = new Nodo<>(dato,  head);
            head = actual;
        }
    }

    //lo hizo el prof
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

    //lo hice yo
    public void eliminarAlPrimero(){
        if(head == null){
            System.out.println("Vacia");
        }else {
            this.head = this.head.getSiguiente();
            //hacemos que el head empiece con el segundo valor
        }
    }

    //lo hice yop
    public void eliminarFinal() {
        if (head == null) {
            System.out.println("Vacia");
        } else if (head.getSiguiente() ==null){
            head = null; //si la lista solo tiene un valor, pues ese lo convertimos en null, o sea, lo eliminammos xd
        }else{
            Nodo<T> actual = this.head;
            while(actual.getSiguiente().getSiguiente() != null){ //aca dos .getSiguiente para detenernos dos antes del valor null
                actual = actual.getSiguiente();                  //entonces ponemos en null el ultimo valor desde el peunultimos, pues si xd
            }
            actual.setSiguiente(null); //aca se pone nulo
        }
    }

    //lo hice yo
    public int buscar(T dato){
        if (head == null){
            System.out.println("Vacia");
            return -1; //si pongo 0, cuenta como una posición, entonce -1
        }else {
            Nodo<T> actual = this.head;
            int posicion = 0;
            while(actual != null){
                if (actual.getDato().equals(dato)){ //cuando el if tenga el dato que queremos
                    return posicion;                //vamos a imprimir la posición
                }
                actual = actual.getSiguiente();
                posicion++; //contador para que aumente mientras buscamos el valor que queremos
            }
        }
        return -1;
    }

    //lo hizo el prof
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

    //lo hizo el prof
    public void transversal(){
        if(head == null){
            System.out.println("Vacia");
        }else {
            Nodo<T> actual = head;
            do{
                System.out.print("|" + actual.getDato());
                actual = actual.getSiguiente();
            }while(actual != null);
        }
    }
}
