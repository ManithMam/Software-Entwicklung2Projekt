package de.stuttgart_hdm.mi.se2.gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class View {

    //private final Player player = new Player();
    private boolean backToMenu;
    private boolean fullScreen;
    private boolean roomViewSelected;
    private boolean invViewSelected;
    private static Stage primaryStage;

    private static final View gameView = new View();

    private final ObservableList roomItems;
    private final ObservableList inventoryItems;


    public View(){
        this.backToMenu = true;
        this.fullScreen = false;
        this.roomViewSelected = false;
        this.invViewSelected = false;
        this.roomItems = FXCollections.observableArrayList();
        this.inventoryItems = FXCollections.observableArrayList();
    }


    public boolean isOptionBackBtn() {
        return this.backToMenu;
    }

    public void setOptionBackBtn(boolean showMenuOptions) {
        this.backToMenu = showMenuOptions;
    }

    public boolean isFullScreen() {
        return this.fullScreen;
    }

    public void setFullScreen(boolean status) {
        this.fullScreen = status;
    }

    public boolean isRoomViewSelected() {
        return this.roomViewSelected;
    }

    public void setRoomViewSelected(boolean roomViewSelected) {
        this.roomViewSelected = roomViewSelected;
    }

    public boolean isInvViewSelected() {
        return this.invViewSelected;
    }

    public void setInvViewSelected(boolean invViewSelected) {
        this.invViewSelected = invViewSelected;
    }

    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void setPrimaryStage(Stage stage) {
        primaryStage = stage;
    }


    public ObservableList getRoomItems() {
        return this.roomItems;
    }

    public ObservableList getInventoryItems() {
        return this.inventoryItems;
    }

    public static View getGameView() {
        return gameView;
    }


    //TODO logg Exception
    //TODO error screen as dialog?
    public static Parent loadFxml(Resource resource) {
        final URL fxmlUrl = View.class.getResource(resource.getUrl());

        try {
            return FXMLLoader.load(Objects.requireNonNull(fxmlUrl));
        } catch (IOException e) {
            e.printStackTrace();

            VBox fail = new VBox();
            Label label = new Label("Failed to load " + resource.getName());

            label.setTextFill(Color.web("#FF9494"));
            fail.getChildren().add(label);
            fail.setAlignment(Pos.CENTER);

            return fail;
        }
    }
}
