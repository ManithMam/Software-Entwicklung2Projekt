package items.furniture;

import items.Item;

public class Chair extends Item {

    public Chair(){
        this.id = ++idCount;
        setName("Chair");
        setPickable(false);
        setDesc("Doesn't look too comfortable");
        furnitureList.add(this);
    }

}
