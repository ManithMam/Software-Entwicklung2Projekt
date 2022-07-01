package de.stuttgart_hdm.mi.se2.gui.controller;

import de.stuttgart_hdm.mi.se2.gui.Audio;
import de.stuttgart_hdm.mi.se2.gui.Resource;
import de.stuttgart_hdm.mi.se2.gui.Utils;
import de.stuttgart_hdm.mi.se2.gui.model.GameModel;
import de.stuttgart_hdm.mi.se2.gui.view.GameView;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * Controller of Winning Screen
 */
public class WinningController {

    private static final Logger log = LogManager.getLogger(WinningController.class);

    @FXML
    private Button btnBackToMenu;


    /**
     * invoked when winningScreen.fxml loaded
     * used to set start parameters
     */
    @FXML
    private void initialize() {

        btnBackToMenu.setOnAction(event -> {

            Audio.playAudio(Resource.BTN_AUDIO);
            log.info("Back to menu button has been pressed from Winning Screen");

            Parent root = Utils.loadFxml(Resource.MENU_SCREEN);
            GameView.getPrimaryStage().getScene().setRoot(root);
            root.requestFocus();

            GameModel.restartGame();
        });
    }
}
