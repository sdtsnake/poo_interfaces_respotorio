package work.oscarramos.genericsclass;

public class EjemplosGenericos {

    public static void main(String[] args) {
        Camion transportePerros = new Camion(5);
        transportePerros.add(new Animal("Damian","Perro"));
        transportePerros.add(new Animal("Katia","Perro"));
        transportePerros.add(new Animal("Hnter","Perro"));
        transportePerros.add(new Animal("Mani","Perro"));
        transportePerros.add(new Animal("Bruno","Perro"));
        System.out.println("=== Animales ====");
        for(Object o: transportePerros){
            Animal a = (Animal) o;
            System.out.println(a.getNombre() + " Tipo: " + a.getTipo());
        }

        Camion transporteMaquinas = new Camion(3);

        transporteMaquinas.add(new Maquinaria("Taladro industrial"));
        transporteMaquinas.add(new Maquinaria("Tractor"));
        transporteMaquinas.add(new Maquinaria("Bolqueta"));

        System.out.println("=== Maquinarias ====");
        for(Object o: transporteMaquinas){
            Maquinaria m = (Maquinaria) o;
            System.out.println(m.getTipo());
        }

        Camion transporteAutomovil = new Camion(3);
        transporteAutomovil.add(new Automovil("Chevrolet"));
        transporteAutomovil.add(new Automovil("Renult"));
        transporteAutomovil.add(new Automovil("Mazda"));

        System.out.println("=== Automovil ====");

        for(Object o: transporteAutomovil){
            Automovil a = (Automovil) o;
            System.out.println(a.getMarca());
        }




    }
}
