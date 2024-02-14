import modelo.Actor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ActorDao implements IDao<Actor, UUID>{
    private Connection connection;
    private PreparedStatement preparedStatement;
    private boolean ejecucionCorrecta=false;
    private Actor actor;
    private List<Actor> actores;

    private final String[] CONSULTAS={
            "INSERT INTO dao_prueba.actor (actor_id, first_name, last_name, last_update) VALUES(gen_random_uuid(), ?, ?, now());",
            "SELECT actor_id, first_name, last_name, last_update FROM dao_prueba.actor WHERE actor_id = ?; ",
            "UPDATE dao_prueba.actor SET first_name='', last_name='', last_update=now() WHERE actor_id=?;",
            "DELETE FROM dao_prueba.actor WHERE actor_id= ?;",
            "SELECT * FROM dao_prueba.actor;"
    };
    public ActorDao(){
        connection = Connect2Db.getInstance().getConnection();
        actor = new Actor();
        actores = new ArrayList();
    }
    @Override
    public boolean crearRegistro(Actor model) {
        try{
            preparedStatement = connection.prepareStatement(CONSULTAS[0]);
            preparedStatement.setString(1, model.getFirs_name());
            preparedStatement.setString(2,model.getLast_name());

            System.out.println(preparedStatement);

            if (preparedStatement.executeUpdate() >0){
                ejecucionCorrecta =true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ejecucionCorrecta;
    }

    @Override
    public Actor leerRegistro(Actor model) {
        return null;
    }

    @Override
    public boolean actualizarRegistro(UUID model) {
        return false;
    }

    @Override
    public boolean borrarRegistro(UUID model) {
        return false;
    }

    @Override
    public List<Actor> leerRegistros() {
        return null;
    }
}
