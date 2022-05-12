package mainpackage;

import classes.Items;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import mainpackage.Controller.MenuController;


public class Main extends Application {

    public static Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        Parent root = Utilities.loadFxml("mainMenu.fxml", getClass());

        primaryStage.setTitle("PAIN");
        primaryStage.setScene(new Scene(root, MenuController.mainWindowWidth, MenuController.mainWindowHeight));
        primaryStage.show();
        Main.primaryStage = primaryStage;
        root.requestFocus();

        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        Main.primaryStage.setX((primScreenBounds.getWidth() - Main.primaryStage.getWidth()) / 2);
        Main.primaryStage.setY((primScreenBounds.getHeight() - Main.primaryStage.getHeight()) / 2);
    }

    public static void main(String[] args) {
        Items.loadItems();
        launch(args);
    }
}
