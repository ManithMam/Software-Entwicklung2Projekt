package de.stuttgart_hdm.mi.se2.gui;

//TODO add documentation
public enum Resource {

    MENU_SCREEN("mainMenu.fxml", "Menu Screen", "/fxml/mainMenu.fxml", 600, 400),
    OPTION_SCREEN("optionScreen.fxml", "Option Screen", "/fxml/optionScreen.fxml", 600, 400),
    GAME_SCREEN("gameScreen.fxml","Game Screen", "/fxml/gameScreen.fxml", 600, 400),
    LOSING_SCREEN("losingScreen.fxml", "Losing Screen", "/fxml/losingScreen.fxml", 600, 400),
    ERROR_SCREEN("errorScreen.fxml", "Warning Screen", "/fxml/errorScreen.fxml", 600, 400),
    BTN_AUDIO("buttonClick4.mp3", "Button Audio", "src/main/resources/gameSounds/buttonClick4.mp3"),
    BACKGROUND_HALLWAY("gameImages/cameron-hillman-highresscreenshot00002.jpg", "Hallway Background", "resources/cameron-hillman-highresscreenshot00002.jpg");


    private static boolean inventoryList = false;
    private static int itemIndex = 0;
    private final String name;
    private final String desc;
    private final String url;
    private final double stageWidth;
    private final double stageHeight;

    Resource(String name, String desc, String url) {
        this.name = name;
        this.desc = desc;
        this.url = url;
        this.stageWidth = 0;
        this.stageHeight = 0;
    }

    Resource(String name, String desc, String url, double width, double height) {
        this.name = name;
        this.desc = desc;
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

    public String getDesc() {
        return desc;
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