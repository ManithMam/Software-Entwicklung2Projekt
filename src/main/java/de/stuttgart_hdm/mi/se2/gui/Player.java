package de.stuttgart_hdm.mi.se2.gui;

import de.stuttgart_hdm.mi.se2.items.Item;
import de.stuttgart_hdm.mi.se2.rooms.Room;

import java.util.List;

public class Player {


/*
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

 */
/*
    private String inspectRoom() {
        return this.currentRoom.getDescription();
    }

 */

    private String inspectItem(Item item) {
        return item.getDesc();
    }
/*
    private void pickUpItem(Item item) {
        this.currentRoom.removeItem(item);
        inventory.add(item);
        System.out.println("You picked up " + item);
    }

 */

}
