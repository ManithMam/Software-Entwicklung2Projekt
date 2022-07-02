package de.stuttgart_hdm.mi.se2.gui.controller;

import de.stuttgart_hdm.mi.se2.gui.Audio;
import de.stuttgart_hdm.mi.se2.gui.Text;
import de.stuttgart_hdm.mi.se2.gui.Utils;
import de.stuttgart_hdm.mi.se2.gui.model.GameModel;
import de.stuttgart_hdm.mi.se2.gui.Resource;
import de.stuttgart_hdm.mi.se2.gui.view.GameView;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * Controller of Game Screen
 */
public class GameController {

    Logger log = LogManager.getLogger(GameController.class);

    private GameModel gameModel;
    private GameView gameView;


    @FXML
    private VBox background;
    @FXML
    private Label currentRoomLabel, currentRoom, inventoryLabel, dialog;
    @FXML
    private Button btnBackToMenu, btnOptionsInGame, btnChangeRoom, btnInspect, btnPickUp, btnPickRoom, btnOk;
    @FXML
    private ListView roomView, invView;


    /**
     * invoked when gemaScreen.fxml loaded
     * used to set start parameters
     */
    @FXML
    private void initialize() {

        gameModel = GameModel.getGameModel();
        gameView = GameView.getGameView();

        btnBackToMenu.setOnAction(event -> {

            Audio.playAudio(Resource.BTN_AUDIO);
            log.info(Text.BACK_TO_MENU_BUTTON_PRESSED.getMessage());
            Parent root = Utils.loadFxml(Resource.MENU_SCREEN);
            GameView.getPrimaryStage().getScene().setRoot(root);
            root.requestFocus();
            //changes action of backTo button in optionScreen
            gameView.setOptionBackBtn(true);
            gameModel.stopThread();
            GameModel.restartGame();
        });

        btnOptionsInGame.setOnAction(event -> {
            Audio.playAudio(Resource.BTN_AUDIO);
            log.info(Text.OPTION_BUTTON_PRESSED.getMessage());
            Parent root = Utils.loadFxml(Resource.OPTION_SCREEN);
            GameView.getPrimaryStage().getScene().setRoot(root);
            root.requestFocus();
        });

        btnChangeRoom.setOnAction(this::changeRoom);

        btnInspect.setOnAction(this::inspect);

        btnPickUp.setOnAction(this::pickUp);

        btnOk.setOnAction(event -> {

            log.info("OK button pressed!");
            Audio.playAudio(Resource.BTN_AUDIO);
            roomUnlocked();
            gameModel.startThread();
        });


        cellFactory(roomView);

        roomViewHeight(gameModel.getItemsInSelectedRoom(gameModel.getCurrentRoom()));

        try {

            roomView.setItems(gameModel.getItemsInSelectedRoom(gameModel.getCurrentRoom()));

        } catch (IllegalArgumentException e) {

            log.error(e);
            Parent root = Utils.loadFxml(Resource.ERROR_SCREEN);
            GameView.getPrimaryStage().getScene().setRoot(root);
            root.requestFocus();
        }

        roomViewItemEvent();


        cellFactory(invView);

        invView.setItems(gameModel.getInventory());

        invView.setOnMouseClicked(mouseEvent -> {

            gameView.setRoomViewSelected(false);
            gameView.setInvViewSelected(true);
            btnPickUp.setText("Drop");
            dialog.setText(Text.UNSELECT_ITEM_INFO.getMessage());
        });


        roomSelection();
        inventoryLabel.setText(String.format(Text.INVENTORY.getMessage(), gameModel.getInventory().size()));
        currentRoom.setText(gameModel.getRoomName(gameModel.getCurrentRoom()));
        dialog.setText(gameModel.getRoomDescription(gameModel.getCurrentRoom()));
    }


