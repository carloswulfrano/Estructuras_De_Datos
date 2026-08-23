package Tareas.Tarea1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Tarea1ProgramaInicial {

    Scanner leer = new Scanner(System.in);
    ArrayList<String[]> datos = new ArrayList<>(); //Para guardar los datos (columnas) de cada fila del CSV
    boolean salir = true; //Para el menu que implemente

    //Índices de las columnas de meses dentro de cada fila del arraylist, solo de los meses que se van a ocupar en la opción 1 y 3 del trabajo
    static final int ENERO = 3;
    static final int JUNIO = 8;

    //Índices de las filas que voy a ocupar dentro del ArrayList
    static final int FILA_FACEBOOK_CRECIMIENTO = 2;
    static final int FILA_FACEBOOK_ME_GUSTA = 5;
    static final int FILA_TWITTER_SEGUIDORES = 8;
    static final int FILA_TWITTER_CRECIMIENTO = 9;
    static final int FILA_TWITTER_ME_GUSTA = 13;
    static final int FILA_YOUTUBE_VISUALIZACIONES = 16;
    static final int FILA_YOUTUBE_ME_GUSTA = 18;


    //Metodo para iniciar el programa leyendo el archivo, si sale bien, te manda al menu
    public void iniciar() {
        if (leerArchivo("datos_redes_sociales.csv")) {
            menu();
        }
    }


    //Metodo para leer el archivo CSV e irlo guardando en el arraylist
    public boolean leerArchivo(String ruta) {
        File archivo = new File(ruta);

        //Acá se abre el archivo, y lee con el Scanner lo que hay en archivo
        //Se pone en un try por si falla el archivo
        try {
            Scanner lectorArchivo = new Scanner(archivo);

            //ciclo para leer las filas e ir guardando dato por dato del CSV
            while (lectorArchivo.hasNextLine()) { //hacerlo miestras haya filas por leer
                String linea = lectorArchivo.nextLine();  //lee la fila completa
                if (!linea.trim().isEmpty()) {  //hace lo que hay en el if si la fila no esta vacia, además quita ls espacios
                    String[] columnas = linea.split(","); //alamacena los datos de la fila en columnas, los datos se almacenan cada que hay una coma (,)
                    datos.add(columnas); //el arreglo que se hizo se almacena al final del arraylist
                }
            }
            return true; //salio bien

        } catch (FileNotFoundException e) { //error por si falla el archivo
            System.out.println("No se encontró el archivo.");
            System.out.println(e.getMessage());
            return false;
        }
    }


    //Metodo para menú
    public void menu() {
        int opcion;
        do {
            System.out.println("=========================================================");
            System.out.println("                     Menú Principal");
            System.out.println("1.- Diferencia de seguidores de Twitter (enero-junio)");
            System.out.println("2.- Diferencia de visualizaciones de YouTube (meses a elegir)");
            System.out.println("3.- Promedio de crecimiento de Twitter y Facebook (enero-junio)");
            System.out.println("4.- Promedio de Me gusta de YouTube, Twitter y Facebook");
            System.out.println("5.- Salir");
            System.out.print("Seleccione una opción: ");
            opcion = leer.nextInt();

            switch (opcion) {
                case 1:
                    diferenciaSeguidoresTwitter();
                    break;
                case 2:
                    diferenciaVisualizacionesYoutube();
                    break;
                case 3:
                    promedioCrecimientoTwitterFacebook();
                    break;
                case 4:
                    promedioMeGusta();
                    break;
                case 5:
                    System.out.println("Saliendo del sistema...");
                    salir = false;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (salir);
    }


    //Mini menú que aparece después de cada opción
    public void continuarOSalir() {
        System.out.println("---------------------------------------------------------");
        System.out.println("1.- Hacer otra cosa");
        System.out.println("2.- Salir");
        System.out.print("Seleccione una opción: ");
        int opcion = leer.nextInt();

        switch (opcion) {
            case 1:
                menu();
                break;
            case 2:
                System.out.println("Saliendo del sistema...");
                salir = false;
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }


    //Metodo para la primera opción del menú
    public void diferenciaSeguidoresTwitter() {
        String[] fila = datos.get(FILA_TWITTER_SEGUIDORES); //Obtiene el arreglo guaradado

        //guarda los valores correspondientes a variables locales, para hacer la operación
        double seguidoresEnero = convertirANumero(fila[ENERO]); //ocupa el metodo para convertir el texto en número y lo guarda en la variable
        double seguidoresJunio = convertirANumero(fila[JUNIO]);
        double diferencia = seguidoresJunio - seguidoresEnero;

        System.out.println("\n---Seguidores de Twitter---");
        System.out.printf("Enero: %.2f%n", seguidoresEnero);
        System.out.printf("Junio: %.2f%n", seguidoresJunio);
        System.out.printf("Diferencia: %.2f%n", diferencia);

        continuarOSalir(); //mini menú
    }


    //Metodo para la segunda opción del menú
    public void diferenciaVisualizacionesYoutube() {
        String[] fila = datos.get(FILA_YOUTUBE_VISUALIZACIONES); //Obtiene el arreglo guaradado

        System.out.println("\nMeses disponibles: ENERO, FEBRERO, MARZO, ABRIL, MAYO, JUNIO, " +
                "JULIO, AGOSTO, SEPTIEMBRE, OCTUBRE, NOVIEMBRE, DICIEMBRE");

        leer.nextLine(); //Limpiamos el salto de línea pendiente del nextInt() del menú
        System.out.print("Escribe el primer mes: ");
        int mes1 = indiceDeMes(leer.nextLine()); //Ocupamos el metodo para convertir meses en indices

        System.out.print("Escribe el segundo mes: ");
        int mes2 = indiceDeMes(leer.nextLine());

        //termina el metodo por si un mes invalido
        if (mes1 == -1 || mes2 == -1) {
            System.out.println("Uno de los meses no es válido.");
            return;
        }

        double visualizaciones1 = convertirANumero(fila[mes1]);
        double visualizaciones2 = convertirANumero(fila[mes2]);
        double diferencia = visualizaciones2 - visualizaciones1;

        System.out.println("\n---Visualizaciones de YouTube---");
        System.out.printf("Mes 1: %.2f%n", visualizaciones1);
        System.out.printf("Mes 2: %.2f%n", visualizaciones2);
        System.out.printf("Diferencia: %.2f%n", diferencia);

        continuarOSalir();
    }


    //Metodo para la tercera opción del menú
    public void promedioCrecimientoTwitterFacebook() {
        String[] filaTwitter = datos.get(FILA_TWITTER_CRECIMIENTO); //Obtiene el arreglo guaradado
        String[] filaFacebook = datos.get(FILA_FACEBOOK_CRECIMIENTO); //Obtiene el arreglo guaradado

        //Mete los datos del arreglo al metodo del promedio, para calcularlos
        double promedioTwitter = promedioEneroJunio(filaTwitter);
        double promedioFacebook = promedioEneroJunio(filaFacebook);

        System.out.println("\n---Promedio de crecimiento entre enero y junii---");
        System.out.printf("Twitter: %.2f%n", promedioTwitter);
        System.out.printf("Facebook: %.2f%n", promedioFacebook);

        continuarOSalir();
    }


    //Metodo para la cuarta opción del menú
    public void promedioMeGusta() {
        String[] filaYoutube = datos.get(FILA_YOUTUBE_ME_GUSTA);
        String[] filaTwitter = datos.get(FILA_TWITTER_ME_GUSTA);
        String[] filaFacebook = datos.get(FILA_FACEBOOK_ME_GUSTA);

        double promedioYoutube = promedioEneroJunio(filaYoutube);
        double promedioTwitter = promedioEneroJunio(filaTwitter);
        double promedioFacebook = promedioEneroJunio(filaFacebook);

        System.out.println("\n---Promedio de Me gusta entre enero y junio---");
        System.out.printf("YouTube: %.2f%n", promedioYoutube);
        System.out.printf("Twitter: %.2f%n", promedioTwitter);
        System.out.printf("Facebook: %.2f%n", promedioFacebook);

        continuarOSalir();
    }


    //Convierte un valor de texto del CSV a número, además quita el %
    public double convertirANumero(String valor) {

        //Por si algun valor es nulo, vale 0
        if (valor == null){
            return 0;
        }

        //Quita el % de lo datos que lo traen y también quita espacios
        String limpio = valor.replace("%", "").trim();

        //Si el dato queda vacío, o sin información,vale 0
        if (limpio.isEmpty()){
            return 0;
        }

        //Para pasar los valores de String a decimales, si no es un número, lo convierte en 0
        try {
            return Double.parseDouble(limpio);
        } catch (NumberFormatException e) {
            return 0;
        }
    }


    //Convierte el nombre de un mes en el índice de columna
    public int indiceDeMes(String mes) {

        //El trim quita los espacios, en caso que haya, y el Case convierte lo escrito en mayusculas
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


    // Calcula el promedio para la opción 3 y 4 del menú
    public double promedioEneroJunio(String[] fila) {
        double suma = 0;

        //hace la resta de las constantes, entonces es 8-3, por lo que se le pone el +1 para que sea =6
        int cantidadMeses = JUNIO-ENERO + 1; // =6 meses

        //Ocupa los indices de enero y junio (constantes) para convertir los valores en números e irlos sumando
        for (int i=ENERO; i<=JUNIO; i++) {
            suma += convertirANumero(fila[i]);
        }
        return suma / cantidadMeses;
    }
}
