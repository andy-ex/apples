package controller;

import javafx.fxml.Initializable;
import model.Report;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Created by Dmitry on 29.10.2014.
 */
public class OpenReportController extends BaseController implements Initializable {


    private Map<String, Report> cachedReports = new HashMap<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
