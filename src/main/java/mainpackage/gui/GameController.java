package mainpackage.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import mainpackage.Main;
import mainpackage.Utilities;


//TODO add documentation
//TODO stile fxml elements with css not with attribute
//TODO add inventory button
public class GameController {

    @FXML
    private HBox roomOneBtns;
    @FXML
    private VBox actions, showText, inventory;
    @FXML
    private Button btnBackToMenu, btnOptionsInGame, btnChangeRoom;


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
        /*
        Button room1Btn1 = (Button) roomOneBtns.lookup("#room1Btn1");
        room1Btn1.setOnAction(this::selectItem);
        Button room1Btn2 = (Button) roomOneBtns.lookup("#room1Btn2");
        room1Btn2.setOnAction(this::selectItem);
        Button room1Btn3 = (Button) roomOneBtns.lookup("#room1Btn3");
        room1Btn3.setOnAction(this::selectItem);
        Button room1Btn4 = (Button) roomOneBtns.lookup("#room1Btn4");
        room1Btn4.setOnAction(this::selectItem);
         */
        //TODO replace 4 with current room itemList size (foreach?)
        for(int i = 1; i<= 4; i++) {
            Button button = new Button();
            button.setText("" + i);
            button.setId("" + i);
            button.setOnAction(this::selectItem);
            roomOneBtns.getChildren().add(button);
        }

        //TODO make method out of it
        for(int i = 0; i < 5; i++) {
            Text text = new Text();
            //replace with item name
            text.setText("Test text");
            showText.getChildren().add(text);
        }

        //TODO make method out of it
        for(int i = 0; i < 20; i++) {
            Text text = new Text();
            //replace with item name
            text.setText("- Test text");
            inventory.getChildren().add(text);
        }
    }

    //TODO add method to display inventory list

    //TODO add method to display text

    @FXML
    private void selectItem(ActionEvent event) {
        Resource.itemIndex = Integer.parseInt(((Button) event.getSource()).getText()) - 1;

        roomOneBtns.setVisible(false);
        roomOneBtns.setManaged(false);
        actions.setVisible(true);
        actions.setManaged(true);
        actions.requestFocus();
    }

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
        //removes buttons if Item gets picked up
        //TODO replace Main.Items with ArrayList of selected room
        roomOneBtns.getChildren().removeIf(button -> Integer.parseInt(((Button) button).getText()) == Main.items.size());
        //replace with remove method from Room
        Main.items.remove(Main.items.size() - 1);
        System.out.println("To be implemented!");
        System.out.println(Main.items.size());
        backToRoomBtns(event);
    }

    //TODO implement yet to be written methods
    @FXML
    private void changeRoom(ActionEvent event) {
        System.out.println("To be implemented");
    }

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

        //changes action of backTo button in optionScreen
        Resource.optionBackBtn = true;
    }

}
