package work.oscarramos.poointerfaces.repositorio;

import work.oscarramos.excepciones.EscrituraAccesoDatoException;
import work.oscarramos.excepciones.LecturaAccesoDatoException;
import work.oscarramos.excepciones.RegistroDuplicadoAccesoDatoException;
import work.oscarramos.poointerfaces.modelo.BaseEntity;

import java.util.ArrayList;
import java.util.List;

public  abstract class AbstracListRepositorio<T extends BaseEntity> implements OrdenablePraginableCrudRepositorio<T> {

    protected List<T> dataSourse;

    public AbstracListRepositorio() {
        this.dataSourse = new ArrayList<>();
    }

    @Override
    public List<T> listar() {
        return dataSourse;
    }

  @Override
    public T porId(Integer id) throws LecturaAccesoDatoException {
        if(id==null || id<=0){
            throw new LecturaAccesoDatoException("Id invalido este de ser mayor a cero y diferente de valores nulos");
        }
        T resultado = null;
        for(T cli :dataSourse){
            if(cli.getId() != null && cli.getId().equals(id)) {
                resultado = cli;
                break;
            }
        }
        if(resultado==null){
            throw new LecturaAccesoDatoException("No existe el registro con id : " + id);
        }
        return resultado;
    }

    @Override
    public void crear(T t) throws EscrituraAccesoDatoException {
        if(t==null){
            throw new EscrituraAccesoDatoException("Error al insetar un objetos null");
        }
        if(this.dataSourse.contains(t)){
            throw new RegistroDuplicadoAccesoDatoException("Error el objeto con id " + t.getId() + " existe en el repositorio");
        }
        this.dataSourse.add(t);
    }
    @Override
    public void eliminar(Integer id) throws LecturaAccesoDatoException {
        this.dataSourse.remove(this.porId(id));
    }
    @Override
    public List<T> listar(int desde, int hasta) {
        return dataSourse.subList(desde, hasta);
    }
    @Override
    public int total() {
        return this.dataSourse.size();
    }
}
