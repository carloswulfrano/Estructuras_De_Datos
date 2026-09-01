import Tareas.Tarea2.NominaICO;

void main() {
        //Año de referencia
        int anioActual = 2026;

        NominaICO nomina = new NominaICO("junio.dat", anioActual);

        if (nomina.leerArchivo()) {
            nomina.calcularSueldos();
            nomina.mayorAntiguedad();
            nomina.menorAntiguedad();
            nomina.imprimirNomina();
        }

}