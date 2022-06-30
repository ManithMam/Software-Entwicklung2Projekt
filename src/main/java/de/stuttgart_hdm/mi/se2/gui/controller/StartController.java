package de.stuttgart_hdm.mi.se2.gui.controller;

import de.stuttgart_hdm.mi.se2.gui.Audio;
import de.stuttgart_hdm.mi.se2.gui.Resource;
import de.stuttgart_hdm.mi.se2.gui.model.GameModel;
import de.stuttgart_hdm.mi.se2.gui.view.GameView;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StartController {

    private static final Logger log = LogManager.getLogger(StartController.class);

    private GameModel gameModel;

    @FXML
    private Button btnStart;

    @FXML
    private void initialize() {
        gameModel = GameModel.getGameModel();

        btnStart.setOnAction(event -> {
            Audio.playAudio(Resource.BTN_AUDIO);
            log.info("Pressed start button in Start Game Scene");
            gameModel.startThread();
            GameView.getStartStage().close();
        });
    }
}
