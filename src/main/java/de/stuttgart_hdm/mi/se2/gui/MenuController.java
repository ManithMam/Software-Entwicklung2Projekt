package de.stuttgart_hdm.mi.se2.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;


//TODO add documentation
//TODO stile fxml elements with css not with attribute
public class MenuController {

    @FXML
    private Button startGameBtn, optionBtn, exitBtn;


    @FXML
    private void initialize() {
        startGameBtn.setOnAction(this::startGame);
        optionBtn.setOnAction(this::option);
        exitBtn.setOnAction(this::exit);
    }

    @FXML
    private void startGame(ActionEvent event) {
        Parent root = View.loadFxml(Resource.GAME_SCREEN);

        //Main.primaryStage.setScene(new Scene(root, Resource.GAME_SCREEN.getStageWidth(), Resource.GAME_SCREEN.getStageHeight()));
        View.getPrimaryStage().getScene().setRoot(root);
        //Main.primaryStage.setFullScreen(Resource.fullScreen);
        root.requestFocus();

        //changes action of back button
        View.getGameView().setOptionBackBtn(false);
    }

    @FXML
    private void option(ActionEvent event) {
        Parent root = View.loadFxml(Resource.OPTION_SCREEN);

        //Main.primaryStage.setScene(new Scene(root, Resource.OPTION_SCREEN.getStageWidth(), Resource.OPTION_SCREEN.getStageHeight()));
        View.getPrimaryStage().getScene().setRoot(root);
        //Main.primaryStage.setFullScreen(Resource.fullScreen);
        root.requestFocus();
    }

    @FXML
    private void exit(ActionEvent event) {
        View.getPrimaryStage().close();
    }
}
