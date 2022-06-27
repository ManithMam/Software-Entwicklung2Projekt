package de.stuttgart_hdm.mi.se2.gui.controller;

import de.stuttgart_hdm.mi.se2.gui.Resource;
import de.stuttgart_hdm.mi.se2.gui.Utils;
import de.stuttgart_hdm.mi.se2.gui.view.GameView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.text.Text;


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
            GameView.getGameView().setFullScreen(false);
            textFullScreen.setText("OFF");
        });
        btnOnFullScreen.setOnAction(event -> {
            GameView.getGameView().setFullScreen(true);
            textFullScreen.setText("ON");
        });
        btnApply.setOnAction(event -> GameView.getPrimaryStage().setFullScreen(GameView.getGameView().isFullScreen()));
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
        GameView.getGameView().setFullScreen(!GameView.getGameView().isFullScreen());
    }

    @FXML
    private void backToMenu(ActionEvent event) {
        Parent root = Utils.loadFxml(Resource.MENU_SCREEN);

        //Main.primaryStage.setScene(new Scene(root, Resource.MENU_SCREEN.getStageWidth(), Resource.MENU_SCREEN.getStageHeight()));
        GameView.getPrimaryStage().getScene().setRoot(root);
        //Main.primaryStage.setFullScreen(Resource.fullScreen);
        root.requestFocus();
    }

    @FXML
    private void backToGame(ActionEvent event) {
        Parent root = Utils.loadFxml(Resource.GAME_SCREEN);


        //Main.primaryStage.setScene(new Scene(root, Resource.GAME_SCREEN.getStageWidth(), Resource.GAME_SCREEN.getStageHeight()));
        GameView.getPrimaryStage().getScene().setRoot(root);
        //Main.primaryStage.setFullScreen(Resource.fullScreen);
        root.requestFocus();
    }

    @FXML
    private void backTo() {
        if (GameView.getGameView().isOptionBackBtn()) {
            btnBack.setOnAction(event -> {
                Parent root = Utils.loadFxml(Resource.MENU_SCREEN);
                GameView.getPrimaryStage().getScene().setRoot(root);
                root.requestFocus();
            });
        } else {
            btnBack.setOnAction(event -> {
                Parent root = Utils.loadFxml(Resource.GAME_SCREEN);
                GameView.getPrimaryStage().getScene().setRoot(root);
                root.requestFocus();
            });
            btnBack.setText("Back to Game");
        }
    }

}
