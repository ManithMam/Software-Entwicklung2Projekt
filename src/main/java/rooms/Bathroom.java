package rooms;

import Items.Items;

public class Bathroom extends Room {

    Items glasses = new Items();
    Items bathroomKey = new Items();

    public Bathroom() {
        setId(1);
        setAccess(false);
        setName("Bathroom");
        setDescription("This is the Bathroom");
        addItemsInRoom(glasses);
    }

    public int neededItem()
    {
        return bathroomKey.getId();
    }
}
