package mainpackage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Objects;

public class Main extends Application {

    public static Stage primaryStage;


    @Override
    public void start(Stage primaryStage) throws Exception{
        URL fxmlFileUrl = getClass().getClassLoader().getResource("mainMenu.fxml");
        Parent root = FXMLLoader.load(Objects.requireNonNull(fxmlFileUrl));

        primaryStage.setTitle("PAIN");
        primaryStage.setScene(new Scene(root, MenuController.mainWindowWidth, MenuController.mainWindowHeight));
        primaryStage.show();
        Main.primaryStage = primaryStage;

        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        Main.primaryStage.setX((primScreenBounds.getWidth() - Main.primaryStage.getWidth()) / 2);
        Main.primaryStage.setY((primScreenBounds.getHeight() - Main.primaryStage.getHeight()) / 2);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
