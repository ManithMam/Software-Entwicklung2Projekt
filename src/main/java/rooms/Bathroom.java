package rooms;

import items.Item;
import items.keyItems.BathroomKey;
import items.commonItems.Glasses;

public class Bathroom extends Room {

    private final Item glasses = new Glasses();
    private final Item bathroomKey = new BathroomKey();



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
