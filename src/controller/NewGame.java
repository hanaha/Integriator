package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;

public class NewGame {
    public Label description;

    public void create(ActionEvent actionEvent) {
        this.description.setText("Yee-haw!");
    }
}
