package Tareas.Tarea2;

public class Empleado {

    private static final double PAGO_HORA_EXTRA = 276.5; //sueldo
    private static final double PORCENTAJE_POR_ANIO = 0.03; //3% del sueldo base por cada año de antigüedad

    private int numTrabajador;
    private String nombre;
    private String paterno;
    private String materno;
    private int horasExtra;
    private double sueldoBase;
    private int anioIngreso;
    //para calcular los sueldos
    private int antiguedad;
    private double sueldoAPagar;

    public Empleado(int numTrabajador, String nombre, String paterno, String materno, int horasExtra, double sueldoBase, int anioIngreso) {
        this.numTrabajador = numTrabajador;
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
        this.horasExtra = horasExtra;
        this.sueldoBase = sueldoBase;
        this.anioIngreso = anioIngreso;
    }

    //Calcla la antiguedad del empleado
    public int getAntiguedad(int anioActual) {
        return anioActual - anioIngreso;
    }

    public double calcularSueldo(int anioActual) {
        double pagoHorasExtra = horasExtra * PAGO_HORA_EXTRA;
        antiguedad = getAntiguedad(anioActual);
        double prestacionAntiguedad = sueldoBase * PORCENTAJE_POR_ANIO * antiguedad;

        sueldoAPagar = sueldoBase + pagoHorasExtra + prestacionAntiguedad;
        return sueldoAPagar;
    }


    public int getNumTrabajador() {
        return numTrabajador;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPaterno() {
        return paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public int getHorasExtra() {
        return horasExtra;
    }

    public double getSueldoBase() {
        return sueldoBase;
    }

    public int getAnioIngreso() {
        return anioIngreso;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public double getSueldoAPagar() {
        return sueldoAPagar;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "numTrabajador=" + numTrabajador +
                ", nombre='" + nombre + '\'' +
                ", paterno='" + paterno + '\'' +
                ", materno='" + materno + '\'' +
                ", horasExtra=" + horasExtra +
                ", sueldoBase=" + sueldoBase +
                ", anioIngreso=" + anioIngreso +
                ", antiguedad=" + antiguedad +
                ", sueldoAPagar=" + sueldoAPagar +
                '}';
    }
}
