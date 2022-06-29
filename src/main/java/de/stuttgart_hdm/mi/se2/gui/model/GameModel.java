package de.stuttgart_hdm.mi.se2.gui.model;

import de.stuttgart_hdm.mi.se2.gui.Resource;
import de.stuttgart_hdm.mi.se2.gui.Utils;
import de.stuttgart_hdm.mi.se2.gui.view.GameView;
import de.stuttgart_hdm.mi.se2.items.Item;
import de.stuttgart_hdm.mi.se2.rooms.Exit;
import de.stuttgart_hdm.mi.se2.rooms.Room;
import de.stuttgart_hdm.mi.se2.rooms.RoomFactory;
import de.stuttgart_hdm.mi.se2.timer.Timer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class GameModel {

    private static final Logger log = LogManager.getLogger(GameModel.class);

    private Thread thread;
    private final ObservableList<Room> roomsList;
    private final ObservableList<Item> inventory;
    private Room currentRoom;

    private boolean cheatMode;

    private static GameModel gameModel = new GameModel();

    public GameModel()
    {
        this.inventory = FXCollections.observableArrayList();
        this.roomsList = FXCollections.observableArrayList();
        this.cheatMode = false;

        try {
            final RoomFactory roomFactory = new RoomFactory();
            final Room basement = roomFactory.createRoom("Basement");
            final Room hallway = roomFactory.createRoom("Hallway");
            final Room kitchen = roomFactory.createRoom("Kitchen");
            final Room library = roomFactory.createRoom("Library");
            final Room bathroom = roomFactory.createRoom("Bathroom");
            final Room exit = roomFactory.createRoom("Exit");
            this.currentRoom = hallway;
            roomsList.add(hallway);
            roomsList.add(basement);
            roomsList.add(kitchen);
            roomsList.add(library);
            roomsList.add(bathroom);
            roomsList.add(exit);
        } catch (IllegalArgumentException e) {
            log.error(e);
            Parent root = Utils.loadFxml(Resource.ERROR_SCREEN);
            GameView.getPrimaryStage().getScene().setRoot(root);
            root.requestFocus();
        }

        Timer timer = new Timer();
        this.thread = new Thread(timer);
        thread.setDaemon(true);
    }

    public static GameModel getGameModel() {
        return gameModel;
    }

    public ObservableList<Room> getRoomsList()
    {
        return this.roomsList;
    }

    public ObservableList<Item> getInventory() {
        return this.inventory;
    }

    public boolean isCheatMode() {
        return cheatMode;
    }

    public Room getCurrentRoom() {
        return this.currentRoom;
    }

    public String getRoomName(Object object) throws IllegalArgumentException {
        if(object instanceof Room selectedRoom) {
            return selectedRoom.getName();
        } else {
            throw new IllegalArgumentException("Cant get name because provided object is not a Room");
        }
    }

    public String getRoomDescription(Object object) throws IllegalArgumentException {
        if(object instanceof Room selectedRoom) {
            return selectedRoom.getDescription();
        } else {
            throw new IllegalArgumentException("Cant get roomDescription because provided object is not a Room");
        }
    }

    public String getRoomDoorDescription(Object object) throws IllegalArgumentException{
        if(object instanceof Room selectedRoom) {
            return selectedRoom.getDoorDescription();
        } else {
            throw new IllegalArgumentException("Cant get roomDoorDescription because provided object is not a Room");
        }
    }

    public boolean getRoomAccess(Object object) throws IllegalArgumentException {
        if(object instanceof Room selectedRoom) {
            return selectedRoom.getAccess();
        } else {
            throw new IllegalArgumentException("Cant get roomAccess because provided object is not a Room");
        }
    }

    public ObservableList<Item> getItemsInSelectedRoom(Object object) throws IllegalArgumentException {
        if(object instanceof Room selectedRoom) {
            return selectedRoom.getItemsInRoom();
        } else {
            throw new IllegalArgumentException("Cant get itemsInRoom because provided object is not a Room");
        }
    }

    public List<Integer> getNeededItem(Object object) throws IllegalArgumentException {
        if(object instanceof Room selectedRoom) {
            return selectedRoom.neededItem();
        } else {
            throw new IllegalArgumentException("Cant get neededItem because provided object is not a Room");
        }
    }

    public int getItemId(Object object) throws IllegalArgumentException {
        if(object instanceof Item selectedItem) {
            return selectedItem.getId();
        } else {
            throw new IllegalArgumentException("Cant get id because provided objetc is not an Item");
        }
    }

    public String getItemName(Object object) throws IllegalArgumentException {
        if(object instanceof Item selectedItem) {
            return selectedItem.getName();
        } else {
            throw new IllegalArgumentException("Cant get item name because provided objetc is not an Item");
        }
    }

    public String getItemDescription(Object object) throws IllegalArgumentException {
        if(object instanceof Item selectedItem) {
            return selectedItem.getDesc();
        } else {
            throw new IllegalArgumentException("Cant get itemDesc because provided objetc is not an Item");
        }
    }

    public boolean isItemMovable(Object object) throws IllegalArgumentException {
        if(object instanceof Item selectedItem) {
            return selectedItem.isPickable();
        } else {
            throw new IllegalArgumentException("Cant get pickable because provided objetc is not an Item");
        }
    }

    public void setCheatMode(boolean cheatMode) {
        this.cheatMode = cheatMode;
    }

    public void setCurrentRoom(Object object) throws IllegalArgumentException {
        if(object instanceof Room selectedRoom) {
            this.currentRoom = selectedRoom;
        } else {
            throw new IllegalArgumentException("Cant set currentRoom because provided object is not a Room");
        }
    }

    public void setRoomAccess(Object object) throws IllegalArgumentException {
        if(object instanceof Room selectedRoom) {
            selectedRoom.setAccess(true);
        } else {
            throw new IllegalArgumentException("Cant set roomAccess because provided object is not a Room");
        }
    }

    public boolean getExit(Object object) {
        return object instanceof Exit;
    }

    public static void restartGame() {
        gameModel = new GameModel();
    }

    public void startThread() {
        this.thread = new Thread(new Timer());
        thread.setDaemon(true);
        this.thread.start();
    }

    public void stopThread() {
        this.thread.interrupt();
    }

    public void pickUp(Object object, boolean toInventory) throws IllegalArgumentException {
        if(object instanceof Item selectedItem && (this.getCurrentRoom().getItemsInRoom().contains(selectedItem) || this.inventory.contains(selectedItem))) {
            if (toInventory) {
                this.currentRoom.getItemsInRoom().remove(selectedItem);
                this.inventory.add(selectedItem);
                log.info(String.format("Moved item: %s from room: %s to inventory", selectedItem.getName(), this.currentRoom));
            } else {
                this.inventory.remove(selectedItem);
                this.currentRoom.getItemsInRoom().add(selectedItem);
                log.info(String.format("Moved item: %s from inventory to: %s", selectedItem.getName(), this.currentRoom));
            }
        } else {
            throw new IllegalArgumentException("Cant pickUp item because Provided object is not an Item or not in current room");
        }
    }
}
