package de.stuttgart_hdm.mi.se2.gui.view;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;


public class GameView {

    private boolean backToMenu;
    private static boolean fullScreen;
    private boolean roomViewSelected;
    private boolean invViewSelected;
    private static Stage primaryStage;
    private static Stage startStage;

    private static final GameView gameView = new GameView();

    private final ObservableList<Object> roomItems;
    private final ObservableList<Object> inventoryItems;


    public GameView(){
        this.backToMenu = true;
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

    public static boolean isFullScreen() {
        return fullScreen;
    }

    public static void setFullScreen(boolean status) {
        fullScreen = status;
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

    public static Stage getStartStage() {
        return startStage;
    }

    public static void setStartStage(Stage stage) {
        startStage = stage;
    }


    public ObservableList getRoomItems() {
        return this.roomItems;
    }

    public ObservableList getInventoryItems() {
        return this.inventoryItems;
    }

    public static GameView getGameView() {
        return gameView;
    }


}
