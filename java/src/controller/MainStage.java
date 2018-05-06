package controller;

import data.SessionManager;
import data.World;
import data.entity.WorldEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.hibernate.Session;

import java.io.IOException;
import java.util.List;

/**
 * Application main stage controller.
 */
public class MainStage {

    public Tab tabChangeWorld;
    public Tab tabWorldTree;
    public Tab tabUnconnectedNodes;
    public Tab tabListVariables;
    public Tab tabNewNode;
    public Tab tabNewVariable;
    public Tab tabSimulations;

    public ChoiceBox selectWorld;
    public TextField name;
    public TextArea description;
    public AnchorPane newNodeTabPane;

    private World world;
    public AnchorPane root;
    private Stage stage;

    public void setStage(Stage primaryStage) {
        this.stage = primaryStage;
    }

    /**
     * Load the new node form into the new node tab.
     * @throws IOException
     */
    public void loadNewNodeForm() throws IOException {
        System.out.println("Newformloadingu!!!");

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/nodeEdit.fxml"));
        AnchorPane root = loader.load();
        this.newNodeTabPane.getChildren().add(root);

        System.out.println("Newformloadetto!!!");
    }

    /**
     * Populate the worlds list from available sources.
     */
    @FXML
    public void initialize() {
        System.out.println("Initializingu!!!");

        Session session = SessionManager.startSession();

        List result = session.createQuery( "from WorldEntity" ).list();

        SessionManager.stopSession();

        // @todo: Get a list of available worlds. Is it a file, is it a database? Whatever it is, it doesn't yet exist...

        ObservableList worlds = FXCollections.observableArrayList(result);
        this.selectWorld.setItems(worlds);

        System.out.println("Initializingu ovah!!!");
    }

    /**
     * Select a new world from those that the application has identified.
     *
     * @param actionEvent
     */
    public void selectExistingWorld(ActionEvent actionEvent) throws IOException {
        // @todo: Load the world data from world files or databases.
        this.setWorkingWorld(new World("Dummy World", "This is a dummy world for a dummy project"));
    }

    /**
     * Create a new world, with basic parameters.
     *
     * @param actionEvent
     */
    public void createNewWorld(ActionEvent actionEvent) throws IOException {
        World world = new World(this.name.getText(), this.description.getText());

        Session session = SessionManager.startSession();
        WorldEntity worldEntity = new WorldEntity(world.getName(), world.getDescription());
        session.save(worldEntity);
        SessionManager.stopSession();

        this.setWorkingWorld(world);
    }

    /**
     * Populate the application interface with the chosen world's properties.
     *
     * @param world World object.
     */
    private void setWorkingWorld(World world) throws IOException {
        // Clear world values.
        this.selectWorld.setValue(null);
        this.name.setText(null);
        this.description.setText(null);

        this.world = world;
        stage.setTitle(this.world.getName());
        // @todo: set other world properties across the interface tabs:
        // @todo: Load the world's node tree into the tree tab.

        // @todo: Load any unconnected nodes into the unconnected nodes tab.

        // @todo: Load the world's variables into the variable tab.

        // @todo: Load the new variable form into the new variable tab.

        // @todo: Load the available simulations into the simulations tab.

    }
}
