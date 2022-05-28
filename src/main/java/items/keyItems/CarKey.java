package items.keyItems;

import items.Item;

public class CarKey extends Item {

    public CarKey(){
        this.id = ++idCount;
        setName("Car key");
        setDesc("A key to my Benz AMG");
        setPickable(true);
        itemList.add(this);
    }

}
