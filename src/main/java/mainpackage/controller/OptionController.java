package mainpackage.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import mainpackage.Main;
import mainpackage.Utilities;


//TODO add documentation
public class OptionController {

    /*
    @FXML
    private Button btnRayTracing;
    @FXML
    private Button btnFullScreen;
    @FXML
    private Button btnBackToMenu;

    //TODO create initialize method and assign onAction attribute to stage buttons
    @FXML
    private void initialize() {
        btnRayTracing.setOnAction(this::rayTracing);
        btnFullScreen.setOnAction(this::fullScreen);
        btnBackToMenu.setOnAction(this::backToMenu);
    }
*/
    @FXML
    private void rayTracing(ActionEvent event) {
        System.err.println("Your PC is to week to handle the might of Ray Tracing!");
    }

    //TODO Dialog with or text display fullScreen on or of
    @FXML
    public void fullScreen(ActionEvent event) {
        Resource.fullScreen = !Resource.fullScreen;
    }

    //TODO change loading of primaryStage from middle of screen to last window position
    @FXML
    private void backToMenu(ActionEvent event) {
        //Parent root = Utilities.loadFxml("/fxml/gameScreen/optionInGameScreen.fxml");
        Parent root = Utilities.loadFxml(Resource.MENU_SCREEN);

        Main.primaryStage.setScene(new Scene(root, Resource.MENU_SCREEN.getStageWidth(), Resource.MENU_SCREEN.getStageHeight()));
        root.requestFocus();

        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        Main.primaryStage.setX((primScreenBounds.getWidth() - Main.primaryStage.getWidth()) / 2);
        Main.primaryStage.setY((primScreenBounds.getHeight() - Main.primaryStage.getHeight()) / 2);
    }

}
