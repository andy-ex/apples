package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Control;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import model.javafx.DimensionSelection;
import model.record.DimensionRecord;
import service.ApllestoreService;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by U430p on 14.10.2014.
 */
public class Controller implements Initializable {

    private ApllestoreService applestoreService = new ApllestoreService();

    @FXML
    public Node root;
    @FXML
    public ChoiceBox<DimensionRecord> fixedDimensionChoiceBox;
    @FXML
    public TableView<DimensionSelection> horizontalSelection;
    @FXML
    public TableView<DimensionSelection> verticalSelection;


    public void populate(ActionEvent event) throws IOException {
        if (event.getTarget() instanceof RadioButton) {
            String eventText = ((RadioButton) event.getTarget()).getText();
            System.out.println(eventText);

            List<DimensionRecord> fixedDimensionRecords = applestoreService.getFixedDimensionRecords(eventText.toLowerCase());
            fixedDimensionChoiceBox.getItems().clear();
            fixedDimensionChoiceBox.getItems().addAll(fixedDimensionRecords);
            fixedDimensionChoiceBox.getSelectionModel().selectFirst();
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
