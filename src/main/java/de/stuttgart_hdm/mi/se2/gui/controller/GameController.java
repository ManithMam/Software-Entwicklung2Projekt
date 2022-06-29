package de.stuttgart_hdm.mi.se2.gui.controller;

import de.stuttgart_hdm.mi.se2.gui.Audio;
import de.stuttgart_hdm.mi.se2.gui.Utils;
import de.stuttgart_hdm.mi.se2.gui.model.GameModel;
import de.stuttgart_hdm.mi.se2.gui.Resource;
import de.stuttgart_hdm.mi.se2.gui.view.GameView;
import de.stuttgart_hdm.mi.se2.rooms.Room;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


//TODO add documentation
public class GameController {

    Logger log = LogManager.getLogger(GameController.class);

    private GameModel gameModel;
    private GameView gameView;


    @FXML
    private Label currentRoomLabel, currentRoom, inventoryLabel, dialog;
    @FXML
    private Button  btnBackToMenu, btnOptionsInGame, btnChangeRoom, btnInspect, btnUse, btnPickUp, btnPickRoom;
    @FXML
    private ListView roomView, invView;


    @FXML
    private void initialize() {
        gameModel = GameModel.getGameModel();
        gameView = GameView.getGameView();

        btnBackToMenu.setOnAction(event -> {
            Audio.playAudio();
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
            Audio.playAudio();
            log.info(getText(15));
            Parent root = Utils.loadFxml(Resource.OPTION_SCREEN);
            GameView.getPrimaryStage().getScene().setRoot(root);
            root.requestFocus();
        });

        btnChangeRoom.setOnAction(this::changeRoom);

        btnInspect.setOnAction(this::inspect);

        btnPickUp.setOnAction(this::pickUp);

        btnPickRoom.setOnAction(this::pickRoom);

        try {
            roomView.setItems(gameModel.getItemsInSelectedRoom(gameModel.getCurrentRoom()));
        } catch (IllegalArgumentException e) {
            log.error(e);
            Parent root = Utils.loadFxml(Resource.ERROR_SCREEN);
            GameView.getPrimaryStage().getScene().setRoot(root);
            root.requestFocus();
        }
        roomView.setOnMouseClicked(mouseEvent -> {
            Audio.playAudio();
            gameView.setRoomViewSelected(true);
            gameView.setInvViewSelected(false);
            btnPickUp.setText("Pick Up");
            dialog.setText(getText(18));
        });

        invView.setItems(gameModel.getInventory());
        invView.setOnMouseClicked(mouseEvent -> {
            Audio.playAudio();
            gameView.setRoomViewSelected(false);
            gameView.setInvViewSelected(true);
            btnPickUp.setText("Drop");
            dialog.setText(getText(18));
        });

        inventoryLabel.setText(String.format(getText(7), gameModel.getInventory().size()));
        currentRoom.setText(gameModel.getRoomName(gameModel.getCurrentRoom()));
        dialog.setText(gameModel.getRoomDescription(gameModel.getCurrentRoom()));
    }

    private String getText(int number) {
        switch (number) {
            case 0 -> {return "Please select a room and use \"Pick Room\" button!";}
            case 1 -> {return "Please select a room!";}
            case 2 -> {return "You cant pick that up.";}
            case 3 -> {return "The room is locked!%n%s%nMaybe i can find something to open it...";}
            case 4 -> {return "Select Item!";}
            case 5 -> {return "No case: %d available";}
            case 6 -> {return "ERROR";}
            case 7 -> {return "Inventory (%d/3)";}
            case 8 -> {return "Current room: ";}
            case 9 -> {return "Changed access rights of %s to true.";}
            case 10 -> {return "Pick Room button was pressed";}
            case 11 -> {return "Previous room: ";}
            case 12 -> {return "";}
            case 13 -> {return "Change Room button was pressed";}
            case 14 -> {return "Inspect button was pressed";}
            case 15 -> {return "Option button was pressed in game";}
            case 16 -> {return "Back to Menu button was pressed in game";}
            case 17 -> {return "Pick up button was pressed";}
            case 18 -> {return "Use Ctr-Click to unselect Item!";}
            default -> throw new IllegalArgumentException(String.format(getText(5), number));
        }
    }

    private void showDesc(Object object) {
        try {
            dialog.setText(gameModel.getItemDescription(object));
        } catch (IllegalArgumentException e) {
            log.error(e);
            dialog.setText(getText(6));
        }
    }

