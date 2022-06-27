package de.stuttgart_hdm.mi.se2.gui.view;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;


public class GameView {

    //private final Player player = new Player();

    private boolean backToMenu;
    private boolean fullScreen;
    private boolean roomViewSelected;
    private boolean invViewSelected;
    private static Stage primaryStage;

    private static final GameView gameView = new GameView();

    private final ObservableList<Object> roomItems;
    private final ObservableList<Object> inventoryItems;


    public GameView(){
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

    public static GameView getGameView() {
        return gameView;
    }


}
