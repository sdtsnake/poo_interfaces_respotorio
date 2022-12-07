package work.oscarramos.generics;

import com.sun.management.UnixOperatingSystemMXBean;
import work.oscarramos.poointerfaces.modelo.Cliente;
import work.oscarramos.poointerfaces.modelo.ClientePremium;

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

        List<ClientePremium> clientePremiumList = fromArrayToList(
                new ClientePremium[]{new ClientePremium("Paula","Nuñez")}
        );

        imprimirClientes(clientes);
        imprimirClientes(clientesLista);
        imprimirClientes(clientePremiumList);

        System.out.println("Maximo de 4, 21 y 50 es: " + maximo(4,21,50));
        System.out.println("Maximo de 5.9, 20.6 y 8.78 es: " + maximo(5.9,20.6,8.78));
        System.out.println("Maximo de Zelda, GOW y Sonic es: " + maximo("Zelda","GOW","Sonic"));

    }
    public static <T> List<T> fromArrayToList(T[] c){
        return Arrays.asList(c);
    }
    public static <T extends Number> List<T> fromArrayToList(T[] c){
        return Arrays.asList(c);
    }
    public static <T extends Cliente & Comparable<T>> List<T> fromArrayToList(T[] c){
        return Arrays.asList(c);
    }

    public static <T, G> List<T> fromArrayToList(T[] c, G[] x){
        for(G elemento: x){
            System.out.println(elemento);
        }
        return Arrays.asList(c);
    }

    public static void imprimirClientes(List<? extends Cliente> clientes){
        clientes.forEach(System.out::println);
    }

    public static <T extends Comparable<T>> T maximo(T a, T b, T c){
        T max = a;
        if(b.compareTo(max) > 0){
            max = b;
        }
        if(c.compareTo(max) > 0){
            max = c;
        }
        return max;
    }
}
