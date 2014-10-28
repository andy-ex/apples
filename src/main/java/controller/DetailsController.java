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
import model.javafx.DimensionSelection;
import model.record.DimensionRecord;
import service.ApllestoreService;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by U430p on 27.10.2014.
 */
public class DetailsController implements Initializable {

    private ApllestoreService applestoreService = new ApllestoreService();

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

    public void init() {

        if (horizontalTableView.getItems().size() != 0) {
            return;
        }

        List<DimensionRecord> horizontal = applestoreService.getFixedDimensionRecords("apples");// applestoreService.getOrientedDimensionRecord(getHorizontalDimension(), Orientation.HORIZONTAL);
        List<DimensionRecord> vertical = applestoreService.getFixedDimensionRecords("apples");//applestoreService.getOrientedDimensionRecord(getVerticalDimension(), Orientation.VERTICAL);

        final ObservableList<DimensionSelection> horizontalSelection = FXCollections.observableArrayList();
        for (DimensionRecord record : horizontal) {
            horizontalSelection.add(new DimensionSelection(record, true));
        }

        final ObservableList<DimensionSelection> verticalSelection = FXCollections.observableArrayList();
        for (DimensionRecord record : vertical) {
            verticalSelection.add(new DimensionSelection(record, true));
        }

        horizontalTableView.getItems().addAll(horizontalSelection);
        verticalTableView.getItems().addAll(verticalSelection);
    }

    public void ok(ActionEvent event) {
        if (event.getTarget() instanceof Control) {
            Control control = (Control) event.getTarget();
            ((Stage) control.getParent().getScene().getWindow()).setScene(previousScene);
        }
    }

    private String getHorizontalDimension() {
        return "shops";
    }

    private String getVerticalDimension() {
        return "time";
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
