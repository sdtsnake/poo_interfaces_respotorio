package work.oscarramos.genericsclass;

public class EjemplosGenericos {

    public static void main(String[] args) {
        Camion<Animal> transportePerros = new Camion<>(5);
        transportePerros.add(new Animal("Damian","Perro"));
        transportePerros.add(new Animal("Katia","Perro"));
        transportePerros.add(new Animal("Hnter","Perro"));
        transportePerros.add(new Animal("Mani","Perro"));
        transportePerros.add(new Animal("Bruno","Perro"));
        System.out.println("=== Animales ====");


        imprimirCamion(transportePerros);

        Camion<Maquinaria> transporteMaquinas = new Camion<>(3);

        transporteMaquinas.add(new Maquinaria("Taladro industrial"));
        transporteMaquinas.add(new Maquinaria("Tractor"));
        transporteMaquinas.add(new Maquinaria("Bolqueta"));

        System.out.println("=== Maquinarias ====");

        imprimirCamion(transporteMaquinas);

        Camion<Automovil> transporteAutomovil = new Camion<>(3);
        transporteAutomovil.add(new Automovil("Chevrolet"));
        transporteAutomovil.add(new Automovil("Renult"));
        transporteAutomovil.add(new Automovil("Mazda"));

        System.out.println("=== Automovil ====");

        imprimirCamion(transporteAutomovil);
    }
    public static <T> void imprimirCamion(Camion<T> camion){
        for(T a: camion){
            if(a instanceof Animal){
                System.out.println(((Animal)a).getNombre() + " Tipo: " + ((Animal)a).getTipo());
            }else if(a instanceof Maquinaria){
                System.out.println(((Maquinaria)a).getTipo());
            }else if(a instanceof Automovil){
                System.out.println(((Automovil)a).getMarca());
            }

        }

    }
}
