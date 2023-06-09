package de.stuttgart_hdm.mi.se2.gui.controller;

import de.stuttgart_hdm.mi.se2.gui.Audio;
import de.stuttgart_hdm.mi.se2.gui.Resource;
import de.stuttgart_hdm.mi.se2.gui.Utils;
import de.stuttgart_hdm.mi.se2.gui.model.GameModel;
import de.stuttgart_hdm.mi.se2.gui.view.GameView;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * Controller of Option Screen
 */
public class OptionController {

    private static final Logger log = LogManager.getLogger(OptionController.class);

    private GameView gameView;

    @FXML
    private Label textFullScreen, textCheatMode, errorText;
    @FXML
    private Button btnOffRayTracing, btnOnRayTracing, btnOffFullScreen, btnOnFullScreen, btnOffCheatMode, btnOnCheatMode, btnApply, btnBack;


    /**
     * invoked when optionScreen.fxml loaded
     * used to set start parameters
     */
    @FXML
    private void initialize() {

        gameView = GameView.getGameView();
        final GameModel gameModel = GameModel.getGameModel();

        final String text1 = "OFF";
        final String text2 = "ON";
        final String text3 = "Fullscreen has been set to: ";
        final String text4 = "Cheat Mode has been set to: ";
        final String text5 = "";

        if(GameView.isFullScreen()) {
            textFullScreen.setText(text2);
        } else {
            textFullScreen.setText(text1);
        }

        if(gameModel.isCheatMode()){
            textCheatMode.setText(text2);
        } else {
            textCheatMode.setText(text1);
        }

        btnOffRayTracing.setOnAction(event -> Audio.playAudio(Resource.BTN_AUDIO));

        btnOnRayTracing.setOnAction(event -> {

            Audio.playAudio(Resource.BTN_AUDIO);
            errorText.setText("Your PC is to week to handle the might of Ray Tracing!");
            log.info("On button for Ray-Tracing has been pushed");
        });

        btnOffFullScreen.setOnAction(event -> {

            Audio.playAudio(Resource.BTN_AUDIO);
            GameView.setFullScreen(false);
            textFullScreen.setText(text1);
            log.info(text3 + text1);
            errorText.setText(text5);
        });

        btnOnFullScreen.setOnAction(event -> {

            Audio.playAudio(Resource.BTN_AUDIO);
            GameView.setFullScreen(true);
            textFullScreen.setText(text2);
            log.info(text3 + text2);
        });

        btnOffCheatMode.setOnAction(event -> {

            Audio.playAudio(Resource.BTN_AUDIO);
            gameModel.setCheatMode(false);
            textCheatMode.setText(text1);
            log.info(text4 + text1);
            errorText.setText(text5);
        });

        btnOnCheatMode.setOnAction(event -> {

            Audio.playAudio(Resource.BTN_AUDIO);
            gameModel.setCheatMode(true);
            textCheatMode.setText(text2);
            log.info(text4 + text2);
            errorText.setText("All rooms are unlocked now.");
        });

        btnApply.setOnAction(event -> {

            Audio.playAudio(Resource.BTN_AUDIO);
            GameView.getPrimaryStage().setFullScreen(GameView.isFullScreen());
            errorText.setText(text5);
            log.info("Settings were applied");
        });

        backTo();
    }


    /**
     * sets the action of btnBack depending on from where the option screen was entered
     */
    private void backTo() {

        if (gameView.isOptionBackBtn()) {

            btnBack.setOnAction(event -> {

                Audio.playAudio(Resource.BTN_AUDIO);
                Parent root = Utils.loadFxml(Resource.MENU_SCREEN);
                GameView.getPrimaryStage().getScene().setRoot(root);
                root.requestFocus();
                log.info("Back to Menu button has been pressed");
            });

        } else {

            btnBack.setOnAction(event -> {

                Audio.playAudio(Resource.BTN_AUDIO);
                Parent root = Utils.loadFxml(Resource.GAME_SCREEN);
                GameView.getPrimaryStage().getScene().setRoot(root);
                root.requestFocus();
                log.info("Back to Game button has been pressed");
            });

            btnBack.setText("Back to Game");
        }
    }

}
