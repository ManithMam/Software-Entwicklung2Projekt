package items.commonItems;

import items.Item;

public class Hammer extends Item {

    public Hammer(){
        this.id = ++idCount;
        setName("Rope");
        setDesc("A strong rope that could be useful later");
        setPickable(true);
        itemList.add(this);
    }

}
