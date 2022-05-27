package mainpackage.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import mainpackage.Main;
import mainpackage.Utilities;


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
        Parent root = Utilities.loadFxml(Resource.GAME_SCREEN);

        //Main.primaryStage.setScene(new Scene(root, Resource.GAME_SCREEN.getStageWidth(), Resource.GAME_SCREEN.getStageHeight()));
        Main.primaryStage.getScene().setRoot(root);
        //Main.primaryStage.setFullScreen(Resource.fullScreen);
        root.requestFocus();

        //changes action of back button
        Resource.backToMenu = false;
    }

    @FXML
    private void option(ActionEvent event) {
        Parent root = Utilities.loadFxml(Resource.OPTION_SCREEN);

        //Main.primaryStage.setScene(new Scene(root, Resource.OPTION_SCREEN.getStageWidth(), Resource.OPTION_SCREEN.getStageHeight()));
        Main.primaryStage.getScene().setRoot(root);
        //Main.primaryStage.setFullScreen(Resource.fullScreen);
        root.requestFocus();
    }

    @FXML
    private void exit(ActionEvent event) {
        Main.primaryStage.close();
    }
}
