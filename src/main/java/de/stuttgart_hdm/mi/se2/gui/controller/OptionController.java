package de.stuttgart_hdm.mi.se2.gui.controller;

import de.stuttgart_hdm.mi.se2.gui.Audio;
import de.stuttgart_hdm.mi.se2.gui.Resource;
import de.stuttgart_hdm.mi.se2.gui.Utils;
import de.stuttgart_hdm.mi.se2.gui.view.GameView;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


//TODO add documentation
//TODO stile fxml elements with css not with attribute
public class OptionController {

    private static final Logger log = LogManager.getLogger(OptionController.class);

    private GameView gameView;

    @FXML
    private Label textRayTracing, textFullScreen, errorText;
    @FXML
    private Button btnOffRayTracing, btnOnRayTracing, btnOffFullScreen, btnOnFullScreen, btnApply, btnBack;


    @FXML
    private void initialize() {
        gameView = GameView.getGameView();

        final String text1 = "OFF";
        final String text2 = "ON";
        final String text3 = "Fullscreen has been set to: ";

        if(GameView.isFullScreen()) {
            textFullScreen.setText(text2);
        } else {
            textFullScreen.setText(text1);
        }

        btnOffRayTracing.setOnAction(event -> Audio.playAudio());

        btnOnRayTracing.setOnAction(event -> {
            Audio.playAudio();
            errorText.setText("Your PC is to week to handle the might of Ray Tracing!");
            log.info("On button for Ray-Tracing has been pushed");
        });

        btnOffFullScreen.setOnAction(event -> {
            Audio.playAudio();
            GameView.setFullScreen(false);
            textFullScreen.setText(text1);
            log.info(text3 + text1);
        });

        btnOnFullScreen.setOnAction(event -> {
            Audio.playAudio();
            GameView.setFullScreen(true);
            textFullScreen.setText(text2);
            log.info(text3 + text2);
        });

        btnApply.setOnAction(event -> {
            Audio.playAudio();
            GameView.getPrimaryStage().setFullScreen(GameView.isFullScreen());
            errorText.setText("");
            log.info("Settings were applied");
        });

        backTo();
    }

    private void backTo() {
        if (gameView.isOptionBackBtn()) {
            btnBack.setOnAction(event -> {
                Audio.playAudio();
                Parent root = Utils.loadFxml(Resource.MENU_SCREEN);
                GameView.getPrimaryStage().getScene().setRoot(root);
                root.requestFocus();
                log.info("Back to Menu button has been pressed");
            });
        } else {
            btnBack.setOnAction(event -> {
                Audio.playAudio();
                Parent root = Utils.loadFxml(Resource.GAME_SCREEN);
                GameView.getPrimaryStage().getScene().setRoot(root);
                root.requestFocus();
                log.info("Back to Game button has been pressed");
            });
            btnBack.setText("Back to Game");
        }
    }

}
