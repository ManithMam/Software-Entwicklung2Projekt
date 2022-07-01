package de.stuttgart_hdm.mi.se2.gui.controller;

import de.stuttgart_hdm.mi.se2.gui.Audio;
import de.stuttgart_hdm.mi.se2.gui.Resource;
import de.stuttgart_hdm.mi.se2.gui.Utils;
import de.stuttgart_hdm.mi.se2.gui.view.GameView;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * Controller of Menu Screen
 */
public class MenuController {

    private static final Logger log = LogManager.getLogger(MenuController.class);

    @FXML
    private Button startGameBtn, optionBtn, exitBtn;


    /**
     * invoked when menuScreen.fxml loaded
     * used to set start parameters
     */
    @FXML
    private void initialize() {

        final GameView gameView = GameView.getGameView();

        startGameBtn.setOnAction(event -> {

            Audio.playAudio(Resource.BTN_AUDIO);
            log.info("Start game button has been pressed");

            Parent root = Utils.loadFxml(Resource.GAME_SCREEN);
            GameView.getPrimaryStage().getScene().setRoot(root);
            root.requestFocus();

            //changes action of back button
            gameView.setOptionBackBtn(false);

            Stage stage = new Stage();
            Parent root2 = Utils.loadFxml(Resource.START_GAME_SCREEN);
            stage.setScene(new Scene(root2, Resource.START_GAME_SCREEN.getStageWidth(), Resource.START_GAME_SCREEN.getStageHeight()));
            stage.initStyle(StageStyle.UNDECORATED);
            GameView.setStartStage(stage);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
            stage.requestFocus();

            stage.setX(GameView.getPrimaryStage().getX() + (GameView.getPrimaryStage().getWidth() / 2) - (stage.getWidth()/2));
            stage.setY(GameView.getPrimaryStage().getY() + (GameView.getPrimaryStage().getHeight() / 2) - (stage.getHeight()/2));
        });

        optionBtn.setOnAction(event -> {

            Audio.playAudio(Resource.BTN_AUDIO);
            log.info("Option button has been pressed in menu");

            Parent root = Utils.loadFxml(Resource.OPTION_SCREEN);
            GameView.getPrimaryStage().getScene().setRoot(root);
            root.requestFocus();
        });

        exitBtn.setOnAction(event -> {

            Audio.playAudio(Resource.BTN_AUDIO);
            log.info("Exit button has been pressed");

            GameView.getPrimaryStage().close();
        });
    }
}
