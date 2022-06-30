package de.stuttgart_hdm.mi.se2.gui.controller;

import de.stuttgart_hdm.mi.se2.gui.Audio;
import de.stuttgart_hdm.mi.se2.gui.Resource;
import de.stuttgart_hdm.mi.se2.gui.Utils;
import de.stuttgart_hdm.mi.se2.gui.model.GameModel;
import de.stuttgart_hdm.mi.se2.gui.view.GameView;
import de.stuttgart_hdm.mi.se2.timer.Timer;
import javafx.fxml.FXML;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;


//TODO add documentation
public class MenuController {

    private static final Logger log = LogManager.getLogger(MenuController.class);

    private GameView gameView;
    private GameModel gameModel;

    @FXML
    private Button startGameBtn, optionBtn, exitBtn;


    @FXML
    private void initialize() {
        gameView = GameView.getGameView();
        gameModel = GameModel.getGameModel();

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
