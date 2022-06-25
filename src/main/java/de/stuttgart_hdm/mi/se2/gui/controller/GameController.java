package de.stuttgart_hdm.mi.se2.gui.controller;

import de.stuttgart_hdm.mi.se2.gui.Audio;
import de.stuttgart_hdm.mi.se2.gui.Utils;
import de.stuttgart_hdm.mi.se2.gui.model.GameModel;
import de.stuttgart_hdm.mi.se2.gui.Resource;
import de.stuttgart_hdm.mi.se2.gui.view.GameView;
import de.stuttgart_hdm.mi.se2.items.Item;
import de.stuttgart_hdm.mi.se2.rooms.Room;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;


//TODO add documentation
public class GameController {

    Logger log = LogManager.getLogger(GameController.class);
    
    private GameModel gameModel;
    private GameView gameView;


    @FXML
    private Label currentRoom, dialog;
    @FXML
    private Button btnBackToMenu, btnOptionsInGame, btnChangeRoom, btnInspect, btnUse, btnPickUp, btnPickRoom;
    @FXML
    private ListView roomView, invView;


    @FXML
    private void initialize() {
        gameModel = new GameModel();
        gameView = new GameView();

        btnBackToMenu.setOnAction(event -> {
            Parent root = Utils.loadFxml(Resource.MENU_SCREEN);

            GameView.getPrimaryStage().getScene().setRoot(root);
            root.requestFocus();

            //changes action of backTo button in optionScreen
            GameView.getGameView().setOptionBackBtn(true);
            Audio.playAudio();
        });

        btnOptionsInGame.setOnAction(event -> {
            Parent root = Utils.loadFxml(Resource.OPTION_SCREEN);

            GameView.getPrimaryStage().getScene().setRoot(root);
            root.requestFocus();
            Audio.playAudio();
        });

        btnChangeRoom.setOnAction(this::changeRoom);

        btnInspect.setOnAction(this::inspect);

        btnPickUp.setOnAction(this::pickUp);

        btnPickRoom.setOnAction(this::pickRoom);


        roomView.setItems(gameModel.getRoomsList().get(gameModel.getRoomIndex()).getItemsInRoom());
        roomView.setOnMouseClicked(mouseEvent -> {
            gameView.setRoomViewSelected(true);
            gameView.setInvViewSelected(false);
            btnPickUp.setText("Pick Up");
        });

        invView.setItems(gameModel.getInventory());
        invView.setOnMouseClicked(mouseEvent -> {
            gameView.setRoomViewSelected(false);
            gameView.setInvViewSelected(true);
            btnPickUp.setText("Drop");
        });

        currentRoom.setText("Current room: " + GameModel.getModel().getRoomsList().get(GameModel.getModel().getRoomIndex()));
        dialog.setText("Welcome to PAIN!\nYour mission is to escape the strange building you have been trapped in with the help of items found in the rooms.\nGood Luck!");
    }


    private void showDesc(Item selectedItem) {
        dialog.setText(gameModel.getItemDescription(selectedItem));
    }

    private void roomSelection() {
        btnInspect.setVisible(true);
        btnInspect.setManaged(true);
        btnUse.setVisible(true);
        btnUse.setManaged(true);
        btnPickUp.setVisible(true);
        btnPickUp.setManaged(true);
        btnPickRoom.setVisible(false);
        btnPickRoom.setManaged(false);
    }

    private void setBackground(Resource resource) {
        roomView.setBackground(new Background(new BackgroundImage(new Image(resource.getUrl()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
    }

    private void changeRoom(ActionEvent event) {
        if(btnPickRoom.isVisible()) {
            dialog.setText("Please select a room and use \"Pick Room\" button!");
        } else {
            roomView.setItems(gameModel.getRoomsList());
            btnInspect.setVisible(false);
            btnInspect.setManaged(false);
            btnUse.setVisible(false);
            btnUse.setManaged(false);
            btnPickUp.setVisible(false);
            btnPickUp.setManaged(false);
            btnPickRoom.setVisible(true);
            btnPickRoom.setManaged(true);
        }
        currentRoom.setText("Previous room: " + GameModel.getModel().getRoomsList().get(GameModel.getModel().getRoomIndex()).getName());

        Audio.playAudio();
    }

    private void inspect(ActionEvent event) {
        if (gameView.isRoomViewSelected() && roomView.getSelectionModel().getSelectedItem() instanceof Item selectedItem) {
            showDesc(selectedItem);
        } else if (gameView.isInvViewSelected() && invView.getSelectionModel().getSelectedItem() instanceof Item selectedItem) {
            showDesc(selectedItem);
        } else {
            dialog.setText("Select Item");
        }
        Audio.playAudio();
    }

    private void pickUp(ActionEvent event) {
        if (gameView.isRoomViewSelected() && roomView.getSelectionModel().getSelectedItem() instanceof Item selectedItem) {

            if (selectedItem.isPickable()) {
                gameModel.pickUp(gameModel, selectedItem, true);
                log.info(String.format("Moved item: %s from room: %s to inventory", gameModel.getItemName(selectedItem), gameModel.getRoomName(gameModel.getRoomsList().get(gameModel.getRoomIndex()))));
            } else {
                dialog.setText("You cant pick that up.");
            }

        } else if (gameView.isInvViewSelected() && invView.getSelectionModel().getSelectedItem() instanceof Item selectedItem) {
            gameModel.pickUp(gameModel, selectedItem, false);
            log.info(String.format("Moved item: %s from inventory to: %s", gameModel.getItemName(selectedItem), gameModel.getRoomName(gameModel.getRoomsList().get(gameModel.getRoomIndex()))));
        } else {
            dialog.setText("Select Item");
        }
        Audio.playAudio();

        gameView.setInvViewSelected(false);
        gameView.setRoomViewSelected(false);
    }

    private void pickRoom(ActionEvent event) {
        if(gameView.isRoomViewSelected() && roomView.getSelectionModel().getSelectedItem() instanceof Room selectedRoom) {

            if (selectedRoom.getAccess()) {
                gameModel.setRoomIndex(roomView.getSelectionModel().getSelectedIndex());
                roomView.setItems(gameModel.getItemsInSelectedRoom(selectedRoom));

                roomSelection();
            } else if (gameModel.getInventory().stream().map(item-> gameModel.getItemId(item)).anyMatch(item -> gameModel.getNededItem(selectedRoom).contains(item))) {
                gameModel.setRoomIndex(roomView.getSelectionModel().getSelectedIndex());
                gameModel.setRoomAccess(selectedRoom);
                log.info(String.format("Changed access rights of %s to true.", gameModel.getRoomName(selectedRoom)));
                roomView.setItems(selectedRoom.getItemsInRoom());

                roomSelection();
            } else {
                dialog.setText("The room is locked!\nMaybe i can find something to open it...");
            }
        } else {
            dialog.setText("Please select a room!");
        }

        Audio.playAudio();
        currentRoom.setText("Current room: " + GameModel.getModel().getRoomsList().get(GameModel.getModel().getRoomIndex()));
        gameView.setInvViewSelected(false);
        gameView.setRoomViewSelected(false);
    }
}
