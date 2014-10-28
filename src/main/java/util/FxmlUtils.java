package util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ResourceBundle;

/**
 * Created by Dmitry on 2/4/14.
 */
public class FxmlUtils {

    public static Scene loadScene(String fxmlFile) throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(FxmlUtils.class.getResource(fxmlFile));

        Parent rootNode = (Parent) loader.load(FxmlUtils.class.getResourceAsStream(fxmlFile));

        return new Scene(rootNode);
    }

    public static void show(String fxmlFile, Stage stage) throws IOException {
        show(fxmlFile, stage, "Empty title");
    }

    public static void show(String fxmlFile, Stage stage, String title) throws IOException {
        Scene scene = loadScene(fxmlFile);
        stage.setScene(scene);
        stage.setTitle(title);

        stage.show();
    }

    public static void showModal(String fxmlFile) throws IOException {
        Scene scene = loadScene(fxmlFile);
        showModal(scene);
    }

    public static void showModal(Scene scene) {
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.show();
    }

    public static void showModal(Stage stage) {
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    public static Stage createStage(String fxmlFile) throws IOException {
        Scene scene = loadScene(fxmlFile);

        Stage stage = new Stage();
        stage.setScene(scene);

        return stage;
    }

}
