package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.views.Views;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by U430p on 29.10.2014.
 */
public class MainController extends BaseController implements Initializable {



    @FXML
    public VBox createReport;
    @FXML
    public VBox openReport;
    @FXML
    public CreateReportController createReportController;
    @FXML
    public OpenReportController openReportController;

    public void createReport(ActionEvent event) {
        Stage root = getRootStage(event.getTarget());
        Scene scene = getScene(Views.CREATE_REPORT);
        createReportController.setPreviousScene(root.getScene());
        setScene(root, scene);
    }

    public void openReport(ActionEvent event) {
        Stage root = getRootStage(event.getTarget());
        setScene(root, getScene(Views.OPEN_REPORT));
    }

    public void exit() {
        System.out.println("exit");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addScene(Views.CREATE_REPORT, new Scene(createReport));
        addScene(Views.OPEN_REPORT, new Scene(openReport));
    }
}
