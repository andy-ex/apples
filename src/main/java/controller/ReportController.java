package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.Report;
import model.record.ReportRecord;
import model.views.Views;
import util.FxmlUtils;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by U430p on 29.10.2014.
 */
public class ReportController extends BaseController implements Initializable {

    @FXML
    public ScatterChart<String, String> reportChart;
    @FXML
    public Label chartDescription;

    public void createReport(Report report) {

//        XYChart.Series<String, String> series = new XYChart.Series<>();
//        ObservableList<String> data = FXCollections.observableArrayList();
//
//        XYChart.Data<String, String> data1 = new XYChart.Data<>("Monday", "Crown", 1);
//        data1.setNode(new Label("value"));
//
//        XYChart.Data<String, String> data2 = new XYChart.Data<>("Tuesday", "Golden", 2);
//        data2.setNode(new Label("value2"));
//
//        XYChart.Data<String, String> data3 = new XYChart.Data<>("Tuesday", "Golden", 2);
//        data3.setNode(new Label("value3"));
//
//        series.getData().add(data1);
//        series.getData().add(data2);
//        series.getData().add(data3);

        //reportChart = new ScatterChart<String, String>(new CategoryAxis(), new CategoryAxis());

        //reportChart.getData().addAll(series);

        reportChart.getData().clear();
        reportChart.setLegendVisible(false);

        chartDescription.setText(String.format("Dimension name: %s. Fixed value: %s", report.getFixedDimension().getName(),
                report.getFixedDimension().getFixedValue()));

        reportChart.getXAxis().setLabel(report.getHorizontalDimensionDetails().getDimensionName());
        reportChart.getYAxis().setLabel(report.getVerticalDimensionDetails().getDimensionName());

        XYChart.Series<String, String> series = new XYChart.Series<>();
        for (ReportRecord reportRecord : report.getRecords()) {
            String horizontalValue = reportRecord.getHorizontalRecord().getValue();
            String verticalValue = reportRecord.getVerticalRecord().getValue();

            XYChart.Data<String, String> data = new XYChart.Data<>(horizontalValue, verticalValue);
            data.setNode(new Label(reportRecord.getFactRecord().getFact()));

            series.getData().add(data);
        }

        reportChart.getData().add(series);

    }

    public void back(ActionEvent event) {
        Stage root = getRootStage(event.getTarget());
        setScene(root, getPreviousScene());
    }

    public void save() {

    }

    public void main(ActionEvent event) throws IOException {
        FxmlUtils.show(Views.MAIN, getRootStage(event.getTarget()));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
