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
        
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FxmlUtils.show("/fxml/main.fxml", primaryStage, "Main");
    }
}
