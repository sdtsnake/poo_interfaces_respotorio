package work.oscarramos.poointerfaces;

import work.oscarramos.poointerfaces.modelo.Cliente;
import work.oscarramos.poointerfaces.modelo.Producto;
import work.oscarramos.poointerfaces.repositorio.CrudRepositorio;
import work.oscarramos.poointerfaces.repositorio.Direccion;
import work.oscarramos.poointerfaces.repositorio.OrdenablePraginableCrudRepositorio;
import work.oscarramos.poointerfaces.repositorio.lista.ProductoListRepositorio;

import java.util.List;

public class EjemploRepositorioProducto {
    public static void main(String[] args) {
        OrdenablePraginableCrudRepositorio<Producto> repo = new ProductoListRepositorio();

        repo.crear(new Producto("Play Station 3",500000));
        repo.crear(new Producto("Play Station 4",1000000));
        repo.crear(new Producto("Play Station 5",3400000));
        repo.crear(new Producto("Audifono Pulse Audio",650000));
        repo.crear(new Producto("Mando Plays 5 dual sens",400000));

        System.out.println("======== listar ========");
        List<Producto> clientes = repo.listar();
        clientes.forEach(System.out::println);

        System.out.println("======== paginable ========");
        List<Producto> paginable = repo.listar(1,3);
        paginable.forEach(System.out::println);

        System.out.println("======== ordenable ========");
        List<Producto> productosOrdenAsc = repo.listar("descripcion", Direccion.DESC);
        productosOrdenAsc.forEach(System.out::println);

        System.out.println("======== editar ========");
        Producto play5Actulizar = new Producto("Play Station 5 Slim segunda generacion",5000000);
        play5Actulizar.setId(3);
        repo.editar(play5Actulizar);
        Producto displayProucto = repo.porId(2);
        System.out.println(displayProucto);

        System.out.println("======== Borrar ========");
        repo.eliminar(1);
        System.out.println("======== Listar Resultado ========");
        repo.listar("precion",Direccion.DESC).forEach(System.out::println);
        System.out.println("======== Total ========");
        System.out.println("Total registros : " + repo.total());
    }
}
