package items.commonItems;

import items.Item;

public class Rope extends Item {

    public Rope(){
        this.id = ++idCount;
        setName("Rope");
        setDesc("A strong rope that could be useful later");
        setPickable(true);
        itemList.add(this);
    }

}
