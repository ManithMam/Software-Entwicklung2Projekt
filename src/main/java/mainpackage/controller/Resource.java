package mainpackage.controller;


public enum Resource {

    MENU_SCREEN          ("Main Screen",           "/fxml/mainMenu.fxml",                      600, 400),
    OPTION_SCREEN        ("Option Screen",         "/fxml/optionScreen.fxml",                  600, 400),
    GAME_SCREEN          ("Game Screen",           "/fxml/gameScreen/gameScreen.fxml",         600, 400),
    OPTION_IN_GAME_SCREEN("Option In Game Screen", "/fxml/gameScreen/optionInGameScreen.fxml", 600, 400);


    public static boolean fullScreen = false;
    final private String name;
    final private String url;
    final private double stageWidth;
    final private double stageHeight;
    final public static int width = 600;
    final public static int height = 400;


    Resource(String name, String url, double width, double height) {
        this.name = name;
        this.url = url;
        this.stageWidth = width;
        this.stageHeight = height;
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