package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by U430p on 29.10.2014.
 */
public class ReportController implements Initializable{

    @FXML
    public ScatterChart<String, String> reportChart;

    public void createReport() {

        XYChart.Series<String, String> series = new XYChart.Series<>();
        ObservableList<String> data = FXCollections.observableArrayList();

        XYChart.Data<String, String> data1 = new XYChart.Data<>("Monday", "Crown", 1);
        data1.setNode(new Label("value"));

        XYChart.Data<String, String> data2 = new XYChart.Data<>("Tuesday", "Golden", 2);
        data2.setNode(new Label("value2"));

        XYChart.Data<String, String> data3 = new XYChart.Data<>("Tuesday", "Golden", 2);
        data3.setNode(new Label("value3"));

        series.getData().add(data1);
        series.getData().add(data2);
        series.getData().add(data3);

        //reportChart = new ScatterChart<String, String>(new CategoryAxis(), new CategoryAxis());

        reportChart.getData().addAll(series);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        createReport();
    }
}
