package work.oscarramos.poointerfaces.repositorio;

import work.oscarramos.poointerfaces.modelo.Cliente;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ClienteListRepositorio implements OrdenablePraginableCrudRepositorio {

    private List<Cliente> dataSourse;

    public ClienteListRepositorio() {
        this.dataSourse = new ArrayList<>();
    }

    @Override
    public List<Cliente> listar() {
        return dataSourse;
    }

    @Override
    public Cliente porId(Integer id) {
        Cliente cliente = null;
        for(Cliente cli :dataSourse){
            if(cli.getId() != null && cli.getId().equals(id)) {
                cliente = cli;
            }
        }
        //var clientes = dataSourse.stream().filter(cliente1 -> cliente1.getId().equals(id)).findAny();
        //return clientes.orElse(null);
        return cliente;
    }

    @Override
    public void crear(Cliente cliente) {
        this.dataSourse.add(cliente);
    }

    @Override
    public void editar(Cliente cliente) {
        Cliente cli = this.porId(cliente.getId());
        cli.setNombre(cliente.getNombre());
        cli.setApellido(cliente.getApellido());
    }

    @Override
    public void eliminar(Integer id) {
        this.dataSourse.remove(this.porId(id));
    }

    @Override
    public List<Cliente> listar(String campo, Direccion dir) {
        List<Cliente> listarOrdenada = new ArrayList<>(this.dataSourse);
        listarOrdenada.sort(new Comparator<Cliente>() {
            @Override
            public int compare(Cliente a, Cliente b) {
                int resul = 0;
                if(dir== Direccion.ASC){
                    resul = odernar(campo,a,b);
                }else if(dir == Direccion.DESC) {
                    resul = odernar(campo,b,a);
                }
                return resul;
            }

        });

        return listarOrdenada;
    }

    public static int odernar(String campo, Cliente a, Cliente b){
        int resul = 0;
        switch (campo){
            case "id" -> resul = a.getId().compareTo(b.getId());
            case "nombre" -> resul = a.getNombre().compareTo(b.getNombre());
            case "apellido" -> resul = a.getApellido().compareTo(b.getApellido());
        }
        return resul;
    }

    @Override
    public List<Cliente> listar(int desde, int hasta) {
        return dataSourse.subList(desde, hasta);
    }

    @Override
    public int total() {
        return this.dataSourse.size();
    }
}
