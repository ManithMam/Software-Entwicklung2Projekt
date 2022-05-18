package mainpackage.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import mainpackage.Main;
import mainpackage.Utilities;


//TODO add documentation
public class MenuController {

    //TODO create initialize method and assign onAction attribute to stage buttons

    //TODO change loading of primaryStage from middle of screen to last window position
    @FXML
    private void startGame(ActionEvent event) {
        //double a = Resource.GAME_SCREEN_SIZE.getStageWidth();
        //double b = Resource.GAME_SCREEN.getStageHeight();
        //Parent root = Utilities.loadFxml("/fxml/gameScreen/gameScreen.fxml");
        Parent root = Utilities.loadFxml(Resource.GAME_SCREEN);

        //final double previousStageX = Main.primaryStage.getX();
        //final double previousStageY = Main.primaryStage.getY();

        //Main.primaryStage.setScene(new Scene(root, Resource.GAME_SCREEN_SIZE.getStageWidth(), Resource.GAME_SCREEN.getStageHeight()));
        //Main.primaryStage.setScene(new Scene(root, a, b));
        Main.primaryStage.setScene(new Scene(root, Resource.GAME_SCREEN.getStageWidth(), Resource.GAME_SCREEN.getStageHeight()));
        //Main.primaryStage.setScene(new Scene(root, Resource.width, Resource.height));
        //Main.primaryStage.setFullScreenExitHint("");
        Main.primaryStage.setFullScreen(Resource.fullScreen);
        root.requestFocus();

        //Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        //Main.primaryStage.setX(previousStageX);
        //Main.primaryStage.setY(previousStageY);

        //Main.primaryStage.setX((primScreenBounds.getWidth() - Main.primaryStage.getWidth()) / 2);
        //Main.primaryStage.setY((primScreenBounds.getHeight() - Main.primaryStage.getHeight()) / 2);

        //System.out.println(Resource.GAME_SCREEN.getStageHeight() + Resource.GAME_SCREEN.getStageWidth());
        //System.out.println("Test");
    }

    //TODO change loading of primaryStage from middle of screen to last window position
    @FXML
    private void option(ActionEvent event) {
        //Parent root = Utilities.loadFxml("/fxml/optionScreen.fxml");
        Parent root = Utilities.loadFxml(Resource.OPTION_SCREEN);

        Main.primaryStage.setScene(new Scene(root, Resource.OPTION_SCREEN.getStageWidth(), Resource.OPTION_SCREEN.getStageHeight()));
        root.requestFocus();

        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        Main.primaryStage.setX((primScreenBounds.getWidth() - Main.primaryStage.getWidth()) / 2);
        Main.primaryStage.setY((primScreenBounds.getHeight() - Main.primaryStage.getHeight()) / 2);
    }

    //TODO find better solution (currently bruteforce)
    @FXML
    private void exit(ActionEvent event) {
        Main.primaryStage.close();
        //System.exit(0);
    }

}
