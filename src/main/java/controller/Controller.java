package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;
import util.FxmlUtils;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Created by U430p on 14.10.2014.
 */
public class Controller implements Initializable {

    Map<String, Scene> viewMap = new HashMap<>();

    @FXML
    public Node root;
    @FXML
    public RadioButton apples;

    public void populate(ActionEvent event) throws IOException {
        if (event.getTarget() instanceof RadioButton) {
            String eventText = ((RadioButton) event.getTarget()).getText();
            System.out.println(eventText);
            System.out.println(apples);
        }
    }

    public void showSelectionDetails(ActionEvent actionEvent) throws IOException {
        Stage root = getRootStage(actionEvent.getTarget());

    }

    public void generate() throws IOException {
    }

    private Stage getRootStage(Object object) {
        if (object instanceof Control) {
            Control control = (Control) object;
            return (Stage) control.getParent().getScene().getWindow();
        }
        return null;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}
