package classes;

import Items.Items;
import rooms.Room;

import java.util.HashSet;

public class Player {
    private Room currentRoom;
    private final HashSet<Items> inventory;

    public Player(Room currentRoom, HashSet<Items> inventory) {
        this.currentRoom = currentRoom;
        this.inventory = inventory;
    }

    //TODO: Room could be accessible or inaccessible
    // -> Accessibility not yet implemented
    //private void changeRoom(Room newRoom) {
   //     this.currentRoom = newRoom;
   // }

    private void inspectRoom() {
        System.out.println(this.currentRoom.getDescription());
    }

    private void inspectItem(Items item) {
        item.getDesc();
    }

    private void pickUpItem(Items item) {
        inventory.add(item);
    }

    //TODO: Room accessibility not yet implemented
    private void useItem(Room lockedRoom, Items item) {

    }


}
