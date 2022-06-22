package de.stuttgart_hdm.mi.se2.gui;

import de.stuttgart_hdm.mi.se2.Main;
import de.stuttgart_hdm.mi.se2.items.Item;
import de.stuttgart_hdm.mi.se2.rooms.Room;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


//TODO add documentation
//TODO stile fxml elements with css not with attribute
//TODO add inventory button
//TODO LIST VIEW
public class GameController {


    @FXML
    private Label currentRoom, dialog;
    @FXML
    private HBox action;
    @FXML
    private VBox showText, inventory;
    @FXML
    private Button btnBackToMenu, btnOptionsInGame, btnChangeRoom, btnInspect, btnUse, btnPickUp, btnPickRoom;
    @FXML
    private ListView roomView, invView;


    @FXML
    private void initialize() {
        //Buttons of actions
        btnBackToMenu.setOnAction(event -> {
            Parent root = View.loadFxml(Resource.MENU_SCREEN);

            View.getPrimaryStage().getScene().setRoot(root);
            root.requestFocus();

            //changes action of backTo button in optionScreen
            View.getGameView().setOptionBackBtn(true);
            Audio.playAudio();
        });
        btnOptionsInGame.setOnAction(event -> {
            Parent root = View.loadFxml(Resource.OPTION_SCREEN);

            View.getPrimaryStage().getScene().setRoot(root);
            root.requestFocus();
            Audio.playAudio();
        });
        btnChangeRoom.setOnAction(this::changeRoom);
        btnInspect.setOnAction(event -> {
            if (View.getGameView().isRoomViewSelected()) {
                System.out.println("Do stuff");
            } else if (View.getGameView().isInvViewSelected()) {
                System.out.println("Do stuff");
            } else {
                System.out.println("Select Item");
            }
            System.out.println("To bo implemented!");
            Audio.playAudio();
        });
        btnUse.setOnAction(event -> {
            if (View.getGameView().isRoomViewSelected()) {
                System.out.println("Do stuff");
            } else if (View.getGameView().isInvViewSelected()) {
                System.out.println("Do stuff");
            } else {
                System.out.println("Select Item");
            }
            System.out.println("To bo implemented!");
            Audio.playAudio();
        });
        //btnPickUp.setOnAction(this::pickUp);
        btnPickUp.setOnAction(event -> {

            if (View.getGameView().isRoomViewSelected() && roomView.getSelectionModel().getSelectedItem() != null) {
                Model.getModel().getRoomsList().get(Model.getModel().getRoomIndex()).getItemsInRoom().remove(roomView.getSelectionModel().getSelectedItem());
                Model.getModel().getInventory().add((Item) roomView.getSelectionModel().getSelectedItem());

                System.out.println("Roomview was selected");
                System.out.println("Moved item: " + ((Item) roomView.getSelectionModel().getSelectedItem()).getName() +
                        " from room: " + Model.getModel().getRoomsList().get(Model.getModel().getRoomIndex()).getName() + " to inventory"
                );
                //log.info("Moved item: " + ((Item) roomView.getSelectionModel().getSelectedItem()).getName() +
                //                        " from room: " + Model.getModel().getRoomsList().get(Model.getModel().getRoomIndex()).getName() + " to inventory"
                //);

            } else if (View.getGameView().isInvViewSelected() && invView.getSelectionModel().getSelectedItem() != null) {
                Model.getModel().getInventory().remove(invView.getSelectionModel().getSelectedItem());
                Model.getModel().getRoomsList().get(Model.getModel().getRoomIndex()).getItemsInRoom().add((Item) invView.getSelectionModel().getSelectedItem());

                System.out.println("invview was selected");
                System.out.println("Moved item: " + ((Item) invView.getSelectionModel().getSelectedItem()).getName() +
                        " from inventory to: " + Model.getModel().getRoomsList().get(Model.getModel().getRoomIndex()).getName()
                );

            } else {
                dialog.setText("Select Item");
            }
            Audio.playAudio();
            displayItems();
            displayInventory();
            View.getGameView().setInvViewSelected(false);
            View.getGameView().setRoomViewSelected(false);
        });

        btnPickRoom.setOnAction(event -> {
            if(View.getGameView().isRoomViewSelected() && roomView.getSelectionModel().getSelectedItem() instanceof Room selectedRoom) {
                //System.out.println("needed Item:" + selectedRoom.neededItem());
                //System.out.println("Itemid in inventory" + Model.getModel().getInventory().stream().map(item -> item.getId()).collect(Collectors.toList()));
                //System.out.println("Current roomid" + Model.getModel().getRoomIndex());
                //System.out.println("access rights of current room" + Model.getModel().getRoomsList().get(Model.getModel().getRoomIndex()).getAccess());
                //System.out.println("access rights of selected room" + selectedRoom.getAccess());
                if (selectedRoom.getAccess()) {
                    Model.getModel().setRoomIndex(roomView.getSelectionModel().getSelectedIndex());
                    View.getGameView().getRoomItems().setAll(Model.getModel().getRoomsList().get(Model.getModel().getRoomIndex()).getItemsInRoom());

                    btnInspect.setVisible(true);
                    btnInspect.setManaged(true);
                    btnUse.setVisible(true);
                    btnUse.setManaged(true);
                    btnPickUp.setVisible(true);
                    btnPickUp.setManaged(true);
                    btnPickRoom.setVisible(false);
                    btnPickRoom.setManaged(false);
                } else if (Model.getModel().getInventory().stream().map(Item::getId).toList().contains((selectedRoom.neededItem()))) {
                    Model.getModel().setRoomIndex(roomView.getSelectionModel().getSelectedIndex());
                    //System.out.println("Test");
                    //System.out.println("access rights of current room before" + Model.getModel().getRoomsList().get(Model.getModel().getRoomIndex()).getAccess());
                    Model.getModel().getRoomsList().get(Model.getModel().getRoomIndex()).setAccess(true);
                    //System.out.println("access rights of current room after" + Model.getModel().getRoomsList().get(Model.getModel().getRoomIndex()).getAccess());


                    View.getGameView().getRoomItems().setAll(Model.getModel().getRoomsList().get(Model.getModel().getRoomIndex()).getItemsInRoom());

                    btnInspect.setVisible(true);
                    btnInspect.setManaged(true);
                    btnUse.setVisible(true);
                    btnUse.setManaged(true);
                    btnPickUp.setVisible(true);
                    btnPickUp.setManaged(true);
                    btnPickRoom.setVisible(false);
                    btnPickRoom.setManaged(false);
                } else {
                    dialog.setText("The room is locked!\nMaybe i can find something to open it...");
                }
            } else {
                dialog.setText("Please select a room!");
            }

            Audio.playAudio();
            View.getGameView().setInvViewSelected(false);
            View.getGameView().setRoomViewSelected(false);
        });



        roomView.setItems(View.getGameView().getRoomItems());
        roomView.setOnMouseClicked(mouseEvent -> {
            View.getGameView().setRoomViewSelected(true);
            View.getGameView().setInvViewSelected(false);
            btnPickUp.setText("Pick Up");
        });


        invView.setItems(View.getGameView().getInventoryItems());
        invView.setOnMouseClicked(mouseEvent -> {
            View.getGameView().setRoomViewSelected(false);
            View.getGameView().setInvViewSelected(true);
            btnPickUp.setText("Drop");
        });

        currentRoom.setText("Current room: " + Model.getModel().getRoomsList().get(Model.getModel().getRoomIndex()));
        dialog.setText("Welcome to PAIN!\nYour mission is to escape the strange building you have been trapped in with the help of items found in the rooms.\nGood Luck!");
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
            for (int i = 1; i <= Main.de.stuttgart_hdm.mi.se2.classes.items.size(); i++) {
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
        View.getGameView().getInventoryItems().setAll(Model.getModel().getInventory());

        /*
        inventory.getChildren().clear();
        //TODO replace with foreach of de.stuttgart_hdm.mi.se2.classes.items in inventory
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
        View.getGameView().getRoomItems().setAll(Model.getModel().getRoomsList().get(Model.getModel().getRoomIndex()).getItemsInRoom());


        //de.stuttgart_hdm.mi.se2.classes.items.getSelectionModel().selectedItemProperty().addListener();
        /*
        showText.getChildren().clear();
        //TODO replace with foreach of de.stuttgart_hdm.mi.se2.classes.items in room
        for(int i = 0; i < Main.de.stuttgart_hdm.mi.se2.classes.items.size(); i++) {
            Text text = new Text();
            //TODO replace with item name
            text.setText((i+1) + " " + Main.de.stuttgart_hdm.mi.se2.classes.items.get(i));
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
        if (View.getGameView().isRoomViewSelected()) {
            System.out.println("Do stuff");
        } else if (View.getGameView().isInvViewSelected()) {
            System.out.println("Do stuff");
        } else {
            System.out.println("Select Item");
        }
        System.out.println("To bo implemented!");

        Audio.playAudio();
    }

    //TODO implement yet to be written methods
    @FXML
    private void use(ActionEvent event) {
        if (View.getGameView().isRoomViewSelected()) {
            System.out.println("Do stuff");
        } else if (View.getGameView().isInvViewSelected()) {
            System.out.println("Do stuff");
        } else {
            System.out.println("Select Item");
        }
        System.out.println("To bo implemented!");
        Audio.playAudio();
    }

    //TODO implement getItemId, isPable and yet to be written methods from Items class
    //TODO make it also work with inventory list
    @FXML
    private void pickUp(ActionEvent event) {
        //removes buttons if Item gets picked up
        //TODO replace Main.Items with ArrayList of selected room
        if (View.getGameView().isRoomViewSelected()) {
            Main.items.remove(roomView.getSelectionModel().getSelectedIndex());
            Main.inventoryList.add(roomView.getSelectionModel().getSelectedItem());
            displayItems();
            displayInventory();
        } else if (View.getGameView().isInvViewSelected()) {
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
            selectItemBtns.getChildren().removeIf(button -> Integer.parseInt(((Button) button).getText()) == Main.de.stuttgart_hdm.mi.se2.classes.items.size());
            //replace with remove method from Room
            Main.de.stuttgart_hdm.mi.se2.classes.items.remove(Resource.itemIndex);
            System.out.println(Main.de.stuttgart_hdm.mi.se2.classes.items);
        }
        backToItemsBtn(event);
        displayInventory();
        displayItems();

         */
        Audio.playAudio();
    }

    //TODO implement yet to be written methods
    @FXML
    private void changeRoom(ActionEvent event) {
        if(btnPickRoom.isVisible()) {
            dialog.setText("Please select a room and use \"Pick Room\" button!");
        } else {
            View.getGameView().getRoomItems().setAll(Model.getModel().getRoomsList());
            btnInspect.setVisible(false);
            btnInspect.setManaged(false);
            btnUse.setVisible(false);
            btnUse.setManaged(false);
            btnPickUp.setVisible(false);
            btnPickUp.setManaged(false);
            btnPickRoom.setVisible(true);
            btnPickRoom.setManaged(true);
        }



        Audio.playAudio();
    }
}
