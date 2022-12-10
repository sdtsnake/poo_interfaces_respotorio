package work.oscarramos.poointerfaces.repositorio.lista;

import work.oscarramos.poointerfaces.modelo.Cliente;
import work.oscarramos.poointerfaces.repositorio.AbstracListRepositorio;
import work.oscarramos.poointerfaces.repositorio.Direccion;

import java.util.ArrayList;
import java.util.List;

public class ClienteListRepositorio extends AbstracListRepositorio<Cliente> {
    @Override
    public void editar(Cliente cliente) {
        Cliente cli = this.porId(cliente.getId());
        cli.setNombre(cliente.getNombre());
        cli.setApellido(cliente.getApellido());
    }
    @Override
    public List<Cliente> listar(String campo, Direccion dir) {
        List<Cliente> listarOrdenada = new ArrayList<>(this.dataSourse);
        listarOrdenada.sort((a, b) -> {
            int resul = 0;
            if (dir == Direccion.ASC) {
                resul = odernar(campo, a, b);
            } else if (dir == Direccion.DESC) {
                resul = odernar(campo, b, a);
            }
            return resul;
        });
        return listarOrdenada;
    }
    public static int odernar(String campo, Cliente a, Cliente b) {
        int resul = 0;
        switch (campo) {
            case "id" -> resul = a.getId().compareTo(b.getId());
            case "nombre" -> resul = a.getNombre().compareTo(b.getNombre());
            case "apellido" -> resul = a.getApellido().compareTo(b.getApellido());
        }
        return resul;
    }

}
