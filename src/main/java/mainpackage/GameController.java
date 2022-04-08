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

public class GameController {
    public static int gameWindowWidth = 600;
    public static int gameWindowHeight = 400;

    @FXML
    private void investigate(ActionEvent event) {System.out.println("To bo implemented!");}

    @FXML
    private void interact(ActionEvent event) {System.out.println("To bo implemented!");}

    @FXML
    private void pickUp(ActionEvent event) {System.out.println("To bo implemented!");}

    @FXML
    private void optionsInGame(ActionEvent event) throws IOException {
        URL fxmlFileUrl = getClass().getClassLoader().getResource("optionsInGameScreen.fxml");
        Parent root = FXMLLoader.load(Objects.requireNonNull(fxmlFileUrl));

        Main.primaryStage.setScene(new Scene(root, OptionInGameController.optionInGameWindowWidth, OptionInGameController.optionInGameWindowHeight ));

        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        Main.primaryStage.setX((primScreenBounds.getWidth() - Main.primaryStage.getWidth()) / 2);
        Main.primaryStage.setY((primScreenBounds.getHeight() - Main.primaryStage.getHeight()) / 2);
    }

    @FXML
    private void backToMenu(ActionEvent event) throws IOException {
        URL fxmlFileUrl = getClass().getClassLoader().getResource("mainMenu.fxml");
        Parent root = FXMLLoader.load(Objects.requireNonNull(fxmlFileUrl));

        Main.primaryStage.setScene(new Scene(root, MenuController.mainWindowWidth, MenuController.mainWindowHeight));

        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        Main.primaryStage.setX((primScreenBounds.getWidth() - Main.primaryStage.getWidth()) / 2);
        Main.primaryStage.setY((primScreenBounds.getHeight() - Main.primaryStage.getHeight()) / 2);
    }
}
