package work.oscarramos.poointerfaces.repositorio;

import work.oscarramos.poointerfaces.modelo.Cliente;

import java.util.List;

public interface OrdenableRepositorio {
    List<Cliente> listar(String campo, Direccion dir);
}
