package rooms;

import Items.Items;

import java.util.ArrayList;

public class Bathroom extends Room {

    private final Items glasses = new Items();
    private final Items bathroomKey = new Items();



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
