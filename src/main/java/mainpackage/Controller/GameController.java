package mainpackage.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import mainpackage.Main;
import mainpackage.Utilities;


public class GameController {
    public static int gameWindowWidth = 600;
    public static int gameWindowHeight = 400;

    @FXML
    private HBox roomOneBtns;
    @FXML
    private VBox actions;
    @FXML
    private Button btnBackToMenu, btnOptionsInGame,btnChangeRoom;


    @FXML
    private void initialize(){
        //Buttons of actions
        btnBackToMenu.setOnAction(this::backToMenu);
        btnOptionsInGame.setOnAction(this::optionsInGame);
        btnChangeRoom.setOnAction(this::changeRoom);
        Button btnInspect = (Button) actions.lookup("#btnInspect");
        btnInspect.setOnAction(this::inspect);
        Button btnUse = (Button) actions.lookup("#btnUse");
        btnUse.setOnAction(this::use);
        Button btnPickUp = (Button) actions.lookup("#btnPickUp");
        btnPickUp.setOnAction(this::pickUp);
        Button btnBackToChoseItem = (Button) actions.lookup("#btnBackToChoseItem");
        btnBackToChoseItem.setOnAction(this::backToRoomBtns);

        //Buttons of roomOneBtns
        Button room1Btn1 = (Button) roomOneBtns.lookup("#room1Btn1");
        room1Btn1.setOnAction(this::loadActions);
        Button room1Btn2 = (Button) roomOneBtns.lookup("#room1Btn2");
        room1Btn2.setOnAction(this::loadActions);
        Button room1Btn3 = (Button) roomOneBtns.lookup("#room1Btn3");
        room1Btn3.setOnAction(this::loadActions);
        Button room1Btn4 = (Button) roomOneBtns.lookup("#room1Btn4");
        room1Btn4.setOnAction(this::loadActions);

    }

    @FXML
    private void loadActions(ActionEvent event){
        roomOneBtns.setVisible(false);
        roomOneBtns.setManaged(false);
        actions.setVisible(true);
        actions.setManaged(true);

    }

    @FXML
    private void backToRoomBtns(ActionEvent event){
        roomOneBtns.setVisible(true);
        roomOneBtns.setManaged(true);
        actions.setVisible(false);
        actions.setManaged(false);
    }

    @FXML
    private void inspect(ActionEvent event) {System.out.println("To bo implemented!");}

    @FXML
    private void use(ActionEvent event) {System.out.println("To bo implemented!");}

    @FXML
    private void pickUp(ActionEvent event) {System.out.println("To bo implemented!");}

    @FXML
    private void changeRoom(ActionEvent event) {
        System.out.println("To be implemented");
    }

    @FXML
    private void optionsInGame(ActionEvent event){
        Parent root = Utilities.loadFxml("optionsInGameScreen.fxml", getClass());

        Main.primaryStage.setScene(new Scene(root, OptionInGameController.optionInGameWindowWidth, OptionInGameController.optionInGameWindowHeight ));
        Main.primaryStage.setFullScreenExitHint("");
        Main.primaryStage.setFullScreen(MenuController.fullScreen);
        root.requestFocus();

        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        Main.primaryStage.setX((primScreenBounds.getWidth() - Main.primaryStage.getWidth()) / 2);
        Main.primaryStage.setY((primScreenBounds.getHeight() - Main.primaryStage.getHeight()) / 2);
    }

    @FXML
    private void backToMenu(ActionEvent event) {
        Parent root = Utilities.loadFxml("mainMenu.fxml", getClass());

        Main.primaryStage.setScene(new Scene(root, MenuController.mainWindowWidth, MenuController.mainWindowHeight));
        root.requestFocus();

        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        Main.primaryStage.setX((primScreenBounds.getWidth() - Main.primaryStage.getWidth()) / 2);
        Main.primaryStage.setY((primScreenBounds.getHeight() - Main.primaryStage.getHeight()) / 2);
    }

}
