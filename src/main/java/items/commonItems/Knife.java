package items.commonItems;

import items.Item;

public class Knife extends Item {

    public Knife(){
        this.id = ++idCount;
        setName("Knife");
        setDesc("Looks barely sharp enough to cut an apple");
        setPickable(true);
        itemList.add(this);
    }

}
