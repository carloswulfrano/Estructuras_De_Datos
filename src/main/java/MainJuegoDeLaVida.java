import Tareas.Tarea3.GameOfLife.JuegoDeLaVida;

void main() {

    /*
    JuegoDeLaVida escenario1 = new JuegoDeLaVida();

    if (escenario1.leerArchivo("Poblacion_Inicial.csv")) {
        int totalGeneraciones = 10;

        //Muestra la poblacion  inicial y las 10 generaciones siguientes
        for (int generacion = 0; generacion <= totalGeneraciones; generacion++) {
            System.out.println("\n=== Generación " + generacion + " ===");
            escenario1.imprimir();

            if (generacion < totalGeneraciones) {
                escenario1.siguienteGeneracion();
            }
        }
    }

     */


    JuegoDeLaVida escenario2 = new JuegoDeLaVida();

    if (escenario2.leerArchivo("Poblacion_Inicial2.csv")) {
        int totalGeneraciones = 10;

        //Muestra la poblacion  inicial y las 10 generaciones siguientes
        for (int generacion = 0; generacion <= totalGeneraciones; generacion++) {
            System.out.println("\n=== Generación " + generacion + " ===");
            escenario2.imprimir();

            if (generacion < totalGeneraciones) {
                escenario2.siguienteGeneracion();
            }
        }
    }

    /*
    JuegoDeLaVida escenario3 = new JuegoDeLaVida();

    if (escenario3.leerArchivo("Poblacion_Inicial3.csv")) {
        int totalGeneraciones = 10;

        //Muestra la poblacion  inicial y las 10 generaciones siguientes
        for (int generacion = 0; generacion <= totalGeneraciones; generacion++) {
            System.out.println("\n=== Generación " + generacion + " ===");
            escenario3.imprimir();

            if (generacion < totalGeneraciones) {
                escenario3.siguienteGeneracion();
            }
        }
    }


    JuegoDeLaVida escenario4 = new JuegoDeLaVida();

    if (escenario4.leerArchivo("Poblacion_Inicial4.csv")) {
        int totalGeneraciones = 10;

        //Muestra la poblacion  inicial y las 10 generaciones siguientes
        for (int generacion = 0; generacion <= totalGeneraciones; generacion++) {
            System.out.println("\n=== Generación " + generacion + " ===");
            escenario4.imprimir();

            if (generacion < totalGeneraciones) {
                escenario4.siguienteGeneracion();
            }
        }
    }

     */
}