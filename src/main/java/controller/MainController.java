package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Report;
import model.record.DimensionRecord;
import model.views.Views;
import service.ApplestoreService;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by U430p on 29.10.2014.
 */
public class MainController extends BaseController implements Initializable {

    ApplestoreService applestoreService = new ApplestoreService();

    @FXML
    public VBox createReport;
    @FXML
    public VBox openReport;
    @FXML
    public VBox report;
    @FXML
    public CreateReportController createReportController;
    @FXML
    public OpenReportController openReportController;
    @FXML
    public ReportController reportController;

    public void createReport(ActionEvent event) {
        Stage root = getRootStage(event.getTarget());
        Scene scene = getScene(Views.CREATE_REPORT);
        createReportController.setPreviousScene(root.getScene());
        setScene(root, scene);
    }

    public void openReport(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File("C:\\Users\\U430p\\Desktop\\ск"));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("xml", "*.xml"));
        File file = fileChooser.showOpenDialog(getRootStage(event.getTarget()));

        Report report = applestoreService.openReport(file);

        Stage root = getRootStage(event.getTarget());
        createReportController.initWithReport(report);
        reportController.setPreviousScene(getScene(Views.CREATE_REPORT));
        setScene(root, getScene(Views.REPORT));
    }

    public void exit() {
        System.out.println("exit");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addScene(Views.CREATE_REPORT, new Scene(createReport));
        addScene(Views.OPEN_REPORT, new Scene(openReport));
        addScene(Views.REPORT, new Scene(report));
    }
}
