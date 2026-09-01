import Tareas.Tarea2.NominaICO;

void main() {
        // Año de referencia para calcular la antigüedad de cada empleado.
        // Ajusta este valor si tu profesor pide que se calcule con otro año.
        int anioActual = 2024;

        NominaICO nomina = new NominaICO("junio.dat", anioActual);

        if (nomina.leerArchivo()) {
            nomina.calcularSueldos();
            nomina.mayorAntiguedad();
            nomina.menorAntiguedad();
            nomina.imprimirNomina();
        }

}