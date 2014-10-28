package controller;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Control;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.dimension.Orientation;
import model.javafx.DimensionSelection;
import model.record.DimensionRecord;
import service.ApllestoreService;
import util.FxmlUtils;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Created by U430p on 14.10.2014.
 */
public class Controller implements Initializable {

    private ApllestoreService applestoreService = new ApllestoreService();

    private Map<String, Scene> viewMap = new HashMap<>();

    private static final String SELECTION_DETAILS = "/fxml/selection-details.fxml";
    private static final String CREATE_REPORT = "/fxml/create-report.fxml";

    private Scene previousScene;

    @FXML
    public VBox details;
    @FXML
    public ChoiceBox<DimensionRecord> fixedDimensionChoiceBox;
    @FXML
    public TableView<DimensionSelection> horizontalTableView;
    @FXML
    public TableView<DimensionSelection> verticalTableView;
    @FXML
    private DetailsController detailsController;





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
        previousScene = root.getScene();
        details.setVisible(true);
        detailsController.init();
        detailsController.setPreviousScene(previousScene);
        root.setScene(viewMap.get(SELECTION_DETAILS));

    }

    public void generate() throws IOException {
        System.out.println(detailsController);
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
        //viewMap.put(CREATE_REPORT, new Scene(details));
        viewMap.put(SELECTION_DETAILS, new Scene(details));

        //viewMap.get(SELECTION_DETAILS).show();
        //viewMap.get(SELECTION_DETAILS).hide();
    }

}
