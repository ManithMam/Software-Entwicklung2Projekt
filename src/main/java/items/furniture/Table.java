package items.furniture;

import items.Item;

public class Table extends Item {

    public Table(){
        this.id = ++idCount;
        setName("Table");
        setPickable(false);
        setDesc("A sturdy wooden table");
        furnitureList.add(this);
    }

}
