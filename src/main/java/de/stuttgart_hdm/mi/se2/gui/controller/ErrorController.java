package de.stuttgart_hdm.mi.se2.gui.controller;

import de.stuttgart_hdm.mi.se2.gui.view.GameView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;


/**
 * Controller of Error Screen
 */
public class ErrorController {

    @FXML
    private Button exitBtn;


    /**
     * invoked when errorScreen.fxml loaded
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
        GameView.getPrimaryStage().close();
    }
}
