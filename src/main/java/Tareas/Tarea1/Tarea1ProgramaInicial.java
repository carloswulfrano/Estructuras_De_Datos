package Tareas.Tarea1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Tarea1ProgramaInicial {

    Scanner leer = new Scanner(System.in);
    ArrayList<String[]> datos = new ArrayList<>();
    boolean salir = false;

    // Índices de las columnas de meses dentro de cada fila
    // 0=RED SOCIAL, 1=CONCEPTO, 2=AÑO, 3=ENERO ... 14=DICIEMBRE
    static final int ENERO = 3;
    static final int JUNIO = 8;

    // Índices de las filas dentro del ArrayList (según el orden del CSV)
    static final int FILA_FACEBOOK_CRECIMIENTO = 1;
    static final int FILA_FACEBOOK_ME_GUSTA = 4;
    static final int FILA_TWITTER_SEGUIDORES = 7;
    static final int FILA_TWITTER_CRECIMIENTO = 8;
    static final int FILA_TWITTER_ME_GUSTA = 12;
    static final int FILA_YOUTUBE_VISUALIZACIONES = 15;
    static final int FILA_YOUTUBE_ME_GUSTA = 17;

    // ----------------------------------------------------------------
    // 1) LECTURA DEL ARCHIVO CSV Y CARGA EN EL ARRAYLIST
    // ----------------------------------------------------------------
    public boolean leerArchivo(String ruta) {
        try (BufferedReader lector = new BufferedReader(new FileReader(ruta))) {
            String linea;
            boolean primeraLinea = true;

            while ((linea = lector.readLine()) != null) {
                if (primeraLinea) {
                    primeraLinea = false; // Saltamos el encabezado
                    continue;
                }
                if (linea.trim().isEmpty()) {
                    continue;
                }
                // Separamos por comas
                String[] columnas = linea.split(",");
                datos.add(columnas);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            return false;
        }
        return true;
    }


    public void menu() {
        int opcion;
        do {
            System.out.println("=========================================================");
            System.out.println("Menú Principal - Redes Sociales");
            System.out.println("1.- Diferencia de seguidores de Twitter (enero-junio)");
            System.out.println("2.- Diferencia de visualizaciones de YouTube (meses a elegir)");
            System.out.println("3.- Promedio de crecimiento de Twitter y Facebook (enero-junio)");
            System.out.println("4.- Promedio de \"Me gusta\" de YouTube, Twitter y Facebook");
            System.out.println("5.- Salir");
            System.out.print("Seleccione una opción: ");
            opcion = leer.nextInt();

            switch (opcion) {
                case 1:
                    diferenciaSeguidoresTwitter();
                    continuarOSalir();
                    break;
                case 2:
                    diferenciaVisualizacionesYoutube();
                    continuarOSalir();
                    break;
                case 3:
                    promedioCrecimientoTwitterFacebook();
                    continuarOSalir();
                    break;
                case 4:
                    promedioMeGusta();
                    continuarOSalir();
                    break;
                case 5:
                    System.out.println("Saliendo del sistema...");
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (!salir);
    }


    public void continuarOSalir() {
        System.out.println("---------------------------------------------------------");
        System.out.println("1.- Hacer otra cosa");
        System.out.println("2.- Salir");
        System.out.print("Seleccione una opción: ");
        int opcion = leer.nextInt();

        if (opcion == 2) {
            System.out.println("Saliendo del sistema...");
            salir = true;
        }
    }

    // Convierte un valor de texto del CSV a número (quita comillas, % y comas)
    public double convertirANumero(String valor) {
        if (valor == null) return 0;
        String limpio = valor.replace("\"", "").replace("%", "").replace(",", "").trim();
        if (limpio.isEmpty()) return 0;
        try {
            return Double.parseDouble(limpio);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    // Convierte el nombre de un mes escrito por el usuario en el índice de columna
    public int indiceDeMes(String mes) {
        switch (mes.trim().toUpperCase()) {
            case "ENERO": return 3;
            case "FEBRERO": return 4;
            case "MARZO": return 5;
            case "ABRIL": return 6;
            case "MAYO": return 7;
            case "JUNIO": return 8;
            case "JULIO": return 9;
            case "AGOSTO": return 10;
            case "SEPTIEMBRE": return 11;
            case "OCTUBRE": return 12;
            case "NOVIEMBRE": return 13;
            case "DICIEMBRE": return 14;
            default: return -1;
        }
    }


    // OPCIÓN 1: Diferencia de seguidores de Twitter entre enero y junio
    public void diferenciaSeguidoresTwitter() {
        String[] fila = datos.get(FILA_TWITTER_SEGUIDORES);

        double seguidoresEnero = convertirANumero(fila[ENERO]);
        double seguidoresJunio = convertirANumero(fila[JUNIO]);
        double diferencia = seguidoresJunio - seguidoresEnero;

        System.out.println("\n--- Seguidores de Twitter ---");
        System.out.printf("Enero: %.2f%n", seguidoresEnero);
        System.out.printf("Junio: %.2f%n", seguidoresJunio);
        System.out.printf("Diferencia (junio - enero): %.2f%n", diferencia);
    }

    // OPCIÓN 2: Diferencia de visualizaciones de YouTube entre dos meses
    public void diferenciaVisualizacionesYoutube() {
        String[] fila = datos.get(FILA_YOUTUBE_VISUALIZACIONES);

        System.out.println("\nMeses disponibles: ENERO, FEBRERO, MARZO, ABRIL, MAYO, JUNIO, "
                + "JULIO, AGOSTO, SEPTIEMBRE, OCTUBRE, NOVIEMBRE, DICIEMBRE");

        leer.nextLine(); // Limpiamos el salto de línea pendiente del nextInt() del menú
        System.out.print("Escribe el primer mes: ");
        int mes1 = indiceDeMes(leer.nextLine());

        System.out.print("Escribe el segundo mes: ");
        int mes2 = indiceDeMes(leer.nextLine());

        if (mes1 == -1 || mes2 == -1) {
            System.out.println("Uno de los meses no es válido.");
            return;
        }

        double visualizaciones1 = convertirANumero(fila[mes1]);
        double visualizaciones2 = convertirANumero(fila[mes2]);
        double diferencia = visualizaciones2 - visualizaciones1;

        System.out.println("\n--- Visualizaciones de YouTube ---");
        System.out.printf("Mes 1: %.2f%n", visualizaciones1);
        System.out.printf("Mes 2: %.2f%n", visualizaciones2);
        System.out.printf("Diferencia (mes2 - mes1): %.2f%n", diferencia);
    }

    // OPCIÓN 3: Promedio de crecimiento de Twitter y Facebook (enero-junio)
    public void promedioCrecimientoTwitterFacebook() {
        String[] filaTwitter = datos.get(FILA_TWITTER_CRECIMIENTO);
        String[] filaFacebook = datos.get(FILA_FACEBOOK_CRECIMIENTO);

        double promedioTwitter = promedioEneroJunio(filaTwitter);
        double promedioFacebook = promedioEneroJunio(filaFacebook);

        System.out.println("\n--- Promedio de crecimiento (enero-junio) ---");
        System.out.printf("Twitter: %.2f%n", promedioTwitter);
        System.out.printf("Facebook: %.2f%n", promedioFacebook);
    }

    // OPCIÓN 4: Promedio de "Me gusta" de YouTube, Twitter y Facebook
    public void promedioMeGusta() {
        String[] filaYoutube = datos.get(FILA_YOUTUBE_ME_GUSTA);
        String[] filaTwitter = datos.get(FILA_TWITTER_ME_GUSTA);
        String[] filaFacebook = datos.get(FILA_FACEBOOK_ME_GUSTA);

        double promedioYoutube = promedioEneroJunio(filaYoutube);
        double promedioTwitter = promedioEneroJunio(filaTwitter);
        double promedioFacebook = promedioEneroJunio(filaFacebook);

        System.out.println("\n--- Promedio de 'Me gusta' (enero-junio) ---");
        System.out.printf("YouTube: %.2f%n", promedioYoutube);
        System.out.printf("Twitter: %.2f%n", promedioTwitter);
        System.out.printf("Facebook: %.2f%n", promedioFacebook);
    }

    // Calcula el promedio de una fila entre las columnas de enero y junio
    public double promedioEneroJunio(String[] fila) {
        double suma = 0;
        int cantidadMeses = JUNIO - ENERO + 1; // enero a junio = 6 meses

        for (int i = ENERO; i <= JUNIO; i++) {
            suma += convertirANumero(fila[i]);
        }
        return suma / cantidadMeses;
    }

}
