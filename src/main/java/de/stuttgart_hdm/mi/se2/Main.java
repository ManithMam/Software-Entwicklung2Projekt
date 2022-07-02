package de.stuttgart_hdm.mi.se2;

import de.stuttgart_hdm.mi.se2.gui.Utils;
import de.stuttgart_hdm.mi.se2.gui.view.GameView;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import de.stuttgart_hdm.mi.se2.gui.Resource;

/**
 * Main class of project
 */
public class Main extends Application {


    /**
     * executes start parameter of program
     * @param primaryStage stage shown on program start
     */
    @Override
    public void start(Stage primaryStage) {

        Parent root = Utils.loadFxml(Resource.MENU_SCREEN);
        primaryStage.setTitle("PAIN");
        primaryStage.setScene(new Scene(root, Resource.MENU_SCREEN.getStageWidth(), Resource.MENU_SCREEN.getStageHeight()));
        primaryStage.setFullScreenExitHint("");
        primaryStage.show();
        GameView.setPrimaryStage(primaryStage);
        root.requestFocus();

        //render stage in middle of screen
        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        primaryStage.setX((primScreenBounds.getWidth() - primaryStage.getWidth()) / 2);
        primaryStage.setY((primScreenBounds.getHeight() - primaryStage.getHeight()) / 2);
    }

    public static void main(String[] args) {

        launch(args);
    }
}
