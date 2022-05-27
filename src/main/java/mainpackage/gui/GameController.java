package mainpackage.gui;

import classes.Player;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import mainpackage.Main;
import mainpackage.Utilities;


//TODO add documentation
//TODO stile fxml elements with css not with attribute
//TODO add inventory button
//TODO LIST VIEW
public class GameController {

    //private final Player player = new Player();
    @FXML
    private HBox action;
    @FXML
    private VBox showText, inventory;
    @FXML
    private Button btnBackToMenu, btnOptionsInGame, btnChangeRoom, btnInspect, btnUse, btnPickUp;
    @FXML
    private static final ObservableList roomItems = FXCollections.observableArrayList();
    @FXML
    private static final ObservableList inventoryItems = FXCollections.observableArrayList();
    @FXML
    private ListView roomView, invView;


    @FXML
    private void initialize() {
        //Buttons of actions
        btnBackToMenu.setOnAction(event -> {
            Parent root = Utilities.loadFxml(Resource.MENU_SCREEN);

            Main.primaryStage.getScene().setRoot(root);
            root.requestFocus();

            //changes action of backTo button in optionScreen
            Resource.backToMenu = true;
        });
        btnOptionsInGame.setOnAction(event -> {
            Parent root = Utilities.loadFxml(Resource.OPTION_SCREEN);

            Main.primaryStage.getScene().setRoot(root);
            root.requestFocus();
        });
        btnChangeRoom.setOnAction(this::changeRoom);
        btnInspect.setOnAction(this::inspect);
        btnUse.setOnAction(this::use);
        //btnPickUp.setOnAction(this::pickUp);
        btnPickUp.setOnAction(event -> {
            if (Resource.roomViewSelected) {
                Main.items.remove(roomView.getSelectionModel().getSelectedIndex());
                Main.inventoryList.add(roomView.getSelectionModel().getSelectedItem());
                displayItems();
                displayInventory();
            } else if (Resource.invViewSelected) {
                Main.inventoryList.remove(invView.getSelectionModel().getSelectedIndex());
                Main.items.add(invView.getSelectionModel().getSelectedItem());
                displayItems();
                displayInventory();
            } else {
                System.out.println("Select Item");
            }
        });


        roomView.setItems(roomItems);
        roomView.setOnMouseClicked(mouseEvent -> {
            Resource.roomViewSelected = true;
            Resource.invViewSelected = false;
            btnPickUp.setText("Pick Up");
        });


        invView.setItems(inventoryItems);
        invView.setOnMouseClicked(mouseEvent -> {
            Resource.roomViewSelected = false;
            Resource.invViewSelected = true;
            btnPickUp.setText("Drop");
        });

        //createItemBtn();
        displayItems();
        displayInventory();
    }

    /*
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

     */

    //TODO replace strings with inventory itemlist of room
    @FXML
    private void displayInventory() {
        inventoryItems.setAll(Main.inventoryList);

        /*
        inventory.getChildren().clear();
        //TODO replace with foreach of items in inventory
        for(int i = 0; i < Main.inventoryList.size(); i++) {
            Text text = new Text();
            //TODO replace with item name
            text.setText((i+1) + " " + Main.inventoryList.get(i));
            inventory.getChildren().add(text);
        }
        */
    }

    //TODO show selected Room name
    //TODO replace strings with itemlist of room
    //TODO implement displayItems in changeRoom
    @FXML
    private void displayItems() {
        roomItems.setAll(Main.items);


        //items.getSelectionModel().selectedItemProperty().addListener();
        /*
        showText.getChildren().clear();
        //TODO replace with foreach of items in room
        for(int i = 0; i < Main.items.size(); i++) {
            Text text = new Text();
            //TODO replace with item name
            text.setText((i+1) + " " + Main.items.get(i));
            showText.getChildren().add(text);
        }
        */
    }

    /*
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

     */

    //TODO implement getItemId and getDesc method from Items class
    @FXML
    private void inspect(ActionEvent event) {
        if (Resource.roomViewSelected) {
            System.out.println("Do stuff");
        } else if (Resource.invViewSelected) {
            System.out.println("Do stuff");
        } else {
            System.out.println("Select Item");
        }
        System.out.println("To bo implemented!");
    }

    //TODO implement yet to be written methods
    @FXML
    private void use(ActionEvent event) {
        if (Resource.roomViewSelected) {
            System.out.println("Do stuff");
        } else if (Resource.invViewSelected) {
            System.out.println("Do stuff");
        } else {
            System.out.println("Select Item");
        }
        System.out.println("To bo implemented!");
    }

    //TODO implement getItemId, isPable and yet to be written methods from Items class
    //TODO make it also work with inventory list
    @FXML
    private void pickUp(ActionEvent event) {
        //removes buttons if Item gets picked up
        //TODO replace Main.Items with ArrayList of selected room
        if (Resource.roomViewSelected) {
            Main.items.remove(roomView.getSelectionModel().getSelectedIndex());
            Main.inventoryList.add(roomView.getSelectionModel().getSelectedItem());
            displayItems();
            displayInventory();
        } else if (Resource.invViewSelected) {
            Main.inventoryList.remove(invView.getSelectionModel().getSelectedIndex());
            Main.items.add(invView.getSelectionModel().getSelectedItem());
            displayItems();
            displayInventory();
        } else {
            System.out.println("Select Item");
        }
        /*
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

         */
    }

    //TODO implement yet to be written methods
    @FXML
    private void changeRoom(ActionEvent event) {
        roomItems.setAll("Bathroom", "kitchen", "Livingroom");
        btnInspect.setVisible(false);
        btnInspect.setManaged(false);
        btnUse.setVisible(false);
        btnUse.setManaged(false);
        btnPickUp.setVisible(false);
        btnPickUp.setManaged(false);
        Button button = new Button();
        button.setText("Pick Room");
        button.setOnAction(event1 -> {

            //roomItems.setAll(roomView.getSelectionModel().getSelectedItem().getitemList());

            roomItems.setAll(Main.items);
            btnInspect.setVisible(true);
            btnInspect.setManaged(true);
            btnUse.setVisible(true);
            btnUse.setManaged(true);
            btnPickUp.setVisible(true);
            btnPickUp.setManaged(true);
            action.getChildren().remove(3);
        });
        action.getChildren().add(button);
    }
}
