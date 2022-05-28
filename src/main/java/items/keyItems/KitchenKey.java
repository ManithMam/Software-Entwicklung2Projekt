package items.keyItems;

import items.Item;

public class KitchenKey extends Item {

    public KitchenKey(){
        this.id = ++idCount;
        setName("Kitchen key");
        setDesc("A key to access the kitchen");
        setPickable(true);
        itemList.add(this);
    }

}
