package classes;

import items.Item;
import rooms.Room;

import java.util.List;

public class Player {
    private Room currentRoom;
    private final List<Item> inventory;

    public Player(Room currentRoom, List<Item> inventory) {
        this.currentRoom = currentRoom;
        this.inventory = inventory;
    }

    private void changeRoom(Room newRoom) {
        if(newRoom.getAccess()){
            this.currentRoom = newRoom;
        }
        else if(hasKeyInInventory(newRoom.neededItem())){
            newRoom.setAccess(true);
            this.currentRoom = newRoom;
        }
        else{
            System.out.println("This room is not accessible. It appears the door is locked.");
        }
    }
    private boolean hasKeyInInventory(int keyItemId){
        for (Item itemInInventory : inventory) {
            if (itemInInventory.getId() == keyItemId) {
                return true;
            }
        }
        return false;
    }

    private String inspectRoom() {
        return this.currentRoom.getDescription();
    }

    private String inspectItem(Item item) {
        return item.getDesc();
    }

    private void pickUpItem(Item item) {
        this.currentRoom.removeItem(item);
        inventory.add(item);
        System.out.println("You picked up " + item);
    }

}
