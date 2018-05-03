package data;

import java.util.ArrayList;
import java.util.List;

/**
 * Node in the game event tree.
 */
public class Node {
    private World world;
    private List<String> affectedVariables = new ArrayList<>();

    /**
     * Constructor for a node in the world.
     *
     * @param world Current game world.
     */
    public Node(World world) {
        this.setWorld(world);
    }

    /* Getters and setters */

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public List getAffectedVariables() {
        return affectedVariables;
    }

    public void setAffectedVariables(ArrayList affectedVariables) {
        this.affectedVariables = affectedVariables;
    }

    /* Variable operations */

    /**
     * Add a variable to the list of variables this node affects.
     * @param name Machine name of the variable.
     */
    public void addAffectedVariable(String name) {
        this.affectedVariables.add(name);
    }

    /**
     * Remove a variable from the list of variables this node affects.
     * @param name Machine name of the variable.
     */
    public void removeAffectedVariable(String name) {
        this.affectedVariables.remove(name);
    }
}
