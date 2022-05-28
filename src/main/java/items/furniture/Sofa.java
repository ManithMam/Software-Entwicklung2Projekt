package items.furniture;

import items.Furniture;

public class Sofa extends Furniture {

    public Sofa(){
        this.id = ++idCount;
        setName("Sofa");
        setDesc("I could rest here for a while");
        furnitureList.add(this);
    }

}
