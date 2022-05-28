package items.commonItems;

import items.Item;

public class Glasses extends Item {

    public Glasses(){
        this.id = ++idCount;
        setName("Glasses");
        setDesc("Maybe with these I could understand what I saw in her");
        setPickable(true);
        itemList.add(this);
    }

}
