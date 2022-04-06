package mainpackage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class MenuController {

    public static boolean fullScreen = false;

    @FXML
    private void startGame(ActionEvent event) throws IOException {
        URL fxmlFileUrl = getClass().getClassLoader().getResource("gameScreen.fxml");
        Parent root = FXMLLoader.load(Objects.requireNonNull(fxmlFileUrl));

        Main.primaryStage.setScene(new Scene(root, GameController.gameWindowWidth, GameController.gameWindowHeight));
        Main.primaryStage.setFullScreenExitHint("");
        Main.primaryStage.setFullScreen(fullScreen);

        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        Main.primaryStage.setX((primScreenBounds.getWidth() - Main.primaryStage.getWidth()) / 2);
        Main.primaryStage.setY((primScreenBounds.getHeight() - Main.primaryStage.getHeight()) / 2);
    }

    @FXML
    private void options(ActionEvent event) throws IOException {
        URL fxmlFileUrl = getClass().getClassLoader().getResource("optionScreen.fxml");
        Parent root = FXMLLoader.load(Objects.requireNonNull(fxmlFileUrl));

        Main.primaryStage.setScene(new Scene(root, 300, 275));

        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        Main.primaryStage.setX((primScreenBounds.getWidth() - Main.primaryStage.getWidth()) / 2);
        Main.primaryStage.setY((primScreenBounds.getHeight() - Main.primaryStage.getHeight()) / 2);
    }

    @FXML
    private void exit(ActionEvent event) {
        System.exit(0);
    }

}
