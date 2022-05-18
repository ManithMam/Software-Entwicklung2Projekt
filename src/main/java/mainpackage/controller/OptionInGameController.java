package mainpackage.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Screen;
import mainpackage.Main;
import mainpackage.Utilities;


public class OptionInGameController {

    @FXML
    private Button btnRayTracing;
    @FXML
    private Button btnFullScreen;
    @FXML
    private Button btnBackToGame;

    //TODO create initialize method and assign onAction attribute to stage buttons
    @FXML
    private void initialize() {
        btnRayTracing.setOnAction(this::rayTracing);
        btnFullScreen.setOnAction(this::fullScreen);
        btnBackToGame.setOnAction(this::backToGame);
    }

    @FXML
    private void rayTracing(ActionEvent event) {
        System.err.println("Your PC is to week to handle the might of Ray Tracing!");
    }

    //TODO Dialog with or text display fullScreen on or of
    @FXML
    private void fullScreen(ActionEvent event) {
        Resource.fullScreen = !Resource.fullScreen;
        System.out.println("Fullscreen set:" + Resource.fullScreen);
    }

    //TODO change loading of primaryStage from middle of screen to last window position
    //TODO find solution for duplicate code
    @FXML
    private void backToGame(ActionEvent event) {
        //Parent root = Utilities.loadFxml("/fxml/gameScreen/gameScreen.fxml");
        Parent root = Utilities.loadFxml(Resource.GAME_SCREEN);

        Main.primaryStage.setScene(new Scene(root, Resource.GAME_SCREEN.getStageWidth(), Resource.GAME_SCREEN.getStageHeight()));
        //Main.primaryStage.setFullScreenExitHint("");
        Main.primaryStage.setFullScreen(Resource.fullScreen);
        root.requestFocus();

        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        Main.primaryStage.setX((primScreenBounds.getWidth() - Main.primaryStage.getWidth()) / 2);
        Main.primaryStage.setY((primScreenBounds.getHeight() - Main.primaryStage.getHeight()) / 2);
    }
}