    /**
     * sets selection model of roomView if items of room are shown
     */
    private void roomViewItemEvent() {

        roomView.setOnMouseClicked(mouseEvent -> {

            gameView.setRoomViewSelected(true);
            gameView.setInvViewSelected(false);
            btnPickUp.setText("Pick Up");
            dialog.setText(Text.UNSELECT_ITEM_INFO.getMessage());
        });
    }

    /**
     * sets selection model of roomView if rooms are shown
     */
    private void roomViewRoomEvent() {

        roomView.setOnMouseClicked(click -> {

            dialog.setText(Text.UNSELECT_ITEM_INFO.getMessage());

            //double-click selection
            if (click.getClickCount() == 2) {

                gameView.setRoomViewSelected(true);
                gameView.setInvViewSelected(false);

                roomView.setDisable(true);
                btnOptionsInGame.setDisable(true);

                pickRoom();
            }
        });
    }

    /**
     * sets the roomView height to height of it's content
     * @param list list of items/rooms
     */
    private void roomViewHeight(ObservableList list) {

        roomView.setPrefHeight((list.size() * 30D) + 6);
    }

    /**
     * sets style of ListView cells
     * @param list ListView to be styled
     */
    private void cellFactory(ListView<Object> list) {

        list.setCellFactory(listView -> {

            ListCell<Object> cell = new ListCell<>() {

                @Override
                protected void updateItem(Object item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty || item == null) {
                        setText("");
                    } else {
                        setText(item.toString());
                    }
                }
            };

            cell.setOnMouseClicked(e -> {

                if (!cell.isEmpty()) {
                    Audio.playAudio(Resource.BTN_AUDIO);
                }
            });

            if (list == roomView && GameView.isFullScreen()) {

                cell.setStyle("-fx-alignment: center;");
            }

            return cell;
        });
    }


    /**
     * displays description of given item/room in dialog
     * @param object item/room you want to show description of
     */
    private void showDesc(Object object) {

        try {

            dialog.setText(gameModel.getItemDescription(object));

        } catch (IllegalArgumentException e) {

            log.error(e);
            dialog.setText(Text.ERROR.getMessage());
        }
    }


    /**
     * loads items of current room in roomView
     */
    private void showItemsInSelectedRoom() {

        try {

            roomView.setItems(gameModel.getItemsInSelectedRoom(gameModel.getCurrentRoom()));

        } catch (IllegalArgumentException e) {

            log.error(e);
            Parent root = Utils.loadFxml(Resource.ERROR_SCREEN);
            GameView.getPrimaryStage().getScene().setRoot(root);
            root.requestFocus();
        }
    }


    /**
     * used to get selected item/room
     * @return selected item/room
     */
    private Object getSelected() {

        if (gameView.isRoomViewSelected()) {

            return roomView.getSelectionModel().getSelectedItem();

        } else if (gameView.isInvViewSelected()) {

            return invView.getSelectionModel().getSelectedItem();

        } else {

            throw new IllegalArgumentException("roomView or invView where not selected");
        }
    }


    /**
     * action of inspect button
     * @param event event in gui (e.g button press)
     */
    private void inspect(ActionEvent event) {
        Audio.playAudio(Resource.BTN_AUDIO);

        log.info(Text.INSPECT_BUTTON_PRESSED.getMessage());

        if (gameView.isRoomViewSelected()) {

            showDesc(getSelected());

        } else if (gameView.isInvViewSelected()) {

            showDesc(getSelected());

        } else {

            dialog.setText(Text.SELECT_ITEM.getMessage());
        }
    }


    /**
     * action of pick-up button
     * @param event event in gui (e.g button press)
     */
    private void pickUp(ActionEvent event) {

        Audio.playAudio(Resource.BTN_AUDIO);
        log.info(Text.PICK_UP_BUTTON_PRESSED.getMessage());

        try {

            if (gameView.isRoomViewSelected()) {

                pickFromRoom();

                //otherwise, next item in roomView would be selected
                roomView.getSelectionModel().select(null);

            } else if (gameView.isInvViewSelected()) {

                gameModel.pickUp(getSelected(), false);
                inventoryLabel.setText(String.format(Text.INVENTORY.getMessage(), gameModel.getInventory().size()));
                dialog.setText(Text.CLEAR_TEXT.getMessage());
                roomViewHeight(gameModel.getItemsInSelectedRoom(gameModel.getCurrentRoom()));

                //otherwise, next item in invView would be selected
                invView.getSelectionModel().select(null);

            } else {

                dialog.setText(Text.SELECT_ITEM.getMessage());

                //just to be sure
                roomView.getSelectionModel().select(null);
                invView.getSelectionModel().select(null);
            }

        } catch (IllegalArgumentException e) {

            log.error(e);
            dialog.setText(Text.SELECT_ITEM.getMessage());
        }

        //reset to prevent errors
        gameView.setInvViewSelected(false);
        gameView.setRoomViewSelected(false);
    }


    /**
     * picks up item from room if item is movable and inventory has space left
     */
    private void pickFromRoom() {

        if (gameModel.isItemMovable(getSelected()) && gameModel.getInventory().size() < 3) {

            gameModel.pickUp(getSelected(), true);
            inventoryLabel.setText(String.format(Text.INVENTORY.getMessage(), gameModel.getInventory().size()));
            dialog.setText(Text.CLEAR_TEXT.getMessage());

        } else {

            dialog.setText(Text.PICKUP_DENIED.getMessage());

            //otherwise, item in roomView would still be selected
            roomView.getSelectionModel().select(null);
        }
    }


    /**
     * action of change room button
     * displays rooms and changes selection model of roomView
     * @param event event in gui (e.g button press)
     */
    private void changeRoom(ActionEvent event) {

        Audio.playAudio(Resource.BTN_AUDIO);
        log.info(Text.CHANGE_ROOM_BUTTON_PRESSED.getMessage());

        btnChangeRoom.setDisable(true);

        if (!btnInspect.isVisible()) {

            dialog.setText(Text.PROMPT_TO_PICK_ROOM_BUTTON.getMessage());

            //otherwise, room in roomView would still be selected
            roomView.getSelectionModel().select(null);

        } else {

            dialog.setText(Text.SELECT_ROOM_INFO.getMessage());
            roomViewHeight(gameModel.getRoomsList());
            roomViewRoomEvent();
            roomView.setItems(gameModel.getRoomsList());
            invView.setDisable(true);
            btnInspect.setVisible(false);
            btnInspect.setManaged(false);
            btnPickUp.setVisible(false);
            btnPickUp.setManaged(false);
        }

        currentRoomLabel.setText(Text.PREVIOUS_ROOM.getMessage());

        try {

            currentRoom.setText(gameModel.getRoomName(gameModel.getCurrentRoom()));

        } catch (IllegalArgumentException e) {

            log.error(e);
            currentRoom.setText(Text.CURRENT_ROOM.getMessage());
        }
    }


    /**
     * action after double-click in change room screen
     */
    private void pickRoom() {

        Audio.playAudio(Resource.BTN_AUDIO);
        log.info(Text.PICK_ROOM_PRESSED.getMessage());

        if (gameView.isRoomViewSelected()) {

            try {

                goToRoom(getSelected());

            } catch (IllegalArgumentException e) {

                log.error(e);
                dialog.setText(Text.PROMPT_TO_PICK_ROOM.getMessage());
            }

        } else {

            dialog.setText(Text.PROMPT_TO_PICK_ROOM.getMessage());
        }

        gameView.setInvViewSelected(false);
        gameView.setRoomViewSelected(false);
    }


    /**
     * checks if room is accessible
     * shows items of room if accessible
     * @param object selected room
     */
    private void goToRoom(Object object) {

        if (gameModel.getRoomAccess(object)) {

            btnOptionsInGame.setDisable(false);
            btnChangeRoom.setDisable(false);
            invView.setDisable(false);
            roomView.setDisable(false);
            gameModel.setCurrentRoom(object);
            roomViewItemEvent();
            roomOpen();

        } else if (gameModel.getInventory().stream().map(item -> gameModel.getItemId(item)).toList().containsAll(gameModel.getNeededItem(object)) || gameModel.isCheatMode()) {

            gameModel.setCurrentRoom(object);
            gameModel.setRoomAccess(gameModel.getCurrentRoom());

            if(!gameModel.isCheatMode()) {

                gameModel.stopThread();
                dialog.setText(String.format(Text.ROOM_LOCKED_DIFFERENT_FORMAT.getMessage(), gameModel.getRoomDoorDescription(gameModel.getCurrentRoom()), Text.USED_ITEM_INFO.getMessage(), gameModel.getUsedItemNames(gameModel.getInventory().stream().filter(item -> gameModel.getNeededItem(gameModel.getCurrentRoom()).contains(item.getId())).map(item -> gameModel.getItemName(item)).toList())));
                btnOk.setVisible(true);
                btnOk.setManaged(true);

            } else {

                roomUnlocked();
            }

        } else {

            roomLocked();

            //otherwise, room in roomView would still be selected
            roomView.getSelectionModel().select(null);
        }
    }


    /**
     * makes buttons visible and manageable
     */
    private void roomSelection() {

        if (gameModel.getBasement(true) || !gameModel.getBasement(false) || gameModel.isCheatMode()) {
            background.setStyle(gameModel.getBackground(gameModel.getCurrentRoom()));
            showItemsInSelectedRoom();
        } else {
            background.setStyle(null);
            roomView.setItems(null);
        }

        btnInspect.setVisible(true);
        btnInspect.setManaged(true);
        btnPickUp.setVisible(true);
        btnPickUp.setManaged(true);
    }


    /**
     * handles actions if room is already opened
     */
    private void roomOpen() {

        roomSelection();
        currentRoomLabel.setText(Text.CURRENT_ROOM.getMessage());
        currentRoom.setText(gameModel.getRoomName(gameModel.getCurrentRoom()));
        dialog.setText(gameModel.getRoomDescription(gameModel.getCurrentRoom()));
        roomViewHeight(gameModel.getItemsInSelectedRoom(gameModel.getCurrentRoom()));
    }


    /**
     * handles actions if room gets unlocked and checks if player enters Exit
     */
    private void roomUnlocked() {

        if (!gameModel.getExit()) {

            try {

                log.info(String.format(Text.ACCESS_RIGHT_CHANGE_TO_TRUE.getMessage(), gameModel.getRoomName(gameModel.getCurrentRoom())));

            } catch (IllegalArgumentException e) {

                log.error(e);
            }

            btnOptionsInGame.setDisable(false);
            btnChangeRoom.setDisable(false);
            invView.setDisable(false);
            roomView.setDisable(false);

            btnOk.setVisible(false);
            btnOk.setManaged(false);

            roomSelection();
            currentRoomLabel.setText(Text.CURRENT_ROOM.getMessage());
            currentRoom.setText(gameModel.getRoomName(gameModel.getCurrentRoom()));
            dialog.setText(gameModel.getRoomDescription(gameModel.getCurrentRoom()));
            roomViewHeight(gameModel.getItemsInSelectedRoom(gameModel.getCurrentRoom()));
            roomViewItemEvent();

        } else {

            gameModel.stopThread();
            Parent root = Utils.loadFxml(Resource.WINNING_SCREEN);
            GameView.getPrimaryStage().getScene().setRoot(root);
            root.requestFocus();
        }
    }


    /**
     * handles actions if room is locked
     */
    private void roomLocked() {
        try {

            dialog.setText(String.format(Text.ROOM_LOCKED.getMessage(), gameModel.getRoomDoorDescription(getSelected())));

        } catch (IllegalArgumentException e) {

            log.error(e);
            dialog.setText(String.format(Text.ROOM_LOCKED.getMessage(), Text.ERROR.getMessage()));
        }
    }
}
