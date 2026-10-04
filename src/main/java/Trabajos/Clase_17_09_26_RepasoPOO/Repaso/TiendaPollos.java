package Trabajos.Clase_17_09_26_RepasoPOO.Repaso;

import java.util.ArrayList;

public class TiendaPollos {
    public static void main(String[] args) {
        PolloAsado polloAsado = new PolloAsado();
        System.out.println(polloAsado);
        polloAsado.setNombre("Pollo Asado ranchero");
        polloAsado.setComplementos(true);
        System.out.println(polloAsado);
        polloAsado.cocinar();
        polloAsado.vender();
        System.out.println("----------");
        Box caja = new Box();
        caja.set(polloAsado);
        System.out.println(caja);
        Object cosa = caja.get();
        System.out.println(cosa);
        //cosa.vender();
        PolloAsado vendido = (PolloAsado) caja.get();
        vendido.vender();
        System.out.println("Usando genericos");
        Caja<PolloAsado> caja2 = new Caja<>();
        caja2.set(polloAsado);
        PolloAsado polloAsado2 = caja2.get();
        polloAsado2.vender();

        ArrayList<PolloAsado> pollos = new ArrayList<>();
         pollos.add(polloAsado);
         pollos.add(new PolloAsado("Pollo enchilado",10.0f,10,true));
         pollos.add(new PolloAsado("A la diabla",12.0f,10,true));
         System.out.println(pollos);


         ArrayList<String> nombres = new ArrayList<>();
         nombres.add("Juan");
         nombres.add("Pedro");
         nombres.add("Maria");
         System.out.println(nombres);



    }
}
