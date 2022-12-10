package work.oscarramos.poointerfaces.repositorio;

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
    public T porId(Integer id) {
        T resultado = null;
        for(T cli :dataSourse){
            if(cli.getId() != null && cli.getId().equals(id)) {
                resultado = cli;
            }
        }
        return resultado;
    }

    @Override
    public void crear(T t) {
        this.dataSourse.add(t);
    }
    @Override
    public void eliminar(Integer id) {
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
