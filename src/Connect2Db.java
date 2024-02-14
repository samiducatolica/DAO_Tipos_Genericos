import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect2Db {
    private static Connect2Db connect2DbInstance;
    private Connection connection;
    private final String URL="jdbc:postgresql://172.17.0.2:5432/prueba";
    private final String USER="postgres";
    private final String PASSWORD="toor";

    private Connect2Db(){
        try{
            connection = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("Conectando");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            System.out.println("OK ");
        }
    }

    //Patron singleton para acceder a una instancia de la clase
    public  static Connect2Db getInstance(){
        if (connect2DbInstance == null){
            connect2DbInstance = new Connect2Db();
        }
        return connect2DbInstance;
    }
    public Connection getConnection(){
        return connection;
    }
}
