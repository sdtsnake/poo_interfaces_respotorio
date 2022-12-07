package work.oscarramos.generics;

import com.sun.management.UnixOperatingSystemMXBean;
import work.oscarramos.poointerfaces.modelo.Cliente;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EjemploGenericos {
    public static void main(String[] args) {
        List<Cliente> clientes = new ArrayList<>();

        clientes.add(new Cliente("Oscar","Ramos"));

        Cliente oscar = clientes.iterator().next();

        Cliente[] clienteArray = {new Cliente("Oscar","Ramos"),
                new Cliente("Sebastian","Ramos")};

        Integer[] enteros = {1,2,3};

        List<Cliente> clientesLista = fromArrayToList(clienteArray);
        List<Integer> enterosLista = fromArrayToList(enteros);

        clientesLista.forEach(System.out::println);
        enterosLista.forEach(System.out::println);

        List<String> nombres = fromArrayToList(new String[]{"andres","pepe","lucy","Jhon"}, enteros);
        nombres.forEach(System.out::println);
    }

    public static <T> List<T> fromArrayToList(T[] c){
        return Arrays.asList(c);
    }

    public static <T, G> List<T> fromArrayToList(T[] c, G[] x){
        for(G elemento: x){
            System.out.println(elemento);
        }
        return Arrays.asList(c);
    }
}
