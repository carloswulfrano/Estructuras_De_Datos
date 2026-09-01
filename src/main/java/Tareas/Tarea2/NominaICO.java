package Tareas.Tarea2;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NominaICO {

    private ArrayADT<Empleado> datos;
    private String rutaArchivo;
    private int anioActual;

    public NominaICO(String rutaArchivo, int anioActual) {
        this.rutaArchivo = rutaArchivo;
        this.anioActual = anioActual;
    }

    //lee el archivo .dat y guarda cada empleado en el ArrayADT
    public boolean leerArchivo() {
        File archivo = new File(rutaArchivo);

        try {
            //solo contamos cuántas filas de datos hay para saber de qué tamaño crear el ArrayADT
            Scanner contadorLector = new Scanner(archivo);
            int contador = 0;
            boolean primeraLinea = true;

            while (contadorLector.hasNextLine()) {
                String linea = contadorLector.nextLine();
                if (primeraLinea) {
                    primeraLinea = false; // saltamos el encabezado
                    continue;
                }
                if (!linea.trim().isEmpty()) {
                    contador++;
                }
            }
            contadorLector.close();

            datos = new ArrayADT<>(contador);

            //lee los datos y los guarda
            Scanner lector = new Scanner(archivo);
            primeraLinea = true;
            int indice = 0;

            while (lector.hasNextLine()) {
                String linea = lector.nextLine();
                if (primeraLinea) {
                    primeraLinea = false;
                    continue;
                }
                if (!linea.trim().isEmpty()) {
                    String[] campos = linea.split(",");

                    int numTrabajador = Integer.parseInt(campos[0].trim());
                    String nombre = campos[1].trim();
                    String paterno = campos[2].trim();
                    String materno = campos[3].trim();
                    int horasExtra = Integer.parseInt(campos[4].trim());
                    double sueldoBase = Double.parseDouble(campos[5].trim());
                    int anioIngreso = Integer.parseInt(campos[6].trim());

                    Empleado empleado = new Empleado(numTrabajador, nombre, paterno, materno, horasExtra, sueldoBase, anioIngreso);

                    datos.insertarElemento(indice, empleado);
                    indice++;
                }
            }
            lector.close();
            return true;

        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el archivo.");
            System.out.println("Se buscó en: " + archivo.getAbsolutePath());
            return false;
        }
    }

    //un for para sacar cada empleadp y que se calcule su sueldo
    public void calcularSueldos() {
        for (int i = 0; i < datos.longitud(); i++) {
            Empleado empleado = datos.obtenerElemento(i);
            empleado.calcularSueldo(anioActual);
        }
    }

    // Muestra el trabajador con mayor antigüedad (el que ingresó hace más años)
    public void mayorAntiguedad() {
        Empleado mayor = datos.obtenerElemento(0);

       //compara uno por uno para ver cual es maoyr
        for (int i = 1; i < datos.longitud(); i++) {
            Empleado actual = datos.obtenerElemento(i);
            if (actual.getAnioIngreso() < mayor.getAnioIngreso()) {
                mayor = actual;
            }
        }

        System.out.println("\n--- Trabajador con mayor antigüedad ---");
        System.out.println(mayor);
    }

    //compara uno por uno para ver cual es el menor
    public void menorAntiguedad() {
        Empleado menor = datos.obtenerElemento(0);

        for (int i = 1; i < datos.longitud(); i++) {
            Empleado actual = datos.obtenerElemento(i);
            if (actual.getAnioIngreso() > menor.getAnioIngreso()) {
                menor = actual;
            }
        }

        System.out.println("\n--- Trabajador con menor antigüedad ---");
        System.out.println(menor);
    }

    //imprime la nómina completa
    public void imprimirNomina() {
        System.out.println("\n--- Nómina completa ---\n");

        for (int i = 0; i < datos.longitud(); i++) {
            Empleado empleado = datos.obtenerElemento(i);
            System.out.println(empleado);
        }
    }
}
