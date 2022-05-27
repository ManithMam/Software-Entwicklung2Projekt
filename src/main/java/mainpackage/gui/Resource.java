package mainpackage.gui;

//TODO add documentation
public enum Resource {

    MENU_SCREEN("Main Screen", "/fxml/mainMenu.fxml", 600, 400),
    OPTION_SCREEN("Option Screen", "/fxml/optionScreen.fxml", 600, 400),
    GAME_SCREEN("Game Screen", "/fxml/gameScreen.fxml", 600, 400);

    public static boolean backToMenu = true;
    public static boolean fullScreen = false;
    public static boolean roomViewSelected = false;
    public static boolean invViewSelected = false;
    public static boolean inventoryList = false;
    public static int itemIndex = 0;
    public static int roomIndex = 0;
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

    //TODO get and set methods for public variables

    /*
        public static void setOptionBackBtn(boolean showMenuOptions ) {
            optionBackBtn = showMenuOptions;
        }

        public static boolean getOptionBackBtn() {
            return optionBackBtn;
        }

        public static void setFullScreen(boolean status){
            fullScreen = status;
        }

        public static boolean getFullScreen() {
            return fullScreen;
        }

        public static void setItemIndex(int index) {
            itemIndex = index;
        }

        public static int getItemIndex() {
            return itemIndex;
        }

        public static void setRoomIndex(int index) {
            roomIndex = index;
        }

        public static int getRoomIndex() {
            return roomIndex;
        }
    */
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