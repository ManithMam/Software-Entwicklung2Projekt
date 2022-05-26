package mainpackage.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
    private HBox selectItemBtns;
    @FXML
    private VBox actions, showText, inventory;
    @FXML
    private Button btnBackToMenu, btnOptionsInGame, btnChangeRoom, btnInventory;


    @FXML
    private void initialize() {
        //Buttons of actions
        btnBackToMenu.setOnAction(this::backToMenu);
        btnOptionsInGame.setOnAction(this::optionInGame);
        btnChangeRoom.setOnAction(this::changeRoom);
        btnInventory.setOnAction(this::inventory);
        Button btnInspect = (Button) actions.lookup("#btnInspect");
        btnInspect.setOnAction(this::inspect);
        Button btnUse = (Button) actions.lookup("#btnUse");
        btnUse.setOnAction(this::use);
        Button btnPickUp = (Button) actions.lookup("#btnPickUp");
        btnPickUp.setOnAction(this::pickUp);
        Button btnBackToChoseItem = (Button) actions.lookup("#btnBackToChoseItem");
        btnBackToChoseItem.setOnAction(this::backToItemsBtn);

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

        createItemBtn();
        displayItems();
        displayInventory();
    }

    //TODO make it also work with inventory list
    @FXML
    private void createItemBtn() {
        if(Resource.inventoryList) {
            for (int i = 1; i <= Main.inventoryList.size(); i++) {
                Button button = new Button();
                button.setText("" + i);
                button.setId("" + i);
                button.setOnAction(this::selectItem);
                selectItemBtns.getChildren().add(button);
            }
        } else {
            for (int i = 1; i <= Main.items.size(); i++) {
                Button button = new Button();
                button.setText("" + i);
                button.setId("" + i);
                button.setOnAction(this::selectItem);
                selectItemBtns.getChildren().add(button);
            }
        }
    }

    //TODO show selected Room name
    @FXML
    private void displayInventory() {
        inventory.getChildren().clear();
        //TODO replace with foreach of items in inventory
        for(int i = 0; i < Main.inventoryList.size(); i++) {
            Text text = new Text();
            //TODO replace with item name
            text.setText((i+1) + " " + Main.inventoryList.get(i));
            inventory.getChildren().add(text);
        }
    }

    @FXML
    private void displayItems() {
        showText.getChildren().clear();
        //TODO replace with foreach of items in room
        for(int i = 0; i < Main.items.size(); i++) {
            Text text = new Text();
            //TODO replace with item name
            text.setText((i+1) + " " + Main.items.get(i));
            showText.getChildren().add(text);
        }
    }

    @FXML
    private void selectItem(ActionEvent event) {
        Resource.itemIndex = Integer.parseInt(((Button) event.getSource()).getText()) - 1;

        selectItemBtns.setVisible(false);
        selectItemBtns.setManaged(false);
        actions.setVisible(true);
        actions.setManaged(true);
        actions.requestFocus();
    }

    @FXML
    private void backToItemsBtn(ActionEvent event) {
        selectItemBtns.setVisible(true);
        selectItemBtns.setManaged(true);
        actions.setVisible(false);
        actions.setManaged(false);
        selectItemBtns.requestFocus();
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
    //TODO make it also work with inventory list
    @FXML
    private void pickUp(ActionEvent event) {
        //removes buttons if Item gets picked up
        //TODO replace Main.Items with ArrayList of selected room
        if (Resource.inventoryList) {
            selectItemBtns.getChildren().removeIf(button -> Integer.parseInt(((Button) button).getText()) == Main.inventoryList.size());
            //replace with remove method from Room
            Main.inventoryList.remove(Resource.itemIndex);
            System.out.println(Main.inventoryList);
        } else {
            selectItemBtns.getChildren().removeIf(button -> Integer.parseInt(((Button) button).getText()) == Main.items.size());
            //replace with remove method from Room
            Main.items.remove(Resource.itemIndex);
            System.out.println(Main.items);
        }
        backToItemsBtn(event);
        displayInventory();
        displayItems();
    }

    //TODO implement yet to be written methods
    @FXML
    private void changeRoom(ActionEvent event) {
        System.out.println("To be implemented");
    }

    //TODO select inventory list
    @FXML
    private void inventory(ActionEvent event) {
        if(!Resource.inventoryList) {
            Resource.inventoryList = true;
            btnInventory.setText("Back");
            Button btnPickUp = (Button) actions.lookup("#btnPickUp");
            btnPickUp.setText("Drop");
        } else {
            Resource.inventoryList = false;
            btnInventory.setText("Inventory");
            Button btnPickUp = (Button) actions.lookup("#btnPickUp");
            btnPickUp.setText("Pick Up");
        }
        selectItemBtns.getChildren().clear();
        createItemBtn();
        backToItemsBtn(event);
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
        Resource.backToMenu = true;
    }

}
