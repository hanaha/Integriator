package data.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "worlds" )
public class WorldEntity {

    private String name;
    private String description;

    public WorldEntity() {
    }

    public WorldEntity(String name, String description) {
        this.name = name;
        this.description = description;
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
