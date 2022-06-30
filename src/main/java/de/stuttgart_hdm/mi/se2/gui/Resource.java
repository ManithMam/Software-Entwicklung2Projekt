package de.stuttgart_hdm.mi.se2.gui;

//TODO add documentation
public enum Resource {

    MENU_SCREEN("mainMenu.fxml", "Menu Screen", "/fxml/mainMenu.fxml", 700, 500),
    OPTION_SCREEN("optionScreen.fxml", "Option Screen", "/fxml/optionScreen.fxml", 700, 500),
    GAME_SCREEN("gameScreen.fxml","Game Screen", "/fxml/gameScreen.fxml", 700, 500),
    LOSING_SCREEN("losingScreen.fxml", "Losing Screen", "/fxml/losingScreen.fxml", 700, 500),
    ERROR_SCREEN("errorScreen.fxml", "Warning Screen", "/fxml/errorScreen.fxml", 700, 500),
    START_GAME_SCREEN("startGame.fxml", "Start Game Screen", "/fxml/startGame.fxml", 500, 200),
    WINNING_SCREEN("winningScreen.fxml", "Winning Screen", "/fxml/winningScreen.fxml", 700, 500),
    BTN_AUDIO("gameSounds/buttonClick2.wav", "Button Audio", "buttonClick2.wav"),
    BACKGROUND_HALLWAY("gameImages/Hallway.jpg", "Hallway Background", "resources/Hallway.jpg");


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