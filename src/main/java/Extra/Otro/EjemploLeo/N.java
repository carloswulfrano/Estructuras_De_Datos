void main() {


     int numero;
     Scanner leer = new Scanner(System.in);
     System.out.print("Introduce el numero Entero: ");
     numero = leer.nextInt();

     int suma = 0;
    for (int i = 0; i <= numero; i++) {
        suma = suma + (numero - i);

    }

    System.out.println(suma);

}