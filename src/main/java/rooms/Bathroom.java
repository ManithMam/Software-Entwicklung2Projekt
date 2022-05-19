package rooms;

import classes.Items;

public class Bathroom extends Room {

    Items glasses = new Items();

    public Bathroom() {
        setId(1);
        setAccess(false);
        setName("Bathroom");
        setDescription("This is the Bathroom");
        addItemsInRoom(glasses);
    }
/*
    public String openDoor(Items keyItem, Room currentRoom) {
        if (currentRoom.getId() == this.getId()) {
            if (keyItem.getItemId() == KitchenKey.getItemId()) {
                this.setAccess(true);
                return "You now have Access to the Bathroom!";
            }
        }

        return "You can't open the Door";
    }
 */
}
