package mainpackage.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import mainpackage.Main;
import mainpackage.Utilities;


//TODO add documentation
public class MenuController {

    //TODO create initialize method and assign onAction attribute to stage buttons

    @FXML
    private void startGame(ActionEvent event) {
        Parent root = Utilities.loadFxml(Resource.GAME_SCREEN);

        Main.primaryStage.setScene(new Scene(root, Resource.GAME_SCREEN.getStageWidth(), Resource.GAME_SCREEN.getStageHeight()));
        Main.primaryStage.setFullScreen(Resource.fullScreen);
        root.requestFocus();

        //changes action of back button
        Resource.optionBackBtn = 1;
    }

    @FXML
    private void option(ActionEvent event) {
        Parent root = Utilities.loadFxml(Resource.OPTION_SCREEN);

        Main.primaryStage.setScene(new Scene(root, Resource.OPTION_SCREEN.getStageWidth(), Resource.OPTION_SCREEN.getStageHeight()));
        root.requestFocus();
    }

    @FXML
    private void exit(ActionEvent event) {
        Main.primaryStage.close();
    }

}
