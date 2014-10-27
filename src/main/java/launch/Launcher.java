package launch;

import dao.ApplestoreDAO;
import javafx.application.Application;
import javafx.stage.Stage;
import model.dimension.Dimension;
import model.dimension.FixedDimension;
import util.FxmlUtils;

import java.util.Arrays;

/**
 * Created by U430p on 14.10.2014.
 */
public class Launcher extends Application {

    public static void main(String[] args) {
        launch(args);
        ApplestoreDAO dao = new ApplestoreDAO();
        Dimension dimension = new FixedDimension("apples", "sort", "id");
        System.out.println(dao.getDimensionValues(dimension).get(0).getValue());
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FxmlUtils.show("/fxml/create-report.fxml", primaryStage, "Main");
    }
}
