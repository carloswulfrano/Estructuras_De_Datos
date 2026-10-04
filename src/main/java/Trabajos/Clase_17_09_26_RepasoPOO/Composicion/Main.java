package Trabajos.Clase_17_09_26_RepasoPOO.Composicion;

import Trabajos.Clase_17_09_26_RepasoPOO.Perro;

public class Main {
    public static void main(String[] args) {

        Perro perro1 = new Perro();
        System.out.println(perro1);

        Perro perro2 = new Perro("Poddle",4 , true);
        System.out.println(perro2);
        perro2.setRaza("Chihuahua");
        System.out.println(perro2);

        System.out.println("-------");
        Procesador procesador = new Procesador("Intel", "Core i5", 3.0f);
        System.out.println(procesador);
        procesador.encender();

        System.out.println("----- COmpu  -----");
        Computadora comp1 = new Computadora("HP", "Pavilion", true, procesador,
                new Ram("Kingston","KN2000",32.0f),
                null
        );
        System.out.println(comp1);
        comp1.setTeclado( new Teclado("Logitech","GS101",101));
        System.out.println(comp1);

        System.out.println(" -- cambiar la vel del procesador --");
        comp1.getProcesador().setVelocidadGHz(3.4f);
        System.out.println(comp1);
        comp1.getRam().setCapacidadGB(128.0f);
        System.out.println(comp1);
        comp1.encender();
        System.out.println(comp1.getTeclado().getNumeroTeclas() );
        comp1.getProcesador().setVelocidadGHz(1.0f);
        System.out.println(comp1);





    }
}