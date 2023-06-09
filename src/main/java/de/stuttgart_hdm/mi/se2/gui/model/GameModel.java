package de.stuttgart_hdm.mi.se2.gui.model;

import de.stuttgart_hdm.mi.se2.gui.Resource;
import de.stuttgart_hdm.mi.se2.gui.Utils;
import de.stuttgart_hdm.mi.se2.gui.view.GameView;
import de.stuttgart_hdm.mi.se2.items.Item;
import de.stuttgart_hdm.mi.se2.items.keyItems.Flashlight;
import de.stuttgart_hdm.mi.se2.rooms.Basement;
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


/**
 * Model of the game containing all the necessary data and methods for the game wo work
 */
public class GameModel {

    private static final Logger log = LogManager.getLogger(GameModel.class);

    private static GameModel gameModel = new GameModel();

    private Thread thread;
    private Timer timer;
    private Integer time; //Integer to check if null
    private final ObservableList<Room> roomsList;
    private final ObservableList<Item> inventory;
    private Room currentRoom;
    private boolean cheatMode;


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
            throw new IllegalArgumentException("Cant get id because provided object is not an Item");
        }
    }

    public String getItemName(Object object) throws IllegalArgumentException {
        if(object instanceof Item selectedItem) {
            return selectedItem.getName();
        } else {
            throw new IllegalArgumentException("Cant get item name because provided object is not an Item");
        }
    }

    public String getItemDescription(Object object) throws IllegalArgumentException {
        if(object instanceof Item selectedItem) {
            return selectedItem.getDesc();
        } else {
            throw new IllegalArgumentException("Cant get itemDesc because provided object is not an Item");
        }
    }

    public boolean isItemMovable(Object object) throws IllegalArgumentException {
        if(object instanceof Item selectedItem) {
            return selectedItem.isPickable();
        } else {
            throw new IllegalArgumentException("Cant get pickable because provided object is not an Item");
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

    /**
     * checks if currentRoom is instance of Exit
     * @return boolean
     */
    public boolean getExit() {
        return this.currentRoom instanceof Exit;
    }

    /**
     * get if current room is basement and flashlight in inventory or basement or just if current room is basement
     * @param isBasementWithFlashlight to switch between the two
     * @return if current room is basement and flashlight in inventory or basement or just if current room is basement
     */
    public boolean getBasement(boolean isBasementWithFlashlight) {
        if(isBasementWithFlashlight) {
            return this.currentRoom instanceof Basement && (this.inventory.contains(Room.getKeyItemList().stream().filter(Flashlight.class::isInstance).toList().get(0)) || this.currentRoom.getItemsInRoom().contains(Room.getKeyItemList().stream().filter(Flashlight.class::isInstance).toList().get(0)));
        } else {
            return this.currentRoom instanceof Basement;
        }
    }

    public static void restartGame() {
        gameModel = new GameModel();
    }

    /**
     * starts the thread
     * sets timeLeft in Timer if thread gets stopped and started again
     */
    public void startThread() {

        this.timer = new Timer();

        if (this.time != null) {
            this.timer.setTimeLeft(this.time);
        }

        this.thread = new Thread(timer);
        this.thread.setDaemon(true);
        this.thread.start();
    }


    /**
     * stops thread
     * sets time to current time
     */
    public void stopThread() {

        this.time = timer.getTimeLeft();
        this.timer.stop();
    }


    /**
     * adds and removes selected item from or to inventory/room
     * @param object selected item
     * @param toInventory move to inventory or room
     * @throws IllegalArgumentException if object is not item for some reason
     */
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

    /**
     * constructs string containing items used to unlock room
     * @param list list of used items
     * @return string containing items used to unlock room
     */
    public String getUsedItemNames(List<String> list) {

        StringBuilder s = new StringBuilder();

        for (int i = 0; i < list.size(); i++) {

            if (i + 1 != list.size()) {

                s.append(list.get(i)).append(", ");

            } else {

                s.append(list.get(i));
            }
        }
        return s.toString();
    }


    /**
     * returns css code to set background of selected room
     * @param object selected room
     * @return css code as string
     */
    public String getBackground(Object object) throws IllegalArgumentException {

        final String style = "-fx-background-image: url(%s);";

        if (object instanceof Room selectedRoom) {

            switch (selectedRoom.getName()) {
                case "Hallway"  -> {
                    return String.format(style, Resource.BACKGROUND_HALLWAY.getUrl());
                }
                case "Basement" -> {
                    return String.format(style, Resource.BACKGROUND_BASEMENT.getUrl());
                }
                case "Kitchen"  -> {
                    return String.format(style, Resource.BACKGROUND_KITCHEN.getUrl());
                }
                case "Library"  -> {
                    return String.format(style, Resource.BACKGROUND_LIBRARY.getUrl());
                }
                case "Bathroom" -> {
                    return String.format(style, Resource.BACKGROUND_BATHROOM.getUrl());
                }
                default -> throw new IllegalArgumentException("Background for room doesnt exist");
            }

        } else {

            throw new IllegalArgumentException("Cant get Background because provided object is not a room");
        }
    }
}
