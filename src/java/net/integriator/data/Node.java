package net.integriator.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Node in the game event tree.
 */
public class Node {
    private World world;
    private List<String> affectedVariables = new ArrayList<>();
    private String title;
    private String description;
    private String parentNodeId;
    /**
     * Constructor for a node in the world.
     *
     * @param world Current game world.
     */
    public Node(World world, String parentNodeId, String title, String description) {
        this.setWorld(world);
        this.setParentNodeId(parentNodeId);
        this.setTitle(title);
        this.setDescription(description);
        // @todo: Add affected variable list to the node.
//        this.setAffectedVariables(affectedVariables);
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

    public void setAffectedVariables(List affectedVariables) {
        this.affectedVariables = affectedVariables;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getParentNodeId() {
        return parentNodeId;
    }

    public void setParentNodeId(String parentNodeId) {
        this.parentNodeId = parentNodeId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
