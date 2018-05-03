package data;

/**
 * The game world.
 */
public class World {
    private String name;
    private String description;
    private Node root;

    public World(String name, String description) {
        this.name = name;
        this.description = description;
        this.root = new Node();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
