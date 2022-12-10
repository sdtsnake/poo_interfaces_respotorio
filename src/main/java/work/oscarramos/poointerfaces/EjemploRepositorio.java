package work.oscarramos.poointerfaces;

import work.oscarramos.poointerfaces.modelo.Cliente;
import work.oscarramos.poointerfaces.repositorio.AbstracListRepositorio;
import work.oscarramos.poointerfaces.repositorio.ClienteListRepositorio;
import work.oscarramos.poointerfaces.repositorio.Direccion;
import work.oscarramos.poointerfaces.repositorio.OrdenablePraginableCrudRepositorio;

import java.util.List;

public class EjemploRepositorio {
    public static void main(String[] args) {
        OrdenablePraginableCrudRepositorio<Cliente> repo = new ClienteListRepositorio();

        repo.crear(new Cliente("Oscar","Ramos"));
        repo.crear(new Cliente("Paula","Nueñz"));
        repo.crear(new Cliente("Sebastian","Ramos"));
        repo.crear(new Cliente("Lucero","Lopez"));
        repo.crear(new Cliente("Marco","Ramos"));

        System.out.println("======== listar ========");
        List<Cliente> clientes = repo.listar();
        clientes.forEach(System.out::println);

        System.out.println("======== paginable ========");
        List<Cliente> paginable = repo.listar(1,3);
        paginable.forEach(System.out::println);

        System.out.println("======== ordenable ========");
        List<Cliente> clienteOrdenAsc = repo.listar("nombre", Direccion.DESC);
        clienteOrdenAsc.forEach(System.out::println);

        System.out.println("======== editar ========");
        Cliente actulizaCliente = new Cliente("Andrea","Nuñes");
        actulizaCliente.setId(2);
        repo.editar(actulizaCliente);
        Cliente displayCliente = repo.porId(2);
        System.out.println(displayCliente);

        System.out.println("======== Borrar ========");
        repo.eliminar(2);
        System.out.println("======== Listar Resultado ========");
        repo.listar().forEach(System.out::println);
        System.out.println("======== Total ========");
        System.out.println("Total registros : " + repo.total());
    }
}
