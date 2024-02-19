package modelo;

import java.util.Date;
import java.util.UUID;

public class Actor {
    private UUID actorId;
    private String first_name;
    private String last_name;
    private Date last_update;

    public Date getLast_update() {
        return last_update;
    }

    public void setLast_update(Date last_update) {
        this.last_update = last_update;
    }

    public Actor(UUID actorId, String first_name, String last_name, Date last_update) {
        this.actorId = actorId;
        this.first_name = first_name;
        this.last_name = last_name;
        this.last_update = last_update;
    }

    public Actor(UUID actorId, String first_name, String last_name) {
        this.actorId = actorId;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public Actor() {
    }

    public Actor(String first_name, String last_name) {
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public UUID getActorId() {
        return actorId;
    }

    public void setActorId(UUID actorId) {
        this.actorId = actorId;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "actorId=" + actorId +
                ", firs_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", last_update=" + last_update +
                '}';
    }
}
