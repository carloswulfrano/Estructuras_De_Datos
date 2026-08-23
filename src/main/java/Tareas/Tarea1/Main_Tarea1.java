import Tareas.Tarea1.Tarea1ProgramaInicial;

void main() {
    Tarea1ProgramaInicial app = new Tarea1ProgramaInicial();

    if (!app.leerArchivo("datos_redes_sociales.csv")) {
        System.out.println("No se pudo leer el archivo datos_redes_sociales.csv");
        return;
    }
    app.menu();
}
