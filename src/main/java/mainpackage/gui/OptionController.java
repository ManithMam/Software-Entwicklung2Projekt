package mainpackage.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import mainpackage.Main;
import mainpackage.Utilities;


//TODO add documentation
//TODO stile fxml elements with css not with attribute
public class OptionController {

    @FXML
    private Button btnRayTracing, btnFullScreen, btnBack;


    @FXML
    private void initialize() {
        btnRayTracing.setOnAction(this::rayTracing);
        //btnFullScreen.setOnAction(this::fullScreen);
        btnFullScreen.setOnAction((e) -> Resource.fullScreen = !Resource.fullScreen);
        if (Resource.optionBackBtn) {
            btnBack.setOnAction(this::backToMenu);
        } else {
            btnBack.setOnAction(this::backToGame);
            btnBack.setText("Back to Game");
        }
    }

    //TODO show text in stage or dialog
    @FXML
    private void rayTracing(ActionEvent event) {
        System.err.println("Your PC is to week to handle the might of Ray Tracing!");
    }

    //TODO Dialog or text display fullScreen on or of
    @FXML
    public void fullScreen(ActionEvent event) {
        Resource.fullScreen = !Resource.fullScreen;
    }

    @FXML
    private void backToMenu(ActionEvent event) {
        Parent root = Utilities.loadFxml(Resource.MENU_SCREEN);

        Main.primaryStage.setScene(new Scene(root, Resource.MENU_SCREEN.getStageWidth(), Resource.MENU_SCREEN.getStageHeight()));
        root.requestFocus();
    }

    @FXML
    public void backToGame(ActionEvent event) {
        Parent root = Utilities.loadFxml(Resource.GAME_SCREEN);

        Main.primaryStage.setScene(new Scene(root, Resource.GAME_SCREEN.getStageWidth(), Resource.GAME_SCREEN.getStageHeight()));
        Main.primaryStage.setFullScreen(Resource.fullScreen);
        root.requestFocus();
    }

}
