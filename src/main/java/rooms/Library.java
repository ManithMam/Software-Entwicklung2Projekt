package rooms;

import classes.Items;

public class Library extends Room {

    Items cookbook = new Items();

    public Library()
    {
        setId(3);
        setAccess(false);
        setName("Library");
        setDescription("You should read something");
        addItemsInRoom(cookbook);
    }

    public String openDoor(Items keyItem, Room currentRoom)
    {
        if(currentRoom.getId() == this.getId())
        {
            if(keyItem.getItemId() == Library.getItemId())
            {
                this.setAccess(true);
                return "You now have Access to the Library!";
            }
        }

        return "You can't open the Door";
    }

}
