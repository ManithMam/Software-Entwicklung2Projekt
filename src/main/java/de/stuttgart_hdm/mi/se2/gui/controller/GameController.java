package de.stuttgart_hdm.mi.se2.gui.controller;

import de.stuttgart_hdm.mi.se2.gui.Audio;
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
            log.info(getText(16));
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
            log.info(getText(15));
            Parent root = Utils.loadFxml(Resource.OPTION_SCREEN);
            GameView.getPrimaryStage().getScene().setRoot(root);
            root.requestFocus();
        });

        btnChangeRoom.setOnAction(this::changeRoom);

        btnInspect.setOnAction(this::inspect);

        btnPickUp.setOnAction(this::pickUp);

        btnOk.setOnAction(event -> {
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
            dialog.setText(getText(18));
        });

        inventoryLabel.setText(String.format(getText(7), gameModel.getInventory().size()));
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
            dialog.setText(getText(18));
        });
    }

    /**
     * sets selection model of roomView if rooms are shown
     */
    private void roomViewRoomEvent() {

        roomView.setOnMouseClicked(click -> {

            dialog.setText(getText(18));

            //double-click selection
            if (click.getClickCount() == 2) {

                gameView.setRoomViewSelected(true);
                gameView.setInvViewSelected(false);

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


    private String getText(int number) {
        switch (number) {
            case 0 -> {
                return "Please select a room with double click!";
            }
            case 1 -> {
                return "Please select a room!";
            }
            case 2 -> {
                return "You cant pick that up.";
            }
            case 3 -> {
                return "The room is locked!%n%s%n";
            }
            case 4 -> {
                return "Select Item!";
            }
            case 5 -> {
                return "No case: %d available";
            }
            case 6 -> {
                return "ERROR";
            }
            case 7 -> {
                return "Inventory (%d/3)";
            }
            case 8 -> {
                return "Current room: ";
            }
            case 9 -> {
                return "Changed access rights of %s to true.";
            }
            case 10 -> {
                return "Pick Room button was pressed";
            }
            case 11 -> {
                return "Previous room: ";
            }
            case 12 -> {
                return "";
            }
            case 13 -> {
                return "Change Room button was pressed";
            }
            case 14 -> {
                return "Inspect button was pressed";
            }
            case 15 -> {
                return "Option button was pressed in game";
            }
            case 16 -> {
                return "Back to Menu button was pressed in game";
            }
            case 17 -> {
                return "Pick up button was pressed";
            }
            case 18 -> {
                return "Use Ctr-Click to unselect Item!";
            }
            case 19 -> {
                return "Opened door with: ";
            }
            case 20 -> {
                return "The room is locked!%n%s%n%s%s";
            }
            case 21 -> {
                return "Double click to select room!";
            }
            default -> throw new IllegalArgumentException(String.format(getText(5), number));
        }
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
            dialog.setText(getText(6));
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

        log.info(getText(14));

        if (gameView.isRoomViewSelected()) {

            showDesc(getSelected());

        } else if (gameView.isInvViewSelected()) {

            showDesc(getSelected());

        } else {

            dialog.setText(getText(4));
        }
    }


    /**
     * action of pick-up button
     * @param event event in gui (e.g button press)
     */
    private void pickUp(ActionEvent event) {

        Audio.playAudio(Resource.BTN_AUDIO);
        log.info(getText(17));

        try {

            if (gameView.isRoomViewSelected()) {

                pickFromRoom();

                //otherwise, next item in roomView would be selected
                roomView.getSelectionModel().select(null);

            } else if (gameView.isInvViewSelected()) {

                gameModel.pickUp(getSelected(), false);
                inventoryLabel.setText(String.format(getText(7), gameModel.getInventory().size()));
                dialog.setText(getText(12));
                roomViewHeight(gameModel.getItemsInSelectedRoom(gameModel.getCurrentRoom()));

                //otherwise, next item in invView would be selected
                invView.getSelectionModel().select(null);

            } else {

                dialog.setText(getText(4));

                //just to be sure
                roomView.getSelectionModel().select(null);
                invView.getSelectionModel().select(null);
            }

        } catch (IllegalArgumentException e) {

            log.error(e);
            dialog.setText(getText(4));
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
            inventoryLabel.setText(String.format(getText(7), gameModel.getInventory().size()));
            dialog.setText(getText(12));

        } else {

            dialog.setText(getText(2));

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
        log.info(getText(13));

        if (!btnInspect.isVisible()) {

            dialog.setText(getText(0));

            //otherwise, room in roomView would still be selected
            roomView.getSelectionModel().select(null);

        } else {

            dialog.setText(getText(21));
            roomViewHeight(gameModel.getRoomsList());
            roomViewRoomEvent();
            roomView.setItems(gameModel.getRoomsList());
            btnInspect.setVisible(false);
            btnInspect.setManaged(false);
            btnPickUp.setVisible(false);
            btnPickUp.setManaged(false);
        }

        currentRoomLabel.setText(getText(11));

        try {

            currentRoom.setText(gameModel.getRoomName(gameModel.getCurrentRoom()));

        } catch (IllegalArgumentException e) {

            log.error(e);
            currentRoom.setText(getText(8));
        }
    }


    /**
     * action after double-click in change room screen
     */
    private void pickRoom() {

        Audio.playAudio(Resource.BTN_AUDIO);
        log.info(getText(10));

        if (gameView.isRoomViewSelected()) {

            try {

                goToRoom(getSelected());

            } catch (IllegalArgumentException e) {

                log.error(e);
                dialog.setText(getText(1));
            }

        } else {

            dialog.setText(getText(1));
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

            gameModel.setCurrentRoom(object);
            background.setStyle(gameModel.getBackground(gameModel.getCurrentRoom()));
            roomViewItemEvent();
            roomOpen();

        } else if (gameModel.getInventory().stream().map(item -> gameModel.getItemId(item)).toList().containsAll(gameModel.getNeededItem(object)) || gameModel.isCheatMode()) {

            gameModel.setCurrentRoom(object);
            gameModel.setRoomAccess(gameModel.getCurrentRoom());

            if(!gameModel.isCheatMode()) {

                gameModel.stopThread();
                dialog.setText(String.format(getText(20), gameModel.getRoomDoorDescription(gameModel.getCurrentRoom()), getText(19), gameModel.getUsedItemNames(gameModel.getInventory().stream().filter(item -> gameModel.getNeededItem(gameModel.getCurrentRoom()).contains(item.getId())).map(item -> gameModel.getItemName(item)).toList())));
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
        currentRoomLabel.setText(getText(8));
        currentRoom.setText(gameModel.getRoomName(gameModel.getCurrentRoom()));
        dialog.setText(gameModel.getRoomDescription(gameModel.getCurrentRoom()));
        roomViewHeight(gameModel.getItemsInSelectedRoom(gameModel.getCurrentRoom()));
        showItemsInSelectedRoom();
    }


    /**
     * handles actions if room gets unlocked and checks if player enters Exit
     */
    private void roomUnlocked() {

        if (!gameModel.getExit(gameModel.getCurrentRoom())) {

            try {

                log.info(String.format(getText(9), gameModel.getRoomName(gameModel.getCurrentRoom())));

            } catch (IllegalArgumentException e) {

                log.error(e);
            }

            btnOk.setVisible(false);
            btnOk.setManaged(false);

            background.setStyle(gameModel.getBackground(gameModel.getCurrentRoom()));
            roomSelection();
            currentRoomLabel.setText(getText(8));
            currentRoom.setText(gameModel.getRoomName(gameModel.getCurrentRoom()));
            dialog.setText(gameModel.getRoomDescription(gameModel.getCurrentRoom()));
            roomViewHeight(gameModel.getItemsInSelectedRoom(gameModel.getCurrentRoom()));
            roomViewItemEvent();
            showItemsInSelectedRoom();

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

            dialog.setText(String.format(getText(3), gameModel.getRoomDoorDescription(getSelected())));

        } catch (IllegalArgumentException e) {

            log.error(e);
            dialog.setText(String.format(getText(3), getText(6)));
        }
    }
}
