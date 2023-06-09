package de.stuttgart_hdm.mi.se2.gui.controller;

import de.stuttgart_hdm.mi.se2.gui.Audio;
import de.stuttgart_hdm.mi.se2.gui.Resource;
import de.stuttgart_hdm.mi.se2.gui.Utils;
import de.stuttgart_hdm.mi.se2.gui.model.GameModel;
import de.stuttgart_hdm.mi.se2.gui.view.GameView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * Controller of Losing Screen
 */
public class LosingController {

    private static final Logger log = LogManager.getLogger(LosingController.class);

    @FXML
    private Button exitBtn;


    /**
     * invoked when losingScreen.fxml loaded
     * used to set start parameters
     */
    @FXML
    private void initialize() {
        exitBtn.setOnAction(this::exit);
    }


    /**
     * action of exit button
     * @param event event in gui (e.g button press)
     */
    @FXML
    private void exit(ActionEvent event) {
        Audio.playAudio(Resource.BTN_AUDIO);
        log.info("Back to menu button has been pressed from Losing Screen");
        Parent root = Utils.loadFxml(Resource.MENU_SCREEN);
        GameView.getPrimaryStage().getScene().setRoot(root);
        root.requestFocus();
        GameModel.restartGame();
    }
}
