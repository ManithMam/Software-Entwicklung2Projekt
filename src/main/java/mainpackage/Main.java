package mainpackage;

import classes.Items;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import mainpackage.gui.Resource;


public class Main extends Application {

    public static Stage primaryStage;


    @Override
    public void start(Stage primaryStage) {
        Parent root = Utilities.loadFxml(Resource.MENU_SCREEN);

        primaryStage.setTitle("PAIN");
        primaryStage.setScene(new Scene(root, Resource.MENU_SCREEN.getStageWidth(), Resource.MENU_SCREEN.getStageHeight()));
        primaryStage.setFullScreenExitHint("");
        primaryStage.show();
        Main.primaryStage = primaryStage;
        root.requestFocus();

        //render stage in middle of screen
        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        primaryStage.setX((primScreenBounds.getWidth() - primaryStage.getWidth()) / 2);
        primaryStage.setY((primScreenBounds.getHeight() - primaryStage.getHeight()) / 2);
    }

    public static void main(String[] args) {
        Items.loadItems();
        launch(args);
    }
}
