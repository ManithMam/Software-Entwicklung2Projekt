package items.furniture;

import items.Furniture;

public class Chair extends Furniture {

    public Chair(){
        this.id = ++idCount;
        setName("Chair");
        setDesc("Doesn't look too comfortable");
        furnitureList.add(this);
    }

}
