package de.stuttgart_hdm.mi.se2;

import de.stuttgart_hdm.mi.se2.gui.Model;
import de.stuttgart_hdm.mi.se2.gui.View;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import de.stuttgart_hdm.mi.se2.gui.Resource;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import timer.Timer;
public class Main extends Application {

    //Test for pickUp method in GameController
    public static ArrayList<Object> items;
    public static ArrayList<Object> inventoryList;

    private static final Logger log = LogManager.getLogger(Main.class);

    @Override
    public void start(Stage primaryStage) {
        Parent root = View.loadFxml(Resource.MENU_SCREEN);

        primaryStage.setTitle("PAIN");
        primaryStage.setScene(new Scene(root, Resource.MENU_SCREEN.getStageWidth(), Resource.MENU_SCREEN.getStageHeight()));
        primaryStage.setFullScreenExitHint("");
        primaryStage.show();
        View.setPrimaryStage(primaryStage);
        root.requestFocus();

        //render stage in middle of screen
        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        primaryStage.setX((primScreenBounds.getWidth() - primaryStage.getWidth()) / 2);
        primaryStage.setY((primScreenBounds.getHeight() - primaryStage.getHeight()) / 2);
    }

    public static void main(String[] args) {

        Timer timer = new Timer();
        Thread thread = new Thread(timer);
        thread.setDaemon(true);
        thread.start();

        log.info("test");

        Model model = new Model();
        //System.out.println(model.getRoomsList().get(0).getName());
        System.out.println(model.getRoomsList().get(0).getItemsInRoom().get(0).getName());
        //System.out.println(Room.itemInRoom.isEmpty());
        //System.out.println(Item.itemList.get(0).getName());
        //Test for pickUp method in GameController
        items = new ArrayList<>();
        items.add("Hat");
        items.add("Ball");
        items.add("Chair");
        items.add("Key");

        inventoryList = new ArrayList<>();
        inventoryList.add("Rope");
        inventoryList.add("Egg");
        inventoryList.add("Knife");

        launch(args);
    }
}
