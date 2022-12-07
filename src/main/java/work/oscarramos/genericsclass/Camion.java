package work.oscarramos.genericsclass;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Camion implements Iterable{

    private List objetos;
    private int max;

    public Camion(int max) {
        this.max = max;
        this.objetos = new ArrayList();
    }

    public void add(Object object){
        if(this.objetos.size() >=max){
            throw new RuntimeException("Sin espacio en el camion");

        }else{
            this.objetos.add(object);
        }
    }

    @Override
    public Iterator iterator() {
        return this.objetos.iterator();
    }
}
