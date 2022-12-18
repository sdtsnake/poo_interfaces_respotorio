package work.oscarramos.poointerfaces.repositorio.lista;

import work.oscarramos.excepciones.LecturaAccesoDatoException;
import work.oscarramos.poointerfaces.modelo.Producto;
import work.oscarramos.poointerfaces.repositorio.AbstracListRepositorio;
import work.oscarramos.poointerfaces.repositorio.Direccion;

import java.util.ArrayList;
import java.util.List;

public class ProductoListRepositorio extends AbstracListRepositorio<Producto> {

    @Override
    public void editar(Producto producto) throws LecturaAccesoDatoException {
        Producto p = porId(producto.getId());
        p.setDescripcion(producto.getDescripcion());
        p.setPrecio(producto.getPrecio());
    }

    @Override
    public List<Producto> listar(String campo, Direccion dir) {
        List<Producto> listarOrdenada = new ArrayList<>(this.dataSourse);
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

    public static int odernar(String campo, Producto a, Producto b) {
        int resul = 0;
        switch (campo) {
            case "id" -> resul = a.getId().compareTo(b.getId());
            case "descripcion" -> resul = a.getDescripcion().compareTo(b.getDescripcion());
            case "precio" -> resul = a.getPrecio().compareTo(b.getPrecio());
        }
        return resul;
    }


}
