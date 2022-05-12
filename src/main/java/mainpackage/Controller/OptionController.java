package mainpackage.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import mainpackage.Main;
import mainpackage.Utilities;


public class OptionController {

    public static final int optionWindowWidth = 600;
    public static final int optionWindowHeight = 400;

    @FXML
    private void rayTracing(ActionEvent event) {
        System.err.println("Your PC is to week to handle the might of Ray Tracing!");
    }

    @FXML
    private void fullScreen() {
        MenuController.fullScreen = !MenuController.fullScreen;
    }

    @FXML
    private void backToMenu(ActionEvent event) {
        Parent root = Utilities.loadFxml("mainMenu.fxml", getClass());

        Main.primaryStage.setScene(new Scene(root, MenuController.mainWindowWidth, MenuController.mainWindowHeight));
        root.requestFocus();

        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        Main.primaryStage.setX((primScreenBounds.getWidth() - Main.primaryStage.getWidth()) / 2);
        Main.primaryStage.setY((primScreenBounds.getHeight() - Main.primaryStage.getHeight()) / 2);
    }

}
