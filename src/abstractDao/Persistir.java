package abstractDao;

public interface Persistir<T> {
    public boolean crearConexion(T Model);
}
