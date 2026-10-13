package Extra.DataStructureExam.Arrays;

import java.util.Scanner;

public class Array {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero;
        String apellido1= "Labrada";

        String[] apellidos = new String[5];
        apellidos[0] = "Labrada";
        apellidos[1] = "Wulfrano";
        apellidos[2] = "Cruz";
        apellidos[3] = "García";
        apellidos[4] = "Navejas";

        for (int i = 0; i < apellidos.length; i++) {
            System.out.println(apellidos[i]);
        }

        float[] precios  = new float[3];
        for (int i = 0; i < precios.length; i++) {
            System.out.println("Ingrese precio " + (i + 1)+ ":");
            precios[i] = sc.nextFloat();
        }

        for (int i = 0; i < precios.length; i++) {
            System.out.println(precios[i]);
        }
    }
}
