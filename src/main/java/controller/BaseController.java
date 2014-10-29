package controller;


import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class BaseController {

    private Map<String, Scene> viewMap = new HashMap<>();

    private Scene previousScene;
    private Scene nextScene;

    public Stage getRootStage(Object object) {
        if (object instanceof Control) {
            Control control = (Control) object;
            return (Stage) control.getParent().getScene().getWindow();
        }
        return null;
    }

    public void setScene(Stage stage, Scene scene) {
        scene.getRoot().setVisible(true);
        stage.setScene(scene);
    }

    public void addScene(String view, Scene scene) {
        viewMap.put(view, scene);
    }

    public Scene getScene(String key) {
        return viewMap.get(key);
    }

    public Scene getPreviousScene() {
        return previousScene;
    }

    public void setPreviousScene(Scene previousScene) {
        this.previousScene = previousScene;
    }

    public Scene getNextScene() {
        return nextScene;
    }

    public void setNextScene(Scene nextScene) {
        this.nextScene = nextScene;
    }
}
