package Extra.DataStructureExam.DataStructureView;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Objects;

public class Empleado {
    private int numeroTrabajador;
    private String nombres;
    private String paterno;
    private String materno;
    private int horasExtra;
    private double sueldoBase;
    private int anioIngreso;

    public Empleado() {
    }

    public Empleado(int numeroTrabajador, String nombres, String paterno, String materno, int horasExtra, double sueldoBase, int anioIngreso) {
        this.numeroTrabajador = numeroTrabajador;
        this.nombres = nombres;
        this.paterno = paterno;
        this.materno = materno;
        this.horasExtra = horasExtra;
        this.sueldoBase = sueldoBase;
        this.anioIngreso = anioIngreso;
    }

    public int getNumeroTrabajador() {
        return numeroTrabajador;
    }

    public void setNumeroTrabajador(int numeroTrabajador) {
        this.numeroTrabajador = numeroTrabajador;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public int getHorasExtra() {
        return horasExtra;
    }

    public void setHorasExtra(int horasExtra) {
        this.horasExtra = horasExtra;
    }

    public double getSueldoBase() {
        return sueldoBase;
    }

    public void setSueldoBase(double sueldoBase) {
        this.sueldoBase = sueldoBase;
    }

    public int getAnioIngreso() {
        return anioIngreso;
    }

    public void setAnioIngreso(int anioIngreso) {
        this.anioIngreso = anioIngreso;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "numeroTrabajador=" + numeroTrabajador +
                ", nombres='" + nombres + '\'' +
                ", paterno='" + paterno + '\'' +
                ", materno='" + materno + '\'' +
                ", horasExtra=" + horasExtra +
                ", sueldoBase=" + sueldoBase +
                ", anioIngreso=" + anioIngreso +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Empleado empleado = (Empleado) o;
        return numeroTrabajador == empleado.numeroTrabajador && horasExtra == empleado.horasExtra && Double.compare(sueldoBase, empleado.sueldoBase) == 0 && anioIngreso == empleado.anioIngreso && Objects.equals(nombres, empleado.nombres) && Objects.equals(paterno, empleado.paterno) && Objects.equals(materno, empleado.materno);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroTrabajador, nombres, paterno, materno, horasExtra, sueldoBase, anioIngreso);
    }


    public ArrayList<Empleado> leerArchivo(String ruta)
            throws IOException {

        ArrayList<Empleado> empleados = new ArrayList<>();

        BufferedReader archivo =
                Files.newBufferedReader(
                        Path.of(ruta),
                        StandardCharsets.UTF_8
                );

        // Ignorar la primera línea (encabezados)
        archivo.readLine();

        String linea;

        while ((linea = archivo.readLine()) != null) {

            String[] datos = linea.split(",");

            int numeroTrabajador =
                    Integer.parseInt(datos[0].trim());

            String nombres =
                    datos[1].trim();

            String paterno =
                    datos[2].trim();

            String materno =
                    datos[3].trim();

            int horasExtra =
                    Integer.parseInt(datos[4].trim());

            double sueldoBase =
                    Double.parseDouble(datos[5].trim());

            int anioIngreso =
                    Integer.parseInt(datos[6].trim());


            Empleado empleado = new Empleado(
                    numeroTrabajador,
                    nombres,
                    paterno,
                    materno,
                    horasExtra,
                    sueldoBase,
                    anioIngreso
            );


            empleados.add(empleado);
        }

        archivo.close();

        return empleados;
    }

    public double calcularSueldo() {
        double sueldo = sueldoBase + (horasExtra * 276.5);
        return sueldo;
    }
}
