package mainpackage.gui;


public enum Resource {

    MENU_SCREEN("Main Screen", "/fxml/mainMenu.fxml", 600, 400),
    OPTION_SCREEN("Option Screen", "/fxml/optionScreen.fxml", 600, 400),
    GAME_SCREEN("Game Screen", "/fxml/gameScreen/gameScreen.fxml", 600, 400);

    public static int optionBackBtn = 0;
    public static boolean fullScreen = false;
    private final String name;
    private final String url;
    private final double stageWidth;
    private final double stageHeight;


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