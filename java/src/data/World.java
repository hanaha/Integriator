package data;

import java.util.HashMap;

/**
 * The game world.
 */
public class World {
    private String name;
    private String description;
    private Node root;
    private HashMap<String, Boolean> variables;

    public World(String name, String description) {
        this.setName(name);
        this.setDescription(description);
        this.setRoot(new Node(this));
    }

    /* Getters and setters */

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

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public HashMap<String, Boolean> getVariables() {
        return variables;
    }

    /* Variable operations */

    /**
     * Verify that a variable exists in this world.
     *
     * @param name Machine name of the variable.
     * @return true if there is a variable with the given name, false otherwise.
     */
    public Boolean variableExists(String name) {
        if (variables.containsKey(name)) {
            return true;
        }
        return false;
    }

    /**
     * Get the current value of the given variable.
     *
     * @param name Machine name of the variable.
     * @return Current value of the variable (true|false).
     */
    public Boolean getVariableValue(String name) {
        return variables.get(name);
    }

    /**
     * Create a new variable, with a default value 'false'.
     *
     * @param name Machine name of the variable.
     */
    public void addVariable(String name) {
        this.variables.putIfAbsent(name, false);
    }

    /**
     * Remove given variable.
     *
     * @param name Machine name of the variable.
     */
    public void removeVariable(String name) {
        if (this.variableExists(name)) {
            this.variables.remove(name);
        }
    }

    /**
     * Set a variable to true.
     *
     * @param name Machine name of the variable.
     */
    public void switchVariableOn(String name) {
        this.variables.put(name, true);
    }

    /**
     * Set a variable to false.
     *
     * @param name Machine name of the variable.
     */
    public void switchVariableOff(String name) {
        this.variables.put(name, false);
    }

    /* Node operations */

}
