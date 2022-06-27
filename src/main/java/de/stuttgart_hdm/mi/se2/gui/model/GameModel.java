package de.stuttgart_hdm.mi.se2.gui.model;

import de.stuttgart_hdm.mi.se2.items.Item;
import de.stuttgart_hdm.mi.se2.items.commonItems.CommonItemFactory;
import de.stuttgart_hdm.mi.se2.items.furniture.FurnitureFactory;
import de.stuttgart_hdm.mi.se2.items.keyItems.KeyItemFactory;
import de.stuttgart_hdm.mi.se2.rooms.Room;
import de.stuttgart_hdm.mi.se2.rooms.RoomFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class GameModel {

    private int roomIndex;
    private final ObservableList<Room> roomsList;
    private final ObservableList<Item> inventory;

    public static final GameModel GAME_MODEL = new GameModel();


    private final Room startingRoom;
    private Room currentRoom;


    public GameModel()
    {
        this.roomIndex = 0;
        this.inventory = FXCollections.observableArrayList();

        final RoomFactory roomFactory = new RoomFactory();
        final Room basement = roomFactory.createRoom("Basement");
        final Room hallway = roomFactory.createRoom("Hallway");
        final Room kitchen = roomFactory.createRoom("Kitchen");
        final Room library = roomFactory.createRoom("Library");
        final Room bathroom = roomFactory.createRoom("Bathroom");
        final Room exit = roomFactory.createRoom("Exit");
        startingRoom = hallway;
        this.roomsList = FXCollections.observableArrayList();
        roomsList.add(hallway);
        roomsList.add(basement);
        roomsList.add(kitchen);
        roomsList.add(library);
        roomsList.add(bathroom);
        roomsList.add(exit);

        CommonItemFactory commonItemFactory = new CommonItemFactory();
        commonItemFactory.createAllItems();
        KeyItemFactory keyItemFactory = new KeyItemFactory();
        keyItemFactory.createAllKeyItems();
        FurnitureFactory furnitureFactory = new FurnitureFactory();
        furnitureFactory.createAllFurniture();
    }

    public int getRoomIndex() {
        return this.roomIndex;
    }

    public void setRoomIndex(int index) {
        this.roomIndex = index;
    }

    public ObservableList<Room> getRoomsList()
    {
        return this.roomsList;
    }

    public ObservableList<Item> getInventory() {
        return this.inventory;
    }

    public static GameModel getModel() {return GAME_MODEL;}

    public int getItemId(Item selectedItem) {
        return selectedItem.getId();
    }

    public String getRoomName(Room selectedRoom) {
        return selectedRoom.getName();
    }

    public String getItemName(Item selectedItem) {
        return selectedItem.getName();
    }

    public boolean getRoomAccess(Room selectedRoom) {
        return selectedRoom.getAccess();
    }

    public ObservableList<Item> getItemsInSelectedRoom(Room selectedRoom) {
        return selectedRoom.getItemsInRoom();
    }

    public String getRoomDescription(Room selectedRoom) {
        return selectedRoom.getDescription();
    }

    public List<Integer> getNededItem(Room selectedRoom) {
        return selectedRoom.neededItem();
    }

    public String getItemDescription(Item selectedItem) {
        return selectedItem.getDesc();
    }

    public boolean isItemMovable(Item selectedItem) {
        return selectedItem.isPickable();
    }

    public void setRoomAccess(Room selectedRoom) {
        selectedRoom.setAccess(true);
    }


    public void pickUp(GameModel gameModel, Item selectedItem, boolean toInventory) {
        if(toInventory) {
            gameModel.getItemsInSelectedRoom(gameModel.getRoomsList().get(gameModel.getRoomIndex())).remove(selectedItem);
            gameModel.getInventory().add(selectedItem);
        } else {
            gameModel.getInventory().remove(selectedItem);
            gameModel.getItemsInSelectedRoom(gameModel.getRoomsList().get(gameModel.getRoomIndex())).add(selectedItem);
        }
    }
}
