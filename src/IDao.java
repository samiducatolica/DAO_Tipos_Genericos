import java.util.List;

public interface IDao<T,V> {
    public boolean crearRegistro(T model);
    public T leerRegistro(T model);
    public boolean actualizarRegistro(V model);
    public boolean borrarRegistro(V model);
    public List<T> leerRegistros();

}
