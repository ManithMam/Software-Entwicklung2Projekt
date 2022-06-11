package items.furniture;

import items.Item;

public class Sofa extends Item {

    public Sofa(){
        this.id = ++idCount;
        setName("Sofa");
        setPickable(false);
        setDesc("I could rest here for a while");
        furnitureList.add(this);
    }

}
