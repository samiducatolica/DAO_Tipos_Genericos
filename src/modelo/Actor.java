package modelo;

import java.util.Date;
import java.util.UUID;

public class Actor {
    private UUID actorId;
    private String firs_name;
    private String last_name;
    private Date last_update;

    public Date getLast_update() {
        return last_update;
    }

    public void setLast_update(Date last_update) {
        this.last_update = last_update;
    }

    public Actor(UUID actorId, String firs_name, String last_name, Date last_update) {
        this.actorId = actorId;
        this.firs_name = firs_name;
        this.last_name = last_name;
        this.last_update = last_update;
    }

    public Actor(UUID actorId, String firs_name, String last_name) {
        this.actorId = actorId;
        this.firs_name = firs_name;
        this.last_name = last_name;
    }

    public Actor() {
    }

    public UUID getActorId() {
        return actorId;
    }

    public void setActorId(UUID actorId) {
        this.actorId = actorId;
    }

    public String getFirs_name() {
        return firs_name;
    }

    public void setFirs_name(String firs_name) {
        this.firs_name = firs_name;
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
                ", firs_name='" + firs_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", last_update=" + last_update +
                '}';
    }
}
