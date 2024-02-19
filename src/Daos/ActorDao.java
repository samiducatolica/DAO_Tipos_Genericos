package Daos;

import Daos.IDao;
import conecion.Connect2Db;
import modelo.Actor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ActorDao implements IDao<Actor, UUID> {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private boolean ejecucionCorrecta=false;
    private Actor actor;
    private List<Actor> actores;

    private final String[] CONSULTAS={
            "INSERT INTO dao_prueba.actor (actor_id, first_name, last_name, last_update) VALUES(gen_random_uuid(), ?, ?, now());",
            "SELECT actor_id, first_name, last_name, last_update FROM dao_prueba.actor WHERE actor_id = ?::uuid; ",
            "UPDATE dao_prueba.actor SET first_name=?, last_name=?, last_update=now() WHERE actor_id=?::uuid;",
            "DELETE FROM dao_prueba.actor WHERE actor_id= ?::uuid;",
            "SELECT * FROM dao_prueba.actor;"
    };
    public ActorDao(){
        connection = Connect2Db.getInstance().getConnection();
        actor = new Actor();
        actores = new ArrayList<>();
    }
    @Override
    public boolean crearRegistro(Actor model) {
        try{
            preparedStatement = connection.prepareStatement(CONSULTAS[0]);
            preparedStatement.setString(1, model.getFirst_name());
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
    public Actor leerRegistro(UUID idModel) {
        try{
            preparedStatement = connection.prepareStatement(CONSULTAS[1]);
            preparedStatement.setString(1,idModel.toString());
            ResultSet data = preparedStatement.executeQuery();
            if (data.next()){
                actor.setFirst_name(data.getString("first_name"));
                actor.setLast_name(data.getString("last_name"));
                actor.setActorId(UUID.fromString(data.getString("actor_id")));
                actor.setLast_update(data.getTimestamp("last_update"));
            }
        } catch (SQLException e) {
            Logger.getLogger(ActorDao.class.getName()).log(Level.SEVERE,null,e);
        }
        return actor;
    }

    @Override
    public boolean actualizarRegistro(Actor model,UUID idModel) {
        try{
            preparedStatement = connection.prepareStatement(CONSULTAS[2]);
            preparedStatement.setString(1,model.getFirst_name());
            preparedStatement.setString(2,model.getLast_name());
            preparedStatement.setString(3,idModel.toString());
            if (preparedStatement.executeUpdate()>0){
                ejecucionCorrecta = true;
            }
        } catch (SQLException e) {
            Logger.getLogger(ActorDao.class.getName()).log(Level.SEVERE,null,e);
        }
        return ejecucionCorrecta;
    }

    @Override
    public boolean borrarRegistro(UUID idModel) {
        try{
            preparedStatement=connection.prepareStatement(CONSULTAS[3]);
            preparedStatement.setString(1,idModel.toString());
            if (preparedStatement.executeUpdate()>0){
                ejecucionCorrecta=true;
            }
        } catch (SQLException e) {
            Logger.getLogger(ActorDao.class.getName()).log(Level.SEVERE,null,e);
        }
        return ejecucionCorrecta;
    }

    @Override
    public List<Actor> leerRegistros() {
        try{
            preparedStatement = connection.prepareStatement(CONSULTAS[4]);
            ResultSet data = preparedStatement.executeQuery();
            while (data.next()){
                actores.add(new Actor(UUID.fromString(data.getString("actor_id")),
                        data.getString("first_name"),
                        data.getString("last_name"),
                        data.getTimestamp("last_update")));
            }
        }catch (SQLException e) {
            Logger.getLogger(ActorDao.class.getName()).log(Level.SEVERE,null,e);
        }
        return actores;
    }
}
