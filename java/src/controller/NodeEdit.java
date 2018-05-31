package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.layout.AnchorPane;

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

    public void saveNode(ActionEvent actionEvent) {
        // @todo: save the given node, either creating new or editing an existing one.
    }
}
