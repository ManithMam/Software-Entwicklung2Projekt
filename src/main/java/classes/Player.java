package classes;

import Items.Items;
import rooms.Room;

import java.util.ArrayList;

public class Player {
    private Room currentRoom;
    private final ArrayList<Items> inventory;

    public Player(Room currentRoom, ArrayList<Items> inventory) {
        this.currentRoom = currentRoom;
        this.inventory = inventory;
    }

    private void changeRoom(Room newRoom) {
        if(newRoom.getAccess()){
            this.currentRoom = newRoom;
        }
        else if(itemInInventory(newRoom.neededItem())){
            newRoom.setAccess(true);
            this.currentRoom = newRoom;
        }
        else{
            System.out.println("This room is not accessible. It appears the door is locked.");
        }
    }
    private boolean itemInInventory(int itemId){
        for(int i = 0; i < inventory.size(); i++){
            if(inventory.get(i).getId() == itemId){
                return true;
            }
        }
        return false;
    }

    private void inspectRoom() {
        System.out.println(this.currentRoom.getDescription());
    }

    private void inspectItem(Items item) {
        item.getDesc();
    }

    private void pickUpItem(Items item) {

        inventory.add(item);
    }

}
