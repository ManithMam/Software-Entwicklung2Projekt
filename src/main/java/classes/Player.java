package classes;

import Items.Items;
import rooms.Room;

import java.util.List;

public class Player {
    private Room currentRoom;
    private final List<Items> inventory;

    public Player(Room currentRoom, List<Items> inventory) {
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
        for (Items itemInInventory : inventory) {
            if (itemInInventory.getId() == keyItemId) {
                return true;
            }
        }
        return false;
    }

    private String inspectRoom() {
        return this.currentRoom.getDescription();
    }

    private String inspectItem(Items item) {
        return item.getDesc();
    }

    private void pickUpItem(Items item) {
        this.currentRoom.removeItem(item);
        inventory.add(item);
        System.out.println("You picked up " + item);
    }

}