    private void showItemsInSelectedRoom() {
        try {
            roomView.setItems(gameModel.getItemsInSelectedRoom(getSelected()));
        } catch (IllegalArgumentException e) {
            log.error(e);
            Parent root = Utils.loadFxml(Resource.ERROR_SCREEN);
            GameView.getPrimaryStage().getScene().setRoot(root);
            root.requestFocus();
        }
    }

    private Object getSelected() {
        if (gameView.isRoomViewSelected()) {
            return roomView.getSelectionModel().getSelectedItem();
        } else if (gameView.isInvViewSelected()) {
            return invView.getSelectionModel().getSelectedItem();
        } else {
            throw new IllegalArgumentException("roomView or invView where not selected");
        }
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

    private void changeRoom(ActionEvent event) {
        Audio.playAudio();
        log.info(getText(13));
        if (btnPickRoom.isVisible()) {
            dialog.setText(getText(0));
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

        currentRoomLabel.setText(getText(11));
        try {
            currentRoom.setText(gameModel.getRoomName(gameModel.getCurrentRoom()));
        } catch (IllegalArgumentException e) {
            log.error(e);
            currentRoom.setText(getText(8));
        }
    }

    private void inspect(ActionEvent event) {
        Audio.playAudio();
        log.info(getText(14));
        if (gameView.isRoomViewSelected()) {
            showDesc(getSelected());
        } else if (gameView.isInvViewSelected()) {
            showDesc(getSelected());
        } else {
            dialog.setText(getText(4));
        }
    }

    private void pickUp(ActionEvent event) {
        Audio.playAudio();
        log.info(getText(17));
        try {
            if (gameView.isRoomViewSelected()) {
                if (gameModel.isItemMovable(getSelected()) && gameModel.getInventory().size() < 3) {
                    gameModel.pickUp(getSelected(), true);
                    inventoryLabel.setText(String.format(getText(7), gameModel.getInventory().size()));
                    dialog.setText(getText(12));
                } else {
                    dialog.setText(getText(2));
                }
            } else if (gameView.isInvViewSelected()) {
                gameModel.pickUp(getSelected(), false);
                inventoryLabel.setText(String.format(getText(7), gameModel.getInventory().size()));
                dialog.setText(getText(12));
            } else {
                dialog.setText(getText(4));
            }
        } catch (IllegalArgumentException e) {
            log.error(e);
            dialog.setText(getText(4));
        }

        gameView.setInvViewSelected(false);
        gameView.setRoomViewSelected(false);
    }

    private void pickRoom(ActionEvent event) {
        Audio.playAudio();
        log.info(getText(10));

        if (gameView.isRoomViewSelected()) {
            try {
                if (gameModel.getRoomAccess(getSelected())) {
                    gameModel.setCurrentRoom(getSelected());
                    roomSelection();
                    currentRoomLabel.setText(getText(8));
                    currentRoom.setText(gameModel.getRoomName(gameModel.getCurrentRoom()));
                    dialog.setText(gameModel.getRoomDescription(gameModel.getCurrentRoom()));
                    showItemsInSelectedRoom();
                    // } else if (gameModel.getInventory().stream().map(item -> gameModel.getItemId(item)).anyMatch(item -> gameModel.getNededItem(getSelected()).contains(item))) {
                } else if(gameModel.getInventory().stream().map(item -> gameModel.getItemId(item)).toList().containsAll(gameModel.getNeededItem(getSelected())) || gameModel.isCheatMode()) {
                    if(!gameModel.getExit(getSelected())) {
                        gameModel.setCurrentRoom(getSelected());
                        gameModel.setRoomAccess(gameModel.getCurrentRoom());
                        try {
                            log.info(String.format(getText(9), gameModel.getRoomName(gameModel.getCurrentRoom())));
                        } catch (IllegalArgumentException e) {
                            log.error(e);
                        }
                        roomSelection();
                        currentRoomLabel.setText(getText(8));
                        currentRoom.setText(gameModel.getRoomName(gameModel.getCurrentRoom()));
                        dialog.setText(gameModel.getRoomDescription(gameModel.getCurrentRoom()));
                        showItemsInSelectedRoom();
                    } else {

                        gameModel.stopThread();
                        Parent root = Utils.loadFxml(Resource.WINNING_SCREEN);
                        GameView.getPrimaryStage().getScene().setRoot(root);
                        root.requestFocus();
                    }

                } else {
                    try {
                        dialog.setText(String.format(getText(3), gameModel.getRoomDoorDescription(getSelected())));
                    } catch (IllegalArgumentException e) {
                        log.error(e);
                        dialog.setText(String.format(getText(3), getText(6)));
                    }
                }
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
}
