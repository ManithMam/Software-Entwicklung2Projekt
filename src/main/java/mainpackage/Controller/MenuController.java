package mainpackage.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import mainpackage.Main;
import mainpackage.Utilities;


public class MenuController {

    public static boolean fullScreen = false;
    public static final int mainWindowWidth = 600;
    public static final int mainWindowHeight = 400;

    @FXML
    private void startGame(ActionEvent event) {
        Parent root = Utilities.loadFxml("gameScreen.fxml", getClass());

        Main.primaryStage.setScene(new Scene(root, GameController.gameWindowWidth, GameController.gameWindowHeight));
        Main.primaryStage.setFullScreenExitHint("");
        Main.primaryStage.setFullScreen(fullScreen);
        root.requestFocus();

        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        Main.primaryStage.setX((primScreenBounds.getWidth() - Main.primaryStage.getWidth()) / 2);
        Main.primaryStage.setY((primScreenBounds.getHeight() - Main.primaryStage.getHeight()) / 2);
    }

    @FXML
    private void options(ActionEvent event) {
        Parent root = Utilities.loadFxml("optionScreen.fxml", getClass());

        Main.primaryStage.setScene(new Scene(root, OptionController.optionWindowWidth, OptionController.optionWindowHeight));
        root.requestFocus();

        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        Main.primaryStage.setX((primScreenBounds.getWidth() - Main.primaryStage.getWidth()) / 2);
        Main.primaryStage.setY((primScreenBounds.getHeight() - Main.primaryStage.getHeight()) / 2);
    }

    @FXML
    private void exit(ActionEvent event) {
        System.exit(0);
    }

}
