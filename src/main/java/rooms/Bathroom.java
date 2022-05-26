package rooms;

import Items.Items;

public class Bathroom extends Room {

    private final Items glasses = new Items();
    private final Items bathroomKey = new Items();



    public Bathroom() {
        this.id = ++idCounter;
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
