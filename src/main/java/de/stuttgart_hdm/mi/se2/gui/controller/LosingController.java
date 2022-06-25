package de.stuttgart_hdm.mi.se2.gui.controller;

import de.stuttgart_hdm.mi.se2.gui.view.GameView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class LosingController {
    @FXML
    private Button exitBtn;

    @FXML
    private void initialize() {
        exitBtn.setOnAction(this::exit);
    }

    @FXML
    private void exit(ActionEvent event) {
        GameView.getPrimaryStage().close();
    }
}
