package mainpackage.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import mainpackage.Main;
import mainpackage.Utilities;


//TODO add documentation
public class GameController {

    @FXML
    private HBox roomOneBtns;
    @FXML
    private VBox actions;
    @FXML
    private Button btnBackToMenu, btnOptionsInGame, btnChangeRoom;


    //TODO add rest of buttons
    @FXML
    private void initialize() {
        //Buttons of actions
        btnBackToMenu.setOnAction(this::backToMenu);
        btnOptionsInGame.setOnAction(this::optionInGame);
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

    //TODO add method to display itemlist

    //TODO add method to display text

    //TODO add other roomBtns and set to false (dynamically?)
    @FXML
    private void loadActions(ActionEvent event) {
        roomOneBtns.setVisible(false);
        roomOneBtns.setManaged(false);
        actions.setVisible(true);
        actions.setManaged(true);
        actions.requestFocus();
    }

    //TODO (dynamically?) set roomBtns of currently selected room to true
    @FXML
    private void backToRoomBtns(ActionEvent event) {
        roomOneBtns.setVisible(true);
        roomOneBtns.setManaged(true);
        actions.setVisible(false);
        actions.setManaged(false);
        roomOneBtns.requestFocus();
    }

    //TODO implement getItemId and getDesc method from Items class
    @FXML
    private void inspect(ActionEvent event) {
        System.out.println("To bo implemented!");
    }

    //TODO implement yet to be written methods
    @FXML
    private void use(ActionEvent event) {
        System.out.println("To bo implemented!");
    }

    //TODO implement getItemId, isPable and yet to be written methods from Items class
    @FXML
    private void pickUp(ActionEvent event) {
        System.out.println("To bo implemented!");
    }

    //TODO implement yet to be written methods
    @FXML
    private void changeRoom(ActionEvent event) {
        System.out.println("To be implemented");
    }

    //TODO (maybe as Dialog?)
    @FXML
    private void optionInGame(ActionEvent event) {
        Parent root = Utilities.loadFxml(Resource.OPTION_SCREEN);

        Main.primaryStage.setScene(new Scene(root, Resource.OPTION_SCREEN.getStageWidth(), Resource.OPTION_SCREEN.getStageHeight()));
        Main.primaryStage.setFullScreen(Resource.fullScreen);
        root.requestFocus();
    }

    @FXML
    private void backToMenu(ActionEvent event) {
        Parent root = Utilities.loadFxml(Resource.MENU_SCREEN);

        Main.primaryStage.setScene(new Scene(root, Resource.MENU_SCREEN.getStageWidth(), Resource.MENU_SCREEN.getStageHeight()));
        root.requestFocus();

        //changes action of back button
        Resource.optionBackBtn = 0;
    }

}
