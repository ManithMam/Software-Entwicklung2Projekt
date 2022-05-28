package items.keyItems;

import items.Item;

public class BathroomKey extends Item {

    public BathroomKey(){
        this.id = ++idCount;
        setName("Bathroom key");
        setDesc("A key to access the bathroom");
        setPickable(true);
        itemList.add(this);
    }

}
