package work.oscarramos.poointerfaces.repositorio;

public interface OrdenablePraginableCrudRepositorio<T> extends OrdenableRepositorio<T>,
        PaginableRepositorio<T>,CrudRepositorio<T>,ContableRepositorio{
}
