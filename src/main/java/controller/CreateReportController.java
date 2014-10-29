package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Report;
import model.dimension.FixedDimension;
import model.javafx.DimensionSelection;
import model.record.DimensionRecord;
import model.views.Views;
import service.ApllestoreService;

import java.io.IOException;
import java.net.URL;
import java.util.*;

/**
 * Created by U430p on 14.10.2014.
 */
public class CreateReportController extends BaseController implements Initializable {

    private ApllestoreService applestoreService = new ApllestoreService();

    private List<String> dimensions;
    private boolean updateDetails = true;

    @FXML
    public VBox details;
    @FXML
    public ChoiceBox<DimensionRecord> fixedDimensionChoiceBox;
    @FXML
    private ChoiceBox<String> horizontalDimensionChoiceBox;
    @FXML
    private DetailsController detailsController;
    @FXML
    RadioButton firstRadioButton;
    @FXML
    RadioButton secondRadioButton;
    @FXML
    RadioButton thirdRadioButton;
    @FXML
    ToggleGroup group;

    public void populate(ActionEvent event) throws IOException {
        if (event.getTarget() instanceof RadioButton) {
            String eventText = ((RadioButton) event.getTarget()).getText();
            System.out.println(eventText);

            String fixedDimensionName = eventText.toLowerCase();
            List<DimensionRecord> fixedDimensionRecords = applestoreService.getFixedDimensionRecords(fixedDimensionName);
            fixedDimensionChoiceBox.getItems().clear();
            fixedDimensionChoiceBox.getItems().addAll(fixedDimensionRecords);
            fixedDimensionChoiceBox.getSelectionModel().selectFirst();

            horizontalDimensionChoiceBox.getItems().clear();
            for (String dimension : dimensions) {
                if (!dimension.equals(fixedDimensionName)) {
                    horizontalDimensionChoiceBox.getItems().add(dimension);
                }
            }
            horizontalDimensionChoiceBox.getSelectionModel().selectFirst();

            updateDetails = true;
        }
    }

    public void generate() throws IOException {

        Report report = new Report();

        //FixedDimension fixedDimension = new FixedDimension(fixedDimensionChoiceBox.getS)

    }

    public void showSelectionDetails(ActionEvent actionEvent) throws IOException {
        Stage root = getRootStage(actionEvent.getTarget());
        if (updateDetails) {
            detailsController.init(getHorizontalDimension(), getVerticalDimension());
            updateDetails = false;
        }
        detailsController.setPreviousScene(root.getScene());
        setScene(root, getScene(Views.SELECTION_DETAILS));
    }

    private String getFixedDimension() {
        DimensionRecord selectedItem = fixedDimensionChoiceBox.getSelectionModel().getSelectedItem();
        return selectedItem.getValue();
    }

    private String getHorizontalDimension() {
        return horizontalDimensionChoiceBox.getSelectionModel().getSelectedItem();
    }

    private String getVerticalDimension() {
        String horizontal = horizontalDimensionChoiceBox.getSelectionModel().getSelectedItem();
        String fixed = fixedDimensionChoiceBox.getSelectionModel().getSelectedItem().getDimensionName();
        for (String dimension : dimensions) {
            if (!horizontal.equals(dimension) && !fixed.equals(dimension)) {
                return dimension;
            }
        }
        return null;
    }

    public void setDimensions(List<String> dimensions) {
        this.dimensions = dimensions;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addScene(Views.SELECTION_DETAILS, new Scene(details));

        dimensions = new ArrayList<>(applestoreService.getDimensionNames());

        firstRadioButton.setText(dimensions.get(0));
        secondRadioButton.setText(dimensions.get(1));
        thirdRadioButton.setText(dimensions.get(2));

    }

}
