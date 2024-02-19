package Daos;

import java.util.List;

public interface IDao<T,V> {
    public boolean crearRegistro(T model);
    public T leerRegistro(V idModel);
    public boolean actualizarRegistro(T model,V idModel);
    public boolean borrarRegistro(V idModel);
    public List<T> leerRegistros();

}
