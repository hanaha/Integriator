package data.entity;

import data.World;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "worlds")
public class WorldEntity implements CustomEntity {

    private String name;
    private String description;

    public WorldEntity() {
    }

    public WorldEntity(World world) {
        this.name = world.getName();
        this.description = world.getDescription();
    }

    @Id
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("WorldEntity{");
        sb.append("name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
