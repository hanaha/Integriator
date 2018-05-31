package net.integriator.data.entity;

import net.integriator.data.Node;
import net.integriator.data.SessionManager;
import org.hibernate.Session;

import javax.persistence.*;

@Entity
@Table(name = "nodes")
public class NodeEntity implements CustomEntity {

    @ManyToOne
    @JoinColumn(name="world")
    private WorldEntity world;

    @Id
    private String title;

    public NodeEntity() {
    }

    public NodeEntity(Node node) {

        Session session = SessionManager.startSession();

        this.world = session.get(WorldEntity.class, node.getWorld().getName());

        SessionManager.stopSession();

        this.title = node.getTitle();
    }

    public WorldEntity getWorld() {
        return world;
    }

    public void setWorld(WorldEntity world) {
        this.world = world;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
