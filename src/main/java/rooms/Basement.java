package rooms;

import items.Item;
import items.commonItems.BaseballBat;
import items.keyItems.KitchenKey;
import items.commonItems.Rope;

public class Basement extends Room {

    private final Item baseballbat = new BaseballBat();
    private final Item kitchenKey = new KitchenKey();
    private final Item rope = new Rope();

    public Basement() {
        this.id = ++idCounter;
        setAccess(true);
        setName("Basement");
        setDescription("This is the last Level");
        addItemsInRoom(baseballbat);
        addItemsInRoom(kitchenKey);
        addItemsInRoom(rope);
    }

    public int neededItem()
    {
        return 0;
    }
}
