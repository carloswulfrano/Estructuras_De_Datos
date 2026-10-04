import Tareas.Tarea7.ListaLigadaADT;
import Tareas.Tarea7.PolloAsado;

void main() {
    // pollos
    PolloAsado original = new PolloAsado("Pollo Original", 189.0f, 1, true);
    PolloAsado familiar = new PolloAsado("Pollo Familiar", 349.0f, 2, true);
    PolloAsado sinComplementos = new PolloAsado("Pollo Sin Complementos", 150.0f, 1, false);


    ListaLigadaADT<PolloAsado> lista = new ListaLigadaADT<>();
    lista.agregar(original);
    lista.agregar(familiar);
    lista.agregar(sinComplementos);

    System.out.println("---------Estado inicial---------");
    lista.transversal();
    System.out.println();
    System.out.println("Tamaño: " + lista.getTamanio());

    System.out.println("---------Esta Vacia---------");
    lista.estaVacia();

    System.out.println("\n---------Agregar al inicio---------");
    PolloAsado promo = new PolloAsado("Pollo Promoción", 99.0f, 1, false);
    lista.agregarAlInicio(promo);
    lista.transversal();
    System.out.println();

    System.out.println("\n---------Agregar después del familiar---------");
    PolloAsado extraPiezas = new PolloAsado("Pollo Extra Piezas", 420.0f, 3, true);
    lista.agregarDespuesDe(familiar, extraPiezas);
    lista.transversal();
    System.out.println();

    System.out.println("\n---------Buscar---------");
    System.out.println("Posición encontrada: " + lista.buscar(promo));

    System.out.println("\n---------Actualizar---------");
    PolloAsado actualizado = new PolloAsado("Pollo Original (actualizado)", 199.0f, 1, true);
    lista.actualizar(original, actualizado);
    lista.transversal();
    System.out.println();

    System.out.println("\n---------Eliminar el primero---------");
    lista.eliminarAlPrimero();
    lista.transversal();
    System.out.println();

    System.out.println("\n---------Eliminar el final---------");
    lista.eliminarFinal();
    lista.transversal();
    System.out.println();

    System.out.println("\nTamaño final: " + lista.getTamanio());
}
