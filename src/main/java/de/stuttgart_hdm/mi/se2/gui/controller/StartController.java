package de.stuttgart_hdm.mi.se2.gui.controller;

import de.stuttgart_hdm.mi.se2.gui.Audio;
import de.stuttgart_hdm.mi.se2.gui.Resource;
import de.stuttgart_hdm.mi.se2.gui.model.GameModel;
import de.stuttgart_hdm.mi.se2.gui.view.GameView;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * Controller for Start dialog Screen
 */
public class StartController {

    private static final Logger log = LogManager.getLogger(StartController.class);

    @FXML
    private Button btnStart;


    /**
     * invoked when startScreen.fxml loaded
     * used to set start parameters
     */
    @FXML
    private void initialize() {

        final GameModel gameModel = GameModel.getGameModel();

        btnStart.setOnAction(event -> {

            Audio.playAudio(Resource.BTN_AUDIO);
            log.info("Pressed start button in Start Game Scene");
            gameModel.startThread();
            GameView.getStartStage().close();
        });
    }
}
