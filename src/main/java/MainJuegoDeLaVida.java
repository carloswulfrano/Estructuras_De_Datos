import Tareas.Tarea3.GameOfLife.JuegoDeLaVida;

void main() {
    JuegoDeLaVida juego = new JuegoDeLaVida();

    if (juego.leerArchivo("Poblacion_Inicial.csv")) {
        int totalGeneraciones = 10;

        // Se muestra la generación 0 (la configuración inicial que viene del CSV)
        // y luego las 10 generaciones que se van calculando.
        for (int generacion = 0; generacion <= totalGeneraciones; generacion++) {
            System.out.println("\n=== Generación " + generacion + " ===");
            juego.imprimir();

            if (generacion < totalGeneraciones) {
                juego.siguienteGeneracion();
            }
        }
    }
}