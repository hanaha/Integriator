package net.integriator.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import net.integriator.data.Node;
import net.integriator.data.SessionManager;
import net.integriator.data.World;
import net.integriator.data.entity.NodeEntity;

/**
 * Node manipulation controller.
 */
public class NodeEdit {

    public AnchorPane nodeForm;
    public TextField parentNode;
    public TextField title;
    public TextField varToAdd;
    public TableView varTable;
    public TableColumn varName;
    public TableColumn varValue;
    public TableColumn varRemove;
    public ContextMenu nodeAutocompleteContextMenu;
    public ContextMenu varAutocompleteContextMenu;
    public Button saveNodeButton;
    public TextArea description;
    public VBox potentialParentVbox;
    private World world;

    public void findNodeAutocomplete(InputMethodEvent inputMethodEvent) {

    }

    public void findVariableAutocomplete(InputMethodEvent inputMethodEvent) {
        // STUB
        MenuItem menuItem = new MenuItem();
        menuItem.setText(this.varToAdd.getText());
//        this.varAutocompleteContextMenu.getItems().add(menuItem);
//        this.varAutocompleteContextMenu.show();
    }

    public void addToVarTable(ActionEvent actionEvent) {

    }

    public void selectNodeFromAutocomplete(ActionEvent actionEvent) {

    }

    public void selectVarFromAutocomplete(ActionEvent actionEvent) {

    }

    public void setWorld(World world) {
        this.world = world;
    }

    public void saveNewNode(ActionEvent actionEvent) {
        Node node = new Node(this.world, this.parentNode.getText(), this.title.getText(), this.description.getText());
        NodeEntity nodeEntity = new NodeEntity(node);
        SessionManager.saveEntity(nodeEntity);
    }

}
