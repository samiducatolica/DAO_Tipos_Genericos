package abstractDao;

import java.io.FileWriter;
import java.io.IOException;

public class PersistirTexto implements Persistir{
    String rutaArchivo = "/home/samid/Documentos/archivo.csv";

    @Override
    public boolean crearConexion(Object Model) {
        try{
            FileWriter fileWriter = new FileWriter(rutaArchivo);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}
