package mainpackage.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import mainpackage.Main;
import mainpackage.Utilities;


//TODO add documentation
//TODO stile fxml elements with css not with attribute
public class OptionController {

    @FXML
    private Text textRayTracing, textFullScreen;
    @FXML
    private Button btnOffRayTracing, btnOnRayTracing, btnOffFullScreen, btnOnFullScreen, btnApply, btnBack;


    @FXML
    private void initialize() {
        btnOnRayTracing.setOnAction(event -> System.err.println("Your PC is to week to handle the might of Ray Tracing!"));
        //btnFullScreen.setOnAction(this::fullScreen);
        btnOffFullScreen.setOnAction(event -> {
            Resource.fullScreen = false;
            textFullScreen.setText("OFF");
        });
        btnOnFullScreen.setOnAction(event -> {
            Resource.fullScreen = true;
            textFullScreen.setText("ON");
        });
        btnApply.setOnAction(event -> Main.primaryStage.setFullScreen(Resource.fullScreen));
        backTo();
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

        //Main.primaryStage.setScene(new Scene(root, Resource.MENU_SCREEN.getStageWidth(), Resource.MENU_SCREEN.getStageHeight()));
        Main.primaryStage.getScene().setRoot(root);
        //Main.primaryStage.setFullScreen(Resource.fullScreen);
        root.requestFocus();
    }

    @FXML
    private void backToGame(ActionEvent event) {
        Parent root = Utilities.loadFxml(Resource.GAME_SCREEN);


        //Main.primaryStage.setScene(new Scene(root, Resource.GAME_SCREEN.getStageWidth(), Resource.GAME_SCREEN.getStageHeight()));
        Main.primaryStage.getScene().setRoot(root);
        //Main.primaryStage.setFullScreen(Resource.fullScreen);
        root.requestFocus();
    }

    @FXML
    private void backTo() {
        if (Resource.backToMenu) {
            btnBack.setOnAction(event -> {
                Parent root = Utilities.loadFxml(Resource.MENU_SCREEN);
                Main.primaryStage.getScene().setRoot(root);
                root.requestFocus();
            });
        } else {
            btnBack.setOnAction(event -> {
                Parent root = Utilities.loadFxml(Resource.GAME_SCREEN);
                Main.primaryStage.getScene().setRoot(root);
                root.requestFocus();
            });
            btnBack.setText("Back to Game");
        }
    }

}
