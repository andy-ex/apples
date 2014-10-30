package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.FileChooser;
import model.Report;
import service.ApplestoreService;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Dmitry on 29.10.2014.
 */
public class OpenReportController extends BaseController implements Initializable {

    ApplestoreService service = new ApplestoreService();

    @FXML
    ReportController reportController;

    public Report openReport(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(getRootStage(event.getTarget()));

        return service.openReport(file);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
