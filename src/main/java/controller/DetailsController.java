package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;
import model.DimensionDetails;
import model.dimension.Orientation;
import model.javafx.DimensionSelection;
import model.record.DimensionRecord;
import service.ApplestoreService;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by U430p on 27.10.2014.
 */
public class DetailsController implements Initializable {

    private ApplestoreService applestoreService = new ApplestoreService();

    private Scene previousScene;

    @FXML
    public TableView<DimensionSelection> horizontalTableView;
    @FXML
    public TableView<DimensionSelection> verticalTableView;
    @FXML
    public TableColumn<DimensionSelection, Boolean> horizontalIsSelectedColumn;
    @FXML
    public TableColumn<DimensionSelection, String> horizontalValueColumn;
    @FXML
    public TableColumn<DimensionSelection, Boolean> verticalIsSelectedColumn;
    @FXML
    public TableColumn<DimensionSelection, String> verticalValueColumn;
    @FXML
    public Label horizontalNameLabel;
    @FXML
    public Label verticalNameLabel;

    public void init(String horizontal, String vertical) {
        swap(horizontal, vertical);

        List<DimensionRecord> horizontalDimensions = applestoreService.getOrientedDimensionRecord(horizontal, Orientation.HORIZONTAL);
        List<DimensionRecord> verticalDimensions = applestoreService.getOrientedDimensionRecord(vertical, Orientation.VERTICAL);

        horizontalNameLabel.setText(horizontal);
        verticalNameLabel.setText(vertical);

        horizontalTableView.getItems().clear();
        verticalTableView.getItems().clear();

        final ObservableList<DimensionSelection> horizontalSelection = FXCollections.observableArrayList();
        for (DimensionRecord record : horizontalDimensions) {
            horizontalSelection.add(new DimensionSelection(record, true));
        }

        final ObservableList<DimensionSelection> verticalSelection = FXCollections.observableArrayList();
        for (DimensionRecord record : verticalDimensions) {
            verticalSelection.add(new DimensionSelection(record, true));
        }

        horizontalTableView.getItems().addAll(horizontalSelection);
        verticalTableView.getItems().addAll(verticalSelection);
    }

    public void swap(String horizontal, String vertical) {
        if (horizontalNameLabel.getText().equals(horizontal)) {
            return;
        }
        ObservableList<DimensionSelection> temp = FXCollections.observableArrayList(horizontalTableView.getItems());
        horizontalTableView.getItems().clear();
        horizontalTableView.getItems().addAll(FXCollections.observableArrayList(verticalTableView.getItems()));

        verticalTableView.getItems().clear();
        verticalTableView.getItems().addAll(temp);

        horizontalNameLabel.setText(horizontal);
        verticalNameLabel.setText(vertical);
    }

    public void ok(ActionEvent event) {
        if (event.getTarget() instanceof Control) {
            Control control = (Control) event.getTarget();
            ((Stage) control.getParent().getScene().getWindow()).setScene(previousScene);
        }
    }

    public void updateHorizontalSelection(DimensionDetails details) {
        updateSelection(horizontalTableView, details);
    }

    public void updateVerticalSelection(DimensionDetails details) {
        updateSelection(verticalTableView, details);
    }

    private void updateSelection(TableView<DimensionSelection> table, DimensionDetails details) {
        ObservableList<DimensionSelection> items = table.getItems();
        List<String> selection = details.getSelection();
        for (DimensionSelection item : items) {
            if (selection.contains(item.getDimensionRecord().getValue())) {
                item.setSelected(true);
            } else {
                item.setSelected(false);
            }
        }
    }

    public TableView<DimensionSelection> getHorizontalTableView() {
        return horizontalTableView;
    }

    public TableView<DimensionSelection> getVerticalTableView() {
        return verticalTableView;
    }

    public Scene getPreviousScene() {
        return previousScene;
    }

    public void setPreviousScene(Scene previousScene) {
        this.previousScene = previousScene;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        horizontalTableView.setEditable(true);
        horizontalIsSelectedColumn.setEditable(true);
        horizontalIsSelectedColumn.setCellFactory(new Callback<TableColumn<DimensionSelection, Boolean>, TableCell<DimensionSelection, Boolean>>() {
            @Override
            public TableCell<DimensionSelection, Boolean> call(TableColumn<DimensionSelection, Boolean> param) {
                return new CheckBoxTableCell<DimensionSelection, Boolean>();
            }
        });
        horizontalIsSelectedColumn.setCellValueFactory(new PropertyValueFactory<DimensionSelection, Boolean>("selected"));
        horizontalValueColumn.setCellValueFactory(new PropertyValueFactory<DimensionSelection, String>("dimensionRecord"));

        verticalTableView.setEditable(true);
        verticalIsSelectedColumn.setEditable(true);
        verticalIsSelectedColumn.setCellFactory(new Callback<TableColumn<DimensionSelection, Boolean>, TableCell<DimensionSelection, Boolean>>() {
            @Override
            public TableCell<DimensionSelection, Boolean> call(TableColumn<DimensionSelection, Boolean> param) {
                return new CheckBoxTableCell<DimensionSelection, Boolean>();
            }
        });
        verticalIsSelectedColumn.setCellValueFactory(new PropertyValueFactory<DimensionSelection, Boolean>("selected"));
        verticalValueColumn.setCellValueFactory(new PropertyValueFactory<DimensionSelection, String>("dimensionRecord"));
    }
}
