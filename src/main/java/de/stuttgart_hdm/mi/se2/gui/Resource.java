package de.stuttgart_hdm.mi.se2.gui;

import javafx.stage.Stage;

//TODO add documentation
public enum Resource {

    MENU_SCREEN("Main Screen", "/fxml/mainMenu.fxml", 600, 400),
    OPTION_SCREEN("Option Screen", "/fxml/optionScreen.fxml", 600, 400),
    GAME_SCREEN("Game Screen", "/fxml/gameScreen.fxml", 600, 400),
    BTN_AUDIO("Button Sound", "src/main/resources/buttonClick4.mp3");

    private static boolean inventoryList = false;
    private static int itemIndex = 0;
    private final String name;
    private final String url;
    private final double stageWidth;
    private final double stageHeight;

    Resource(String name, String url) {
        this.name = name;
        this.url = url;
        this.stageWidth = 0;
        this.stageHeight = 0;
    }

    Resource(String name, String url, double width, double height) {
        this.name = name;
        this.url = url;
        this.stageWidth = width;
        this.stageHeight = height;
    }

    //TODO get and set methods for public variables


    public static int getItemIndex() {
        return itemIndex;
    }

    public static void setItemIndex(int index) {
        itemIndex = index;
    }

    public static boolean isInventoryList() {
        return inventoryList;
    }

    public static void setInventoryList(boolean inventoryList) {
        Resource.inventoryList = inventoryList;
    }

    public String getName() {
        return this.name;
    }

    public String getUrl() {
        return this.url;
    }

    public double getStageWidth() {
        return this.stageWidth;
    }

    public double getStageHeight() {
        return this.stageHeight;
    }
}