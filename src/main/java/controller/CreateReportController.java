package controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.DimensionDetails;
import model.Report;
import model.dimension.Orientation;
import model.javafx.DimensionSelection;
import model.record.DimensionRecord;
import model.views.Views;
import service.ApplestoreService;

import java.io.IOException;
import java.net.URL;
import java.util.*;

/**
 * Created by U430p on 14.10.2014.
 */
public class CreateReportController extends BaseController implements Initializable {

    private ApplestoreService applestoreService = new ApplestoreService();

    private List<String> dimensions;
    private boolean updateDetails = true;

    @FXML
    public VBox details;
    @FXML
    public VBox report;

    @FXML
    private DetailsController detailsController;
    @FXML
    private ReportController reportController;

    @FXML
    public ChoiceBox<DimensionRecord> fixedDimensionChoiceBox;
    @FXML
    private ChoiceBox<String> horizontalDimensionChoiceBox;

    @FXML
    RadioButton firstRadioButton;
    @FXML
    RadioButton secondRadioButton;
    @FXML
    RadioButton thirdRadioButton;

    public void init(Report report) {

    }

    public void populate(ActionEvent event) throws IOException {
        if (event.getTarget() instanceof RadioButton) {
            String eventText = ((RadioButton) event.getTarget()).getText();
            System.out.println(eventText);

            String fixedDimensionName = eventText.toLowerCase();
            populateChoiceBoxes(fixedDimensionName);
        }
    }

    private void populateChoiceBoxes(String fixedDimensionName) {
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

    public void generate(ActionEvent event) throws IOException {
        detailsController.swap(getHorizontalDimension(), getVerticalDimension());

        DimensionRecord fixedRecord = fixedDimensionChoiceBox.getValue();

        DimensionDetails horizontalDetails = createDimensionDetails(getHorizontalDimension(), Orientation.HORIZONTAL);
        DimensionDetails verticalDetails = createDimensionDetails(getVerticalDimension(), Orientation.VERTICAL);

        Report report = applestoreService.generateReport(fixedRecord, horizontalDetails, verticalDetails);

        Stage root = getRootStage(event.getTarget());
        reportController.createReport(report);
        reportController.setPreviousScene(root.getScene());
        setScene(root, getScene(Views.REPORT));

    }

    private DimensionDetails createDimensionDetails(String dimension, Orientation orientation) {
        DimensionDetails details = new DimensionDetails(dimension, orientation);
        details.setFull(true);
        ObservableList<DimensionSelection> items = Orientation.HORIZONTAL.equals(orientation) ?
                detailsController.getHorizontalTableView().getItems() : detailsController.getVerticalTableView().getItems();

        List<String> selection = new ArrayList<>();
        for (DimensionSelection item : items) {
            if (item.getSelected()) {
                selection.add(item.getDimensionRecord().getValue());
            } else {
                details.setFull(false);
            }
        }
        if (!details.isFull()) {
            details.setSelection(selection);
        }

        return details;
    }

    public void showSelectionDetails(ActionEvent actionEvent) throws IOException {
        //detailsController.swap(getHorizontalDimension(), getVerticalDimension());
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

    public void initWithReport(Report report) {
        String fixedDimensionName = report.getFixedDimension().getName();

        if (fixedDimensionName.equals(firstRadioButton.getText())) {
            firstRadioButton.setSelected(true);
        } else if (fixedDimensionName.equals(secondRadioButton.getText())) {
            secondRadioButton.setSelected(true);
        } else {
            thirdRadioButton.setSelected(true);
        }
        populateChoiceBoxes(fixedDimensionName);

        ObservableList<DimensionRecord> fixedDimensionValues = fixedDimensionChoiceBox.getItems();
        for (DimensionRecord fixedDimensionValue : fixedDimensionValues) {
            if (report.getFixedDimension().getFixedValue().equals(fixedDimensionValue.getValue())) {
                fixedDimensionChoiceBox.getSelectionModel().select(fixedDimensionValue);
            }
        }

        horizontalDimensionChoiceBox.getSelectionModel().select(report.getHorizontalDimensionDetails().getDimensionName());

        detailsController.init(getHorizontalDimension(), getVerticalDimension());

        if (!report.getHorizontalDimensionDetails().isFull()) {
            detailsController.updateHorizontalSelection(report.getHorizontalDimensionDetails());
        }
        if (!report.getVerticalDimensionDetails().isFull()) {
            detailsController.updateVerticalSelection(report.getVerticalDimensionDetails());
        }

        updateDetails = false;

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addScene(Views.SELECTION_DETAILS, new Scene(details));
        addScene(Views.REPORT, new Scene(report));

        dimensions = new ArrayList<>(applestoreService.getDimensionNames());

        firstRadioButton.setText(dimensions.get(0));
        secondRadioButton.setText(dimensions.get(1));
        thirdRadioButton.setText(dimensions.get(2));

    }

}
