import Extra.DataStructureExam.DataStructureView.Empleado;

void main() {

    //ArrayList
    System.out.println("----------------------------------------------------ArrayList----------------------------------------------------");
    ArrayList<Empleado> empleados = new ArrayList<>();
    empleados.add(new Empleado(12, "Juan", "Garcia", "Lopez",12, 250.4f, 2019));
    empleados.add(new Empleado(14, "JUAN", "Garcia", "Lopez",12, 250.4f, 2020));
    System.out.println(empleados);

    empleados.add(new Empleado());
    System.out.println(empleados.get(1));
    empleados.add(3, new Empleado(15, "JuaN", "Garcia", "Lopez",12, 250.4f, 2021));
    System.out.println(empleados);
    System.out.println(empleados.size());
    empleados.remove(2);
    System.out.println(empleados);
    empleados.toString();
    empleados.clear();
    System.out.println(empleados.size());



    //Conjuntos
    System.out.println("\n\n------------------------------------------CONJUNTOS-------------------------------------------------\n");
    Set<Empleado> set = new HashSet<>();
    Empleado em1 = new Empleado(12, "Juan", "Garcia", "Lopez",12, 250.4f, 2019);
    Empleado em2 = new Empleado(15, "JuaN", "Garcia", "Lopez",12, 250.4f, 2019);
    Empleado em3 = new Empleado(13, "Carl", "Wulf",  "Lopez",12, 350.4f, 2010);
    set.add(em1);
    set.add(em2);
    System.out.println(set);
    System.out.println(set.size());
    System.out.println(set.contains(em3));
    set.add(em3);
    set.remove(em2);
    System.out.println(set);


    Set<Empleado> set1 = new HashSet<>();
    set1.add(em3);
    System.out.println(set.equals(set1));
    System.out.println(set.containsAll(set1));
    Empleado em4 = new Empleado(23, "Si", "hs", "hqhs", 3, 445f, 403);
    set1.add(em4);
    set.addAll(set1);
    System.out.println(set);
    set.retainAll(set1);
    System.out.println(set);
    set.removeAll(set1);
    System.out.println(set);


    //ArrayList
    System.out.println("----------------------ArrayList-----------------------------");
    ArrayList<Empleado> empleados1 = new ArrayList<>();
    System.out.println(empleados1.isEmpty());
    System.out.println(empleados1.size());
    empleados1.add(em1);
    empleados1.add(em2);
    System.out.println(empleados1);
    empleados1.add(0, em3);
    System.out.println(empleados1);
    empleados1.add(1, em4);
    System.out.println(empleados1);
    empleados1.removeFirst();
    System.out.println(empleados1);
    empleados1.removeLast();
    System.out.println(empleados1);
    System.out.println(empleados1.get(1));
    empleados1.set(1, new Empleado(10, "No", "sdsd","dssd", 45, 234f, 2022));
    System.out.println(empleados1);



    //Colas
    System.out.println("\n\n----------------------------Colas-----------------------------------");
    Queue<Empleado> empleados2 = new LinkedList<>();
    empleados2.add(em1);
    empleados2.add(em2);
    System.out.println(empleados2.isEmpty());
    System.out.println(empleados2);
    System.out.println(empleados2.size());
    System.out.println(empleados2.);
}